package fr.sup.galilee.pharmacy.services;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sup.galilee.pharmacy.dtos.ProductDTO;
import fr.sup.galilee.pharmacy.mappers.ProductMapper;
import fr.sup.galilee.pharmacy.repositories.ProductRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	private final ProductMapper productMapper;
	
	
	@Transactional(readOnly=true)
	public List<ProductDTO> findAll(){
		return productRepository.findAll()
				.stream()
				.map(productMapper::toDto)
				.toList();
				
	}
	
	@Transactional(readOnly=true)
	public ProductDTO findById(Long id) {
		return productRepository.findById(id).map(productMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
	}
	
	@Transactional
	public void  insert(ProductDTO productdto) {
		productRepository.save(productMapper.toEntity(productdto));
	}
	
	@Transactional
	public void  update(ProductDTO productdto) {
		productRepository.findById(productdto.getId())
			.ifPresent(
					product ->{
						product.setName(productdto.getName());
						product.setPrice(productdto.getPrice());
						product.setQuantity(productdto.getQuantity());
						productRepository.save(product);	
					}
			      );
	}

	@Transactional
	public void  deleteById(Long id) {
		productRepository.deleteById(id);
	}
}
