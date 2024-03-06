package fr.sup.galilee.pharmacy.mappers;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.sup.galilee.pharmacy.dtos.UserDTO;
import fr.sup.galilee.pharmacy.entities.User;

@Component
@Scope("prototype")
public class UserMapper {

	public User  toEntity(UserDTO userdto) {
		User user =new User();
		user.setId(userdto.getId());
		user.setLastname(userdto.getLastname());
		user.setFirstname(userdto.getFirstname());
		user.setPassword(userdto.getPassword());
		user.setEmail(userdto.getEmail());
		user.setProfile(userdto.getProfile());
		user.setActive(userdto.isActive());
	
		
		return user;
	}
	
	public UserDTO toDto(User user) {
		
		UserDTO.UserDTOBuilder userdtobuider=UserDTO.builder()
				.id(user.getId())
				.lastname(user.getLastname())
				.firstname(user.getFirstname())
				.password(user.getPassword())
				.email(user.getEmail())
			    .profile(user.getProfile())
			    .active(user.isActive());
		
		return userdtobuider.build();
	}
}
