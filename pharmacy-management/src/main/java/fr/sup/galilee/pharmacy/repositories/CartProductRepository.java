package fr.sup.galilee.pharmacy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.sup.galilee.pharmacy.entities.CartProduct;


@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Long>{
	List<CartProduct> findByCartId(String cartId);
	CartProduct findCartProductByCart_IdAndProduct_Id(String id,Long idp);

}
