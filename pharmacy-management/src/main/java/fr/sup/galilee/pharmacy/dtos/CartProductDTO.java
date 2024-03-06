package fr.sup.galilee.pharmacy.dtos;

import fr.sup.galilee.pharmacy.entities.Cart;
import fr.sup.galilee.pharmacy.entities.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CartProductDTO {

	private Long id;
	private  Cart cart;
	private Integer quantity;
	private Product product;
}
