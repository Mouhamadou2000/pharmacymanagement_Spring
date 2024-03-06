package fr.sup.galilee.pharmacy.mappers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.sup.galilee.pharmacy.dtos.ProductDTO;
import fr.sup.galilee.pharmacy.entities.Product;

@Component
@Scope("prototype")
public class ProductMapper {
	
	public Product toEntity(ProductDTO productdto) {
		
		Product product =new Product();
		product.setId(productdto.getId());
		product.setName(productdto.getName());
		product.setPrice(productdto.getPrice());
		product.setQuantity(productdto.getQuantity());
		
		return product;
	}
	
	public ProductDTO toDto(Product product) {
		
		ProductDTO.ProductDTOBuilder productdtobuilder=ProductDTO.builder()
				.id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.quantity(product.getQuantity());
				
		return productdtobuilder.build();
	}

}
