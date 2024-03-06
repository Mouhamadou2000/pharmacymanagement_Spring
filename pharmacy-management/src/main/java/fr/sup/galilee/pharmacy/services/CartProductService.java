package fr.sup.galilee.pharmacy.services;

import java.util.List;
import java.util.Optional;

import fr.sup.galilee.pharmacy.entities.CartProduct;
import fr.sup.galilee.pharmacy.mappers.CartMapper;
import fr.sup.galilee.pharmacy.mappers.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sup.galilee.pharmacy.dtos.CartProductDTO;
import fr.sup.galilee.pharmacy.entities.Cart;
import fr.sup.galilee.pharmacy.entities.Product;
import fr.sup.galilee.pharmacy.mappers.CartProductMapper;
import fr.sup.galilee.pharmacy.repositories.CartProductRepository;
import fr.sup.galilee.pharmacy.repositories.CartRepository;
import fr.sup.galilee.pharmacy.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartProductService {

	private final CartProductMapper cartproductMapper;
	private final CartProductRepository cartproductRepository;
	private final CartRepository cartRepository;
	private final ProductRepository productRepository;
	private final ProductService productService;
	private final ProductMapper productMapper;
	private final CartService cartService;
	private final CartMapper cartMapper;
	
	
	
	@Transactional(readOnly=true)
	public List<CartProductDTO> findAll(){
		return cartproductRepository.findAll()
				.stream()
				.map(cartproductMapper::toDto)
				.toList();
	}
	
	@Transactional
	public CartProductDTO findById(Long idProduct,String idCart) {

		CartProduct cartProduct=cartproductRepository.findCartProductByCart_IdAndProduct_Id(idCart,idProduct);
		if(cartProduct!=null){
			Integer quantity=cartProduct.getQuantity()+1;
			cartProduct.setQuantity(quantity);

			cartproductRepository.save(cartProduct);
			Product product=productMapper.toEntity(productService.findById(idProduct));
			product.setQuantity(product.getQuantity()-1);
			productRepository.save(product);
			return cartproductMapper.toDto(cartProduct);
		}
		else {
			cartProduct=new CartProduct();
			Product product=productMapper.toEntity(productService.findById(idProduct));
			Cart cart=cartMapper.toEntity(cartService.findById(idCart));
			cartProduct.setQuantity(1);
			cartProduct.setProduct(product);
			cartProduct.setCart(cart);
			product.setQuantity(product.getQuantity()-1);
			productRepository.save(product);
			cartproductRepository.save(cartProduct);
			return  cartproductMapper.toDto(cartProduct);
		}
	}
	
	@Transactional
	public void  insert(CartProductDTO cartproductdto) {
		
		cartproductRepository.save(cartproductMapper.toEntity(cartproductdto));
	}
	@Transactional
	public void  update(CartProductDTO cartproductdto) {
		cartproductRepository.findById(cartproductdto.getId())
			.ifPresent(
					cartproduct ->{
						Cart cart=cartRepository.findById(cartproductdto.getCart().getId())
								.orElseThrow(() -> new EntityNotFoundException("Cart not found"));
						Product produit=productRepository.findById(cartproductdto.getProduct().getId())
								.orElseThrow(() -> new EntityNotFoundException("Product not found"));
						cartproduct.setId(cartproductdto.getId());
						cartproduct.setQuantity(cartproductdto.getQuantity());
						cartproduct.setCart(cart);
						cartproduct.setProduct(produit);
						cartproductRepository.save(cartproduct);	
					}
			      );
	}
	
	@Transactional
	public void  deleteById(Long id) {
		cartproductRepository.deleteById(id);
	}
	@Transactional
	public void update1(Long id) {
		CartProduct cartProduct=cartproductRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
		cartProduct.setQuantity(cartProduct.getQuantity()-1);
		cartproductRepository.save(cartProduct);

	}
	@Transactional
	public void deleteById2(List<CartProductDTO> cartProductDTOList) {
		int size=cartProductDTOList.size();
		for(CartProductDTO carproductdto : cartProductDTOList){
			deleteById(carproductdto.getId());
		}

	}
}
