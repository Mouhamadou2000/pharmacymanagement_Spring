package fr.sup.galilee.pharmacy.mappers;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.sup.galilee.pharmacy.dtos.CartDTO;
import fr.sup.galilee.pharmacy.dtos.CartProductDTO;
import fr.sup.galilee.pharmacy.entities.Cart;
import lombok.AllArgsConstructor;



@Component
@Scope("prototype")
@AllArgsConstructor
public class CartMapper {
	
	
	public Cart toEntity(CartDTO cartdto) {
		 Cart cart =new Cart();

		 cart.setId(cartdto.getId());
		 cart.setUser(cartdto.getUser());
	
		
		return cart;
	}
	
    public CartDTO toDto(Cart cart) {
    	
    	CartDTO.CartDTOBuilder cartdtobuilder=CartDTO.builder()
    			.id(cart.getId())
    			.user(cart.getUser());
		return cartdtobuilder.build();
	}

}
