package tdtu.edu.vn.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.criteria.Order;
import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.entity.Menu;
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
		List<OrderDetail> listOrderNew=new ArrayList<OrderDetail>();
		for (OrderDetail orderDetail : listOrder) {
			if(orderDetail.getOder()==null) {
				listOrderNew.add(orderDetail);
			}
			
		}
		oder.setOderDetails(listOrder);
		int total=orderService.totalOrder(listOrder);
		oder.setTotal(total);
		orderService.add(oder);
		//update orderid
		Oder exitOrder= orderService.getNewOrder();
		Long id= exitOrder.getId();
		for (OrderDetail orderDetail : listOrderNew) {
			orderDetail.setOder(oder);
			cartService.updateid(orderDetail);
		}
		
		model.addAttribute("total", total);
		model.addAttribute("listOrder", listOrder);
	    model.addAttribute("getId", id);
	    model.addAttribute("order", oder);
		
		return "paymment";
	}
	///update, khi bam ok thi update name, dia chi, phone len oder vua tao.
	//hien thij oder nay ben trang admin
	@PostMapping("/cart/payment/order/{id}")
	public String editOder(@PathVariable Long id,@RequestParam("name") String name,@RequestParam("phone") String phone
			,@RequestParam("address") String address, @RequestParam("payment") String httt) {
		Oder oder= orderService.OderById(id);
		oder.setName(name);
		oder.setPhone(phone);
		oder.setAddress(address);
		oder.setPayment(httt);
		oder.setStatus("Waiting");
		orderService.update(oder);
		return "redirect:/index";
	}
	@GetMapping("/admin/order/page")
	public String showOrder(Model model, @RequestParam("p") Optional<Integer> p,@RequestParam("field") Optional<String> field) {
		int c,pageCount;
		int total=newsService.count();
		if(total%7!=0) {
			pageCount=total/7;
		}
		else {
			pageCount=(total/7)+1;
		}
		if(p==null || p.hashCode()<0 ) {
			c=0;
		}
		else if(p.hashCode() >= pageCount) {
			c=p.hashCode()-1;
		}
		else {
			c=p.hashCode();
		}
		Sort sort= Sort.by(Direction.DESC, field.orElse("createDate"));
		Pageable pageable= PageRequest.of(c, 7,sort);
		
		Page<Oder> page= orderService.getAllOrder(pageable);
		model.addAttribute("orders",page);
	    return "list_order";
	}
	@GetMapping("/admin/order/{id}")
	public String deleteOrder(@PathVariable Long id) {
		orderService.remove(id);
		return "redirect:/admin/order/page";
	}
	@GetMapping("/admin/order/detail/{id}")
	public String DetailOrder(@PathVariable Long id, Model model) {
		model.addAttribute("order",orderService.OderById(id));
		model.addAttribute("products", orderService.OderById(id).getOderDetails());
		return "detail_Order";
	}
	@GetMapping("/admin/order/confirm/{id}")
	public String Confirm(@PathVariable Long id) {
		Oder oder= orderService.OderById(id);
		oder.setStatus("Confirm");
		orderService.update(oder);
		return "redirect:/admin/order/page";
	}
	
	
}
