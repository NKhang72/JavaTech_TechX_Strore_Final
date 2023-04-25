package tdtu.edu.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tdtu.edu.vn.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	
}
