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

import fr.sup.galilee.pharmacy.dtos.CartProductDTO;
import fr.sup.galilee.pharmacy.services.CartProductService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("CartProduct")
@AllArgsConstructor
public class CartProductController {
	
	private final CartProductService cartproductService;
	
	@GetMapping
	public List<CartProductDTO> getAll(){
		return cartproductService.findAll();
		
	}
	
	@GetMapping(path= "/{idProduct}/{idCart}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartProductDTO> getById(@PathVariable("idProduct") Long idProduct,@PathVariable("idCart") String idCart){
		CartProductDTO cartProductDTO=cartproductService.findById(idProduct,idCart);
		return ResponseEntity.ok(cartProductDTO);
		
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CartProductDTO> add(@RequestBody CartProductDTO cartproductdto) {
		cartproductService.insert(cartproductdto);
		return ResponseEntity.ok(cartproductdto);
	}
	
	@PutMapping(path="/DeleteAll",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void put(@RequestBody List<CartProductDTO> cartProductDTOList) {
		cartproductService.deleteById2(cartProductDTOList);

	}

	@PutMapping(path="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void put(@PathVariable Long id) {
		cartproductService.update1(id);

	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		cartproductService.deleteById(id);
	}





}
