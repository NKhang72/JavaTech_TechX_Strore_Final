package tdtu.edu.vn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tdtu.edu.vn.entity.Cart;
import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.service.impl.CartServiceImpl;
import tdtu.edu.vn.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("carts", cartServiceImpl.getAllItem());
		model.addAttribute("total_price", cartServiceImpl.totalPrice());
		return "cart";
	}
	
	@GetMapping("/remove/{id}")
	public String removeCart(@PathVariable("id") Long id) {
		cartServiceImpl.remove(id);
		return "redirect:/cart";
	}
	
	@GetMapping("add/{product_id}")
	public String addCart(@PathVariable("product_id") Long product_id) {
		Product product = productServiceImpl.getProductById(product_id);
		if (product != null) {
			Cart item = new Cart();
			item.setName(product.getName());
			item.setPrice(product.getPrice());
			item.setQty(1);
			item.setTotal(product.getPrice());
			cartServiceImpl.add(item);
			return "redirect:/cart";
		}
		return "redirect:/index";
	}
//
//	@GetMapping("/detail/{id}")
//	public String editProductForm(@PathVariable Long id, Model model) {
//		Product product = new Product();
//		product = productService.getProductById(id);
//		model.addAttribute("product", product);
//		if (product.getCategory().getName().equals("Phone")) {
//			return "singlePhone";
//		}
//		if (product.getCategory().getName().equals("Laptop")) {
//			return "singleLaptop";
//		}
//		if (product.getCategory().getName().equals("Tablet")) {
//			return "singleTablet";
//		}
//		if (product.getCategory().getName().equals("Accessories")) {
//			return "singleAccessories";
//		}
//
//		return "admin";
//
//	}
}
