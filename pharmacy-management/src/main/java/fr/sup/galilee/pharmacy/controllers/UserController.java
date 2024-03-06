package fr.sup.galilee.pharmacy.controllers;

import java.util.List;
import java.util.Optional;


import fr.sup.galilee.pharmacy.entities.User;
import fr.sup.galilee.pharmacy.mappers.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sup.galilee.pharmacy.dtos.UserDTO;
import fr.sup.galilee.pharmacy.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("User")
@AllArgsConstructor
public class UserController {
	
	private final UserService userService;
	private final UserMapper userMapper;
	
	@GetMapping(path= "login/{passwordData}")
	public ResponseEntity<?> getbyEmalAndPassword(@PathVariable ("passwordData") String password){
		UserDTO user=userMapper.toDto(userService.getbyPassword(password));
		if(user!=null)
			return ResponseEntity.ok(user);
		else
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

	}
	
	@GetMapping(path= "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public UserDTO getById(@PathVariable("id") Long id){
		return userService.findById(id);
		
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> add(@RequestBody UserDTO userdto) {
		userService.insert(userdto);
		return ResponseEntity.ok(userdto);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserDTO put(@RequestBody UserDTO userdto) {
		userService.update(userdto);
		return userdto;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteById(id);
	}
}
