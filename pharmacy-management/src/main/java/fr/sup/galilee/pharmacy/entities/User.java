package fr.sup.galilee.pharmacy.entities;

import fr.sup.galilee.pharmacy.enums.Userprofile;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
public class User {
	
	//@GeneratedValue(generator = "uuid")
	//@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false,name="firstname")
	private String firstname;
	@Column(nullable=false,name="lastname")
	private String lastname;
	@Column(nullable=false,name="email")
	private String email;
	@Column(nullable=false,unique=true,name="password")
	private String password;
	@Column(nullable=false,name="active")
	private boolean active;
	//@Enumerated
	@Column(nullable=false)
	private String profile;
	

}
