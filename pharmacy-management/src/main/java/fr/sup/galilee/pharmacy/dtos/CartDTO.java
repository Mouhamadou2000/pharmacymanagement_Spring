package fr.sup.galilee.pharmacy.dtos;

import fr.sup.galilee.pharmacy.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class CartDTO {

	private String id;// plus securise
	private User user;
}
