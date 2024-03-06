package fr.sup.galilee.pharmacy.controllers;

import java.util.List;
import java.util.Optional;

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

import fr.sup.galilee.pharmacy.dtos.CartDTO;
import fr.sup.galilee.pharmacy.dtos.CartProductDTO;
import fr.sup.galilee.pharmacy.services.CartService;
import lombok.AllArgsConstructor;



@RestController
@RequestMapping("Cart")
@AllArgsConstructor
public class CartController {

	private final CartService cartService;
	
	@GetMapping
	public List<CartDTO> getAll(){
		return cartService.findAll();
	}
	
	@GetMapping(path= "/Panier/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<CartProductDTO> getById(@PathVariable("id") String id){
		return cartService.findById1(id);
		
	}
	@GetMapping(path= "/Creation/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public CartDTO getById2(@PathVariable("id") Long id){
		return cartService.findById2(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartDTO> add(@RequestBody CartDTO cartdto) {
		cartService.insert(cartdto);
		return ResponseEntity.ok(cartdto);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public CartDTO put(@RequestBody CartDTO cartdto) {
		cartService.update(cartdto);
		return cartdto;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		cartService.deleteById(id);
	}

	
}
