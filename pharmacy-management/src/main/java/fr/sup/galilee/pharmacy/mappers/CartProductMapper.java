package fr.sup.galilee.pharmacy.mappers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.sup.galilee.pharmacy.dtos.CartProductDTO;
import fr.sup.galilee.pharmacy.entities.Cart;
import fr.sup.galilee.pharmacy.entities.CartProduct;
import fr.sup.galilee.pharmacy.entities.Product;
import fr.sup.galilee.pharmacy.repositories.CartRepository;
import fr.sup.galilee.pharmacy.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Component
@Scope("prototype")
@AllArgsConstructor
public class CartProductMapper {
	private final CartRepository cartRepository;
	private final ProductRepository productRepository;
	
	public CartProduct toEntity(CartProductDTO cartproductdto) {
		CartProduct cartproduct =new CartProduct();
		Cart cart=cartRepository.findById(cartproductdto.getCart().getId())
		.orElseThrow(() -> new EntityNotFoundException("Cart not found"));
		
		Product produit=productRepository.findById(cartproductdto.getProduct().getId())
		.orElseThrow(() -> new EntityNotFoundException("Product not found"));
		
		cartproduct.setId(cartproductdto.getId());
		cartproduct.setQuantity(cartproductdto.getQuantity());
		cartproduct.setCart(cart);
		cartproduct.setProduct(produit);
	
		
		return cartproduct;
	}
	
   public CartProductDTO toDto(CartProduct cartproduct) {
	   CartProductDTO.CartProductDTOBuilder cartproductdto=CartProductDTO.builder()
			   .id(cartproduct.getId())
			   .quantity(cartproduct.getQuantity())
			   .cart(cartproduct.getCart())
			   .product(cartproduct.getProduct());
	   return cartproductdto.build();
	   }
}
