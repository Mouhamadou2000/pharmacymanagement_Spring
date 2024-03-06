package fr.sup.galilee.pharmacy.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sup.galilee.pharmacy.dtos.FactureDTO;
import fr.sup.galilee.pharmacy.services.FactureService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("Facture")
@AllArgsConstructor
public class FactureController {

	private final FactureService factureService;
	
	@GetMapping
	public List<FactureDTO> getAll(){
		return factureService.findAll();
		
	}
	
	@GetMapping(path= "/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public FactureDTO getById(@PathVariable("id") Long id){
		return factureService.findById(id);
		
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public FactureDTO add(@RequestBody FactureDTO facturedto) {
		factureService.insert(facturedto);
		return facturedto;
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public FactureDTO put(@RequestBody FactureDTO facturedto) {
		factureService.update(facturedto);
		return facturedto;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		factureService.deleteById(id);
	}
}
