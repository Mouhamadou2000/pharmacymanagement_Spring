package fr.sup.galilee.pharmacy.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {

		 //registry.addMapping("/**");
		 registry.addMapping("/**")
				 .allowedOriginPatterns("http://localhost:4200") // Utiliser allowedOriginPatterns pour les motifs d'origine
				 .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				 .allowedHeaders("*")
				 .allowCredentials(true)
				 .maxAge(3600);
	    }

}
