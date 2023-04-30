package tdtu.edu.vn.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import tdtu.edu.vn.entity.Cart;
import tdtu.edu.vn.entity.OrderDetail;
import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.repository.CartRepository;
import tdtu.edu.vn.service.CartService;

@SessionScope
@Service
public class CartServiceImpl implements CartService {
	@Autowired
	private CartRepository cartRepository;

	@Override
	public void add(OrderDetail item) {
			cartRepository.save(item);
	}

	@Override
	public boolean remove(Long id) {
		Optional<OrderDetail> removeCart = cartRepository.findById(id);
		if (removeCart.isPresent()) {
			cartRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public OrderDetail update(Long id, OrderDetail OrderDetail) {
		OrderDetail updateCart = cartRepository.findById(id).orElse(null);
		if (updateCart != null) {
			updateCart.setQuanity(OrderDetail.getQuanity());
			return cartRepository.save(updateCart);
		}
		return null;
	}
	@Override
	public OrderDetail updateid(OrderDetail OrderDetail) {
		return cartRepository.save(OrderDetail);
		
	}

	@Override
	public boolean clear() {
		List<OrderDetail> carts = cartRepository.findAll();

		if (carts.size() > 0) {
			cartRepository.deleteAll();
			return true;
		}
		return false;
	}

	@Override
	public List<OrderDetail> getAllItem() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();
	}
	@Override
	public List<OrderDetail> getAllNewCart() {
		// TODO Auto-generated method stub
		List<OrderDetail> list= cartRepository.findAll();
		List<OrderDetail> listOrderNew=new ArrayList<OrderDetail>();
		for (OrderDetail orderDetail : list) {
			if(orderDetail.getOder()==null)
				listOrderNew.add(orderDetail);
		}
		return listOrderNew;
	}
	@Override
	public OrderDetail findOrderDetailbyProduct(Integer id) {
		List<OrderDetail> list=cartRepository.findAll();
		for (OrderDetail orderDetail : list) {
			if(orderDetail.getProduct().getId()==id) {
				return orderDetail;
			}
		}
		return null;
	}

	public double totalPrice() {
		List<OrderDetail> carts = cartRepository.findAll();
		double prices = 0.0;
		for (OrderDetail cart : carts) {
			prices += cart.getTotal();
		}
		return prices;
	}
}
