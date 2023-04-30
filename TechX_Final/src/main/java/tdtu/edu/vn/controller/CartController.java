package tdtu.edu.vn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import tdtu.edu.vn.entity.Cart;
import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.entity.Menu;
import tdtu.edu.vn.entity.Oder;
import tdtu.edu.vn.entity.OrderDetail;
import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.service.CategoryService;
import tdtu.edu.vn.service.MenuService;
import tdtu.edu.vn.service.NewsService;
import tdtu.edu.vn.service.OrderService;
import tdtu.edu.vn.service.ProductService;
import tdtu.edu.vn.service.UserService;
import tdtu.edu.vn.entity.User;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.service.impl.CartServiceImpl;
import tdtu.edu.vn.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("cart")
public class CartController {
	@Autowired
	private CartServiceImpl cartServiceImpl;
	
	@Autowired
	private ProductServiceImpl productServiceImpl;
	
	public CategoryService categoryService;
	public MenuService menuService;
	public UserService userService;
	public OrderService orderService;
	
	public CartController( CategoryService categoryService,
			MenuService menuService,  UserService userService, UserRepository userRepository , OrderService orderService) {
		super();
		
		this.categoryService=categoryService;
		this.menuService=menuService;
		this.userService=userService;
		this.userRepository=userRepository;
		this.orderService=orderService;
//		
	}
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("carts", cartServiceImpl.getAllItem());
		model.addAttribute("total_price", cartServiceImpl.totalPrice());
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		 User user = userRepository.findByEmail(email);
		 if (user != null) {
			 model.addAttribute("firstName", user.getFirstName());
		 }
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
		if ( cartServiceImpl.findOrderDetailbyProduct(product.getId())==null) {
			OrderDetail item = new OrderDetail();
			item.setProduct(product);
			item.setQuanity(1);
			item.setPrice(product.getPrice());
			item.setTotal(product.getPrice()*item.getQuanity());
			item.setOder(null);
			cartServiceImpl.add(item);
			
			return "redirect:/cart";
		}
		else {
			OrderDetail item=cartServiceImpl.findOrderDetailbyProduct(product.getId());
			item.setQuanity(item.getQuanity()+1);
			item.setTotal(product.getPrice()*item.getQuanity());
			cartServiceImpl.updateid(item);
			return "redirect:/cart";
		}
		
	}
//
	@GetMapping("/detail/{id}")
 	public String editProductForm(@PathVariable Long id, Model model) {
 		Product product = new Product();
 		product = productServiceImpl.getProductById(id);
 		model.addAttribute("product", product);
 		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		 User user = userRepository.findByEmail(email);
		 if (user != null) {
			 model.addAttribute("firstName", user.getFirstName());
		 }
 		if (product.getCategory().getName().equals("Phone")) {
 			return "singlePhone";
 		}
 		if (product.getCategory().getName().equals("Laptop")) {
 			return "singleLaptop";
 		}
 		if (product.getCategory().getName().equals("Tablet")) {
 			return "singleTablet";
 		}
 		if (product.getCategory().getName().equals("Accessories")) {
 			return "singleAccessories";
 		}
 
 		return "index";
 
 	}
	@ModelAttribute("category")
	public List<Category> categgory(){
		return categoryService.getAllCategorys();
	}
	@ModelAttribute("menu")
	public List<Menu> menu(){
		return menuService.getAllMenus();
	}
	@GetMapping("/cart/clear")
	public String removeAllI() {
	    cartServiceImpl.clear();
	    return "redirect:/cart";
	}
}
