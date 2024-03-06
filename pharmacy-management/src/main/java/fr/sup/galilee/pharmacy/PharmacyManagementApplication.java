package fr.sup.galilee.pharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//S@ComponentScan(basePackages = {"fr.sup.galilee.pharmacy", "fr.sup.galilee.pharmacy.web"})
public class PharmacyManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(PharmacyManagementApplication.class, args);
	}

}
