package fr.sup.galilee.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sup.galilee.pharmacy.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUsersByPassword(String password);

}
