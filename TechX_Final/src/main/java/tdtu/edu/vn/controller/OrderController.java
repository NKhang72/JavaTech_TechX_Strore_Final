package tdtu.edu.vn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import tdtu.edu.vn.entity.Oder;
import tdtu.edu.vn.entity.OrderDetail;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.service.CartService;
import tdtu.edu.vn.service.CategoryService;
import tdtu.edu.vn.service.MenuService;
import tdtu.edu.vn.service.NewsService;
import tdtu.edu.vn.service.OrderService;
import tdtu.edu.vn.service.ProductService;
import tdtu.edu.vn.service.SlideService;



@Controller
public class OrderController {
	public ProductService productService;
	public CategoryService categoryService;
	public MenuService menuService;
	public UserRepository userRepository;
	public NewsService newsService;
	public SlideService slideService;
	public OrderService orderService;
	public CartService cartService;
	
	//public IndexController(ProductService productService, CategoryService categoryService, MenuService menuService,UserRepository userRepository) {}

	
	public OrderController(ProductService productService, CartService cartService,OrderService orderService,NewsService newsService, CategoryService categoryService, MenuService menuService, UserRepository userRepository, SlideService slideService) {
		super();
		this.productService = productService;
		this.categoryService=categoryService;
		this.menuService=menuService;
		this.userRepository=userRepository;
		this.newsService=newsService;
		this.slideService=slideService;
		this.orderService=orderService;
		this.cartService=cartService;
	}
	@GetMapping("/cart/payment")
	public String paymment() {
		Oder oder= new Oder();
		List<OrderDetail> listOrder=cartService.getAllItem();
		oder.setOderDetails(listOrder);
		orderService.add(oder);
		//update orderid
		Oder exitOrder= orderService.getNewOrder();
		Long id= exitOrder.getId();
		for (OrderDetail orderDetail : listOrder) {
			orderDetail.setOder(oder);
			cartService.updateid(orderDetail);
		}
		return "paymment";
	}
	///update, khi bam ok thi update name, dia chi, phone len oder vua tao.
	//hien thij oder nay ben trang admin


}
