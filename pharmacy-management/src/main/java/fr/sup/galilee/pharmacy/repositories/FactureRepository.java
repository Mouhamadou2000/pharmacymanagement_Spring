package fr.sup.galilee.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sup.galilee.pharmacy.entities.Facture;


@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

}
