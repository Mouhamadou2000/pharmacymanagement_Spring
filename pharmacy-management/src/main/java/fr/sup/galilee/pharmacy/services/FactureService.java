package fr.sup.galilee.pharmacy.services;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.sup.galilee.pharmacy.dtos.FactureDTO;
import fr.sup.galilee.pharmacy.mappers.FactureMapper;
import fr.sup.galilee.pharmacy.repositories.FactureRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FactureService {
	
	private final FactureRepository factureRepository;
	private final FactureMapper factureMapper;
	
	@Transactional(readOnly=true)
	public List<FactureDTO> findAll(){
		return factureRepository.findAll()
				.stream()
				.map(factureMapper::toDto)
				.toList();
				
	}
	
	@Transactional(readOnly=true)
	public FactureDTO findById(Long id) {
		return factureRepository.findById(id).map(factureMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
	}
	
	@Transactional
	public void  insert(FactureDTO facturedto) {
		factureRepository.save(factureMapper.toEntity(facturedto));
	}
	
	@Transactional
	public void  update(FactureDTO facturedto) {
		factureRepository.findById(facturedto.getId())
			.ifPresent(
					facture ->{
						facture.setId(facturedto.getId());
						facture.setValue(facturedto.getValue());
						facture.setDate(facturedto.getDate());
						facture.setUser(facturedto.getUser());
						factureRepository.save(facture);	
					}
			      );
	}
	
	@Transactional
	public void  deleteById(Long id) {
		factureRepository.deleteById(id);
	}

}
