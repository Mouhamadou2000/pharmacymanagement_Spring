package fr.sup.galilee.pharmacy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sup.galilee.pharmacy.entities.Cart;
import fr.sup.galilee.pharmacy.entities.User;


@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
	Cart findByUserId(Long UserId);
	//Cart findById(String id);


}
