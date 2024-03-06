package fr.sup.galilee.pharmacy.services;

import java.util.List;
import java.util.Optional;


import fr.sup.galilee.pharmacy.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import fr.sup.galilee.pharmacy.dtos.UserDTO;
import fr.sup.galilee.pharmacy.mappers.UserMapper;
import fr.sup.galilee.pharmacy.repositories.UserRepository;


import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {
	
	private final UserRepository userRepository; 
	private final UserMapper userMapper;
	
	@Transactional(readOnly=true)
	public User getbyPassword(String password){
		return userRepository.findUsersByPassword(password) ;
				
	}
	
	@Transactional(readOnly=true)
	public UserDTO findById(Long id) {
		return userRepository.findById(id).map(userMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
	}
	
	@Transactional
	public void  insert(UserDTO userdto) {
		userRepository.save(userMapper.toEntity(userdto));
	}
	
	@Transactional
	public void  update(UserDTO userdto) {
		userRepository.findById(userdto.getId())
			.ifPresent(
					user ->{
						user.setLastname(userdto.getLastname());
						user.setFirstname(userdto.getFirstname());
						user.setEmail(userdto.getEmail());
						user.setPassword(userdto.getPassword());
						user.setProfile(userdto.getProfile());
						user.setActive(userdto.isActive());
						userRepository.save(user);	
					}
			      );
	}
	
	@Transactional
	public void  deleteById(Long id) {
		userRepository.deleteById(id);
	}
	
	

}
