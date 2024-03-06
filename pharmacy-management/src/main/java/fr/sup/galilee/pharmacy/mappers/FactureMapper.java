package fr.sup.galilee.pharmacy.mappers;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.sup.galilee.pharmacy.dtos.FactureDTO;
import fr.sup.galilee.pharmacy.entities.Facture;

@Component
@Scope("prototype")
public class FactureMapper {
	
	public Facture  toEntity(FactureDTO facturedto) {
		Facture facture =new Facture();
		facture.setId(facturedto.getId());
		facture.setValue(facturedto.getValue());
		facture.setDate(facturedto.getDate());
		facture.setUser(facturedto.getUser());
	
		
		return facture;
	}
	
	
	public FactureDTO  toDto(Facture facture) {
		FactureDTO.FactureDTOBuilder facturedtobuilder=FactureDTO.builder()
				.id(facture.getId())
				.value(facture.getValue())
				.date(facture.getDate())
				.user(facture.getUser());
		
		return facturedtobuilder.build();
	}
	
	

}
