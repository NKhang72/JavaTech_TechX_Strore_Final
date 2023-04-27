package tdtu.edu.vn.controller;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpSession;
import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.entity.Menu;
import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.entity.User;
import tdtu.edu.vn.repository.NewsRepository;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.service.CategoryService;
import tdtu.edu.vn.service.MenuService;
import tdtu.edu.vn.service.NewsService;
import tdtu.edu.vn.service.ProductService;

@Controller
public class IndexController {
	public ProductService productService;
	public CategoryService categoryService;
	public MenuService menuService;
	public UserRepository userRepository;
	public NewsService newsService;
	
	//public IndexController(ProductService productService, CategoryService categoryService, MenuService menuService,UserRepository userRepository) {}

	
	public IndexController(ProductService productService,NewsService newsService, CategoryService categoryService, MenuService menuService, UserRepository userRepository) {
		super();
		this.productService = productService;
		this.categoryService=categoryService;
		this.menuService=menuService;
		this.userRepository=userRepository;
		this.newsService=newsService;
	}

	@GetMapping({"/index", "/"})
	public String index(Model model, HttpSession session) {
		model.addAttribute("products", productService.getAllProducts());
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		 User user = userRepository.findByEmail(email);
		 if (user != null) {
			 model.addAttribute("firstName", user.getFirstName());
		 }
		return "index";
	}
	//@ModelAttribute("news")
//	public List<News> allNews(){
		
	//	return newsService.getAllNewss();
	//}
	@ModelAttribute("category")
	public List<Category> categgory(){
		return categoryService.getAllCategorys();
	}
	@ModelAttribute("menu")
	public List<Menu> menu(){
		return menuService.getAllMenus();
	}
	@GetMapping("/Phone")
	public String Phone(Model model) {
		model.addAttribute("products", productService.getProductByMeta("Phone"));
		return "categories";
	}
	@GetMapping("/Laptop")
	public String Laptop(Model model) {
		model.addAttribute("products", productService.getProductByMeta("Laptop"));
		return "categories";
	}
	@GetMapping("/Tablet")
	public String Tablet(Model model) {
		model.addAttribute("products", productService.getProductByMeta("Tablet"));
		return "categories";
	}
	@GetMapping("/Accessories")
	public String Accessories(Model model) {
		model.addAttribute("products", productService.getProductByMeta("Accessories"));
		return "categories";
	}

}
