package tdtu.edu.vn.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tdtu.edu.vn.entity.Menu;
import tdtu.edu.vn.repository.MenuRepository;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.service.CategoryService;
import tdtu.edu.vn.service.MenuService;
import tdtu.edu.vn.service.NewsService;
import tdtu.edu.vn.service.ProductService;
import tdtu.edu.vn.service.UserService;

@Controller
public class MenuController {
	public ProductService productService;
	public CategoryService categoryService;
	public MenuService menuService;
	public NewsService newsService;
	public UserService userService;
	public UserRepository userRepository;
	
	public MenuController(ProductService productService, CategoryService categoryService,
			MenuService menuService ,NewsService newsService, UserService userService, UserRepository userRepository ) {
		super();
		this.productService = productService;
		this.categoryService=categoryService;
		this.menuService=menuService;
		this.newsService=newsService;
		this.userService=userService;
		this.userRepository=userRepository;
//		
	}
	@GetMapping("/admin/menu")
	public String Menu(Model model, @RequestParam("field") Optional<String> field) {
		Sort sort= Sort.by(Direction.ASC, field.orElse("id"));
		model.addAttribute("menus", menuService.getMenu(sort));
		return "menu_admin";
	}
	@GetMapping("/admin/menu/edit/{id}")
	public String editMenu(@PathVariable Long id, Model model) {
		model.addAttribute("menu", menuService.getMenuById(id));
		return "edit_menu";
	}
	@PostMapping("/admin/menu/{id}")
	public String editMenu(@PathVariable Long id,@RequestParam("name") String name
			,@RequestParam(value = "hide", required = false) String checkboxValue) {
		Menu menu= menuService.getMenuById(id);
		if(checkboxValue != null) {
			menu.setHide(true);
		}
		else {
			menu.setHide(false);
		}
		menu.setName(name);
		menuService.updateMenu(menu);
		return "redirect:/admin/menu";
	}

}
