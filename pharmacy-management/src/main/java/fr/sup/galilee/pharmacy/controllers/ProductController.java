package fr.sup.galilee.pharmacy.controllers;

import java.util.List;
import java.util.Optional;

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

import fr.sup.galilee.pharmacy.dtos.ProductDTO;
import fr.sup.galilee.pharmacy.services.ProductService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("Product")
@AllArgsConstructor
public class ProductController {
	private final ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		List<ProductDTO> LIST =productService.findAll();
		if(LIST!=null)
			return ResponseEntity.ok(LIST);
		else
			return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");


		
	}
	
	@GetMapping(path= "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO getById(@PathVariable("id") Long id){
		return productService.findById(id);
		
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO add(@RequestBody ProductDTO productdto) {
		productService.insert(productdto);
		return productdto;
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public ProductDTO put(@RequestBody ProductDTO productdto) {
		productService.update(productdto);
		return productdto;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		productService.deleteById(id);
	}

}
