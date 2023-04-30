package tdtu.edu.vn.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import tdtu.edu.vn.entity.Cart;
import tdtu.edu.vn.entity.Oder;
import tdtu.edu.vn.entity.OrderDetail;
import tdtu.edu.vn.repository.OrderRepository;
import tdtu.edu.vn.service.CartService;
import tdtu.edu.vn.service.OrderService;

@SessionScope
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Oder add(Oder item) {
		return orderRepository.save(item);
	}

	@Override
	public boolean remove(Long id) {
		Optional<Oder> removeOder = orderRepository.findById(id);
		if (removeOder.isPresent()) {
			orderRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Oder update(Oder oder) {
		
		return orderRepository.save(oder);
	}

	@Override
	public boolean clear() {
		List<Oder> carts = orderRepository.findAll();

		if (carts.size() > 0) {
			orderRepository.deleteAll();
			return true;
		}
		return false;
	}

	@Override
	public List<Oder> getAllOrder() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}
	@Override
	public Oder getNewOrder() {
		// TODO Auto-generated method stub
		int n=orderRepository.findAll().size();
		return orderRepository.findAll().get(n-1);
	}
}
