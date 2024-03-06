package fr.sup.galilee.pharmacy.dtos;

import fr.sup.galilee.pharmacy.enums.Userprofile;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {
	
	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private boolean active;
	private String profile;
	
	
}
