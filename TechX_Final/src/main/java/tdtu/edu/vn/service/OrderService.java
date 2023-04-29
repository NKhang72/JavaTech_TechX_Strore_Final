package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.Cart;
import tdtu.edu.vn.entity.Oder;
import tdtu.edu.vn.entity.OrderDetail;

public interface OrderService {
	public Oder add(Oder item);

	public boolean remove(Long id);

	public Oder update(Oder oder);

	public boolean clear();

	public List<Oder> getAllOrder();
	
	public Oder getNewOrder();
}
