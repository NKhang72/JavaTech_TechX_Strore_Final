package tdtu.edu.vn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tdtu.edu.vn.entity.Cart;
import tdtu.edu.vn.entity.Oder;
import tdtu.edu.vn.entity.OrderDetail;

public interface OrderService {
	public Oder add(Oder item);

	public boolean remove(Long id);

	public Oder update(Oder oder);

	public boolean clear();

	public Page<Oder> getAllOrder(Pageable pageable);
	
	public Oder getNewOrder();

	public Oder OderById(Long id);
	public int totalOrder(List<OrderDetail> listProduct) ;
	
}
