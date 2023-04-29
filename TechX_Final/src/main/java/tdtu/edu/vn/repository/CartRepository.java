package tdtu.edu.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tdtu.edu.vn.entity.Cart;
import tdtu.edu.vn.entity.OrderDetail;

public interface CartRepository extends JpaRepository<OrderDetail, Long> {
	
}
