package tdtu.edu.vn.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.entity.User;
import tdtu.edu.vn.repository.UserRepository;
import tdtu.edu.vn.service.CategoryService;
import tdtu.edu.vn.service.MenuService;
import tdtu.edu.vn.service.NewsService;
import tdtu.edu.vn.service.ProductService;
import tdtu.edu.vn.service.UserService;
import tdtu.edu.vn.web.dto.UserRegistrationDto;

@Controller
public class AdminController {
	public ProductService productService;
	public CategoryService categoryService;
	public MenuService menuService;
	public NewsService newsService;
	public UserService userService;
	public UserRepository userRepository;
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

//	
	public AdminController(ProductService productService, CategoryService categoryService,
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

	

	@GetMapping("/admin")
	public String adminManager(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "admin";
	}
		
	@ModelAttribute("category")
	public List<Category> categgory(){
		return categoryService.getAllCategorys();
	}

	@GetMapping("/admin/new")
	public String createWatchForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "create_product";

	}

	@PostMapping("/admin")
	public String saveWatch(@RequestParam("name") String name, @RequestParam("price") int price,
			@RequestParam("color") String color, @RequestParam("quatity") String quatity,
			@RequestParam("year") int year,@RequestParam("battery") int battery,
			@RequestParam("backCamera") int backCamera,@RequestParam("frontCamera") int frontCamera,
			@RequestParam("rom") int rom,@RequestParam("ram") int ram,
			@RequestParam("cpu") String cpu,@RequestParam("screen") String resolution,
			@RequestParam("screen_type") String screen_type,@RequestParam("os") String os,
			@RequestParam("category") long category_id,@RequestParam("description") String description,
			@RequestParam("image") MultipartFile photo,@RequestParam("image1") MultipartFile photo1,
			@RequestParam("image2") MultipartFile photo2) {
		Product product_new = new Product();
		Category category=categoryService.getCategoryById(category_id);
		
		product_new.setName(name);
		product_new.setPrice(price);
		product_new.setColor(color);
		product_new.setQuatity(quatity);
		product_new.setBackCamera(backCamera);
		product_new.setBattery(battery);
		product_new.setFrontCamera(frontCamera);
		product_new.setCpu(cpu);
		product_new.setRam(ram);
		product_new.setRom(rom);
		product_new.setScreen(resolution);
		product_new.setScreen_type(screen_type);
		product_new.setOs(os);
		product_new.setDescription(description);
		product_new.setYear(year);
		product_new.setCategory(category);
		// watch_new.setCategory_id(categories);
		if (photo.isEmpty()) {
			return "/admin";
		} else {
			Path path = Paths.get("uploads/");
			try {
				InputStream inputStream = photo.getInputStream();
				InputStream inputStream1 = photo1.getInputStream();
				InputStream inputStream2 = photo2.getInputStream();
				Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				Files.copy(inputStream1, path.resolve(photo1.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				Files.copy(inputStream2, path.resolve(photo2.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				product_new.setImage(photo.getOriginalFilename().toLowerCase());
				product_new.setImage1(photo1.getOriginalFilename().toLowerCase());
				product_new.setImage2(photo2.getOriginalFilename().toLowerCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		productService.saveProduct(product_new);

		return "redirect:/admin";
	}

	@GetMapping("/admin/edit/{id}")
	public String editProductForm(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		List<Category> category =categoryService.getAllCategorys();
		model.addAttribute("category", category);
		return "edit_product";
	}
	@GetMapping("/admin/detail/{id}")
	public String detailProductForm(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		
		return "detail_product";
	}

	@PostMapping("/admin/{id}")
	public String updateProducts(@PathVariable Long id, @RequestParam("name") String name, @RequestParam("price") int price,
			@RequestParam("color") String color, @RequestParam("quatity") String quatity,
			@RequestParam("year") int year,@RequestParam("battery") int battery,
			@RequestParam("backCamera") int backCamera,@RequestParam("frontCamera") int frontCamera,
			@RequestParam("rom") int rom,@RequestParam("ram") int ram,
			@RequestParam("cpu") String cpu,@RequestParam("screen") String resolution,
			@RequestParam("screen_type") String screen_type,@RequestParam("os") String os,
			@RequestParam(value="category.id",required=false) long category_id,@RequestParam("description") String description,
			@RequestParam("image") MultipartFile photo,@RequestParam("image1") MultipartFile photo1,
			@RequestParam("image2") MultipartFile photo2) {

		// get watch from database by id
		Product existingProduct= productService.getProductById(id);
		Category category=categoryService.getCategoryById(category_id);
		existingProduct.setName(name);
		existingProduct.setPrice(price);
		existingProduct.setColor(color);
		existingProduct.setQuatity(quatity);
		existingProduct.setBackCamera(backCamera);
		existingProduct.setBattery(battery);
		existingProduct.setFrontCamera(frontCamera);
		existingProduct.setCpu(cpu);
		existingProduct.setRam(ram);
		existingProduct.setRom(rom);
		existingProduct.setScreen(resolution);
		existingProduct.setScreen_type(screen_type);
		existingProduct.setOs(os);
		existingProduct.setDescription(description);
		existingProduct.setYear(year);
		existingProduct.setCategory(category);
		// watch_new.setCategory_id(categories);
		if (photo.isEmpty()) {
			return "/admin";
		} else {
			Path path = Paths.get("uploads/");
			try {
				InputStream inputStream = photo.getInputStream();
				InputStream inputStream1 = photo1.getInputStream();
				InputStream inputStream2 = photo2.getInputStream();
				Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				Files.copy(inputStream1, path.resolve(photo1.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				Files.copy(inputStream2, path.resolve(photo2.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				existingProduct.setImage(photo.getOriginalFilename().toLowerCase());
				existingProduct.setImage1(photo1.getOriginalFilename().toLowerCase());
				existingProduct.setImage2(photo2.getOriginalFilename().toLowerCase());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// save updated watch object
		productService.updateProduct(existingProduct);
		return "redirect:/admin";
	}

	@GetMapping("/admin/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/admin";
	}
	@GetMapping("/admin/news")
	public String showNews(Model model) {
		model.addAttribute("newss", newsService.getAllNewss());
		return "list_news";
	}
	@GetMapping("/admin/news/new")
	public String createNewsForm(Model model) {
		News news= new News();
		model.addAttribute("news", news);
		return "create_news";

	}
	@GetMapping("/admin/users")
	public String showUsers(Model model) {
		List<User> listUsers = userService.getAllUsers();
		model.addAttribute("users", listUsers);
		return "list_users";
	}
	@GetMapping("/admin/users/edit/{id}")
	public String editUserForm(@PathVariable Long id, Model model) {
		User user = userService.getUserById(id);
		
		model.addAttribute("user", user);
		
		return "edit_users";
	}
	
	@PostMapping("/admin/users/update/{id}")
	public String editUserAccount(@PathVariable Long id, @ModelAttribute("user") UserRegistrationDto registrationDto) {
		User currentUser = userService.getUserById(id);
		currentUser.setId(id);
		currentUser.setEmail(registrationDto.getEmail());
		currentUser.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		currentUser.setFirstName(registrationDto.getFirstName());
		currentUser.setLastName(registrationDto.getLastName());
		userRepository.save(currentUser);
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/users/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}
}
