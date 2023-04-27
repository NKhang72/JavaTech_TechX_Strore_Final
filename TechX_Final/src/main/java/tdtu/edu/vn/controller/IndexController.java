package tdtu.edu.vn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.entity.Menu;
import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.entity.Product;
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
	@GetMapping("/Category/page")
	public String Category(Model model,  @RequestParam("p") Optional<Integer> p,
			@RequestParam("field") Optional<String> field,@RequestParam("type") Optional<String> category ) {
 		int c,pageCount;
 		int total=productService.countProductByMeta(category.orElse("Phone"));
 		if(total%10==0) {
 			pageCount=total/10;
 		}
 		else {
 			pageCount=(total/10)+1;
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
		Sort sort= Sort.by(Direction.ASC, field.orElse("price"));
		Pageable pageable= PageRequest.of(c,10,sort);
		Page<Product> page= productService.getProductByMeta(category.orElse("Phone"), pageable);
		model.addAttribute("products", page);
		return "categories";
	}


}
