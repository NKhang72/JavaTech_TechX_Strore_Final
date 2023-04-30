package tdtu.edu.vn.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tdtu.edu.vn.entity.News;
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
	public String paymment(Model model) {
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
		model.addAttribute("listOrder", listOrder);
	    model.addAttribute("getId", id);
		
		return "paymment";
	}
	///update, khi bam ok thi update name, dia chi, phone len oder vua tao.
	//hien thij oder nay ben trang admin
	@PostMapping("/admin/order")
	public String editNewsOder(@PathVariable Long id,@RequestParam("name") String name,@RequestParam("phone") String phone
			,@RequestParam("address") String address, @RequestParam("httt") String httt) {
		Oder oder= orderService.OderById(id);
		oder.setName(name);
		oder.setPhone(phone);
		oder.setAddress(address);
		oder.setPayment(httt);
		orderService.update(oder);
		return "redirect:/admin/oder";
	}

	
}
