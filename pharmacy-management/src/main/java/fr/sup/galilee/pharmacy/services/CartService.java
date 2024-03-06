package fr.sup.galilee.pharmacy.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import fr.sup.galilee.pharmacy.entities.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import fr.sup.galilee.pharmacy.dtos.CartDTO;
import fr.sup.galilee.pharmacy.dtos.CartProductDTO;
import fr.sup.galilee.pharmacy.dtos.UserDTO;
import fr.sup.galilee.pharmacy.entities.Cart;
import fr.sup.galilee.pharmacy.mappers.CartMapper;
import fr.sup.galilee.pharmacy.mappers.CartProductMapper;
import fr.sup.galilee.pharmacy.mappers.UserMapper;
import fr.sup.galilee.pharmacy.repositories.CartProductRepository;
import fr.sup.galilee.pharmacy.repositories.CartRepository;
import fr.sup.galilee.pharmacy.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CartService {
	private final CartMapper cartMapper;
	private final CartRepository cartRepository;
	private final CartProductMapper cartProductMapper;
	private final UserService userservice;
	private final UserMapper userMapper;
	private final UserRepository userRepository;

	private final CartProductRepository cartProductRepository;

	
	
	@Transactional(readOnly=true)
	public List<CartDTO> findAll(){
		return cartRepository.findAll()
				.stream()
				.map(cartMapper::toDto)
				.toList();		
	}
	@Transactional(readOnly=true)
	public CartDTO findById(String id) {

		return cartRepository.findById(id).map(cartMapper::toDto).orElseThrow(() -> new EntityNotFoundException("Cart not found"));
	}
	
	
	@Transactional(readOnly=true)
	public List<CartProductDTO> findById1(String id) {

		return cartProductRepository.findByCartId(id).stream().map(cartProductMapper::toDto).toList();
	}


	
	@Transactional
	public CartDTO findById2(Long id) {

		Cart cart = cartRepository.findByUserId(id);
		 if(cart!=null) {
			 return cartMapper.toDto(cart);
		 }
		 else {
			 cart=new Cart();
			 User user = userMapper.toEntity(userservice.findById(id));
			 if(user.getId()==null) {
				 user = userRepository.save(user);
			 }
			 cart.setUser(user);
			 cart=cartRepository.save(cart);

			 return cartMapper.toDto(cart);
		 }
	}
	
	
	@Transactional
	public void  insert(CartDTO cartdto) {
		cartRepository.save(cartMapper.toEntity(cartdto));
	}

	
	@Transactional
	public void  update(CartDTO cartdto) {
		cartRepository.findById(cartdto.getId())
			.ifPresent(
					cart ->{
						cart.setId(cartdto.getId());
						 cart.setUser(cartdto.getUser());
						cartRepository.save(cart);	
					}
			      );
	}
	
	@Transactional
	public void  deleteById(String id) {
		cartRepository.deleteById(id);
	}
}
