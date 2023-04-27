package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.Cart;

public interface CartService {
	public Cart add(Cart item);

	public boolean remove(Long id);

	public Cart update(Long id, Cart cart);

	public boolean clear();

	public List<Cart> getAllItem();
}
