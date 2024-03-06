package fr.sup.galilee.pharmacy.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private Integer quantity;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Cart cart;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Product product ;
	
}
