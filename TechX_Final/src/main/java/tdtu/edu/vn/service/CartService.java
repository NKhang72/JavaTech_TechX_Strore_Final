package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.Cart;
import tdtu.edu.vn.entity.OrderDetail;

public interface CartService {
	public OrderDetail add(OrderDetail item);

	public boolean remove(Long id);

	public OrderDetail update(Long id, OrderDetail cart);

	public boolean clear();

	public List<OrderDetail> getAllItem();
	public OrderDetail updateid(OrderDetail OrderDetail) ;
}
