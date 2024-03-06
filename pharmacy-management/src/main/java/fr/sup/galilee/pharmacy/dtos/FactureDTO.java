package fr.sup.galilee.pharmacy.dtos;

import java.time.Instant;

import fr.sup.galilee.pharmacy.entities.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FactureDTO {
	
	private Long id;
	private float value;
	private Instant date;
	private User user;

}
