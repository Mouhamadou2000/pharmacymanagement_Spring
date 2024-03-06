package fr.sup.galilee.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sup.galilee.pharmacy.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
