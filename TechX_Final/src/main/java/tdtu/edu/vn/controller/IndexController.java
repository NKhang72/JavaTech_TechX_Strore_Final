package tdtu.edu.vn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.entity.Menu;
import tdtu.edu.vn.service.CategoryService;
import tdtu.edu.vn.service.MenuService;
import tdtu.edu.vn.service.ProductService;

@Controller
public class IndexController {
	public ProductService productService;
	public CategoryService categoryService;
	public MenuService menuService;

//	
	public IndexController(ProductService productService, CategoryService categoryService, MenuService menuService) {
		super();
		this.productService = productService;
		this.categoryService=categoryService;
		this.menuService=menuService;
//		
	}
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("products", productService.getAllProducts());
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