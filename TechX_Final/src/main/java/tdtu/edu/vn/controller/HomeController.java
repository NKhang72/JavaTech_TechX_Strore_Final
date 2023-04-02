package tdtu.edu.vn.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.service.ProductService;

@Controller
public class HomeController {
	public ProductService productService;

//	
	public HomeController(ProductService productService) {
		super();
		this.productService = productService;
//		
	}

	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/admin")
	public String adminManager(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "admin";
	}

	@GetMapping("/admin/new")
	public String createWatchForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
//		List<Categories> categories = categoriesService.getAllCategories();
//		model.addAttribute("categories", categories);

		return "create_product";

	}

	@PostMapping("/admin")
	public String saveWatch(@RequestParam("name") String name, @RequestParam("price") int price,
			@RequestParam("color") String color, @RequestParam("quatity") String quatity,
			@RequestParam("year") int year,

			@RequestParam("image") MultipartFile photo) {
		Product product_new = new Product();
		// Categories categories=categoriesService.getbByid(categori_id);
		product_new.setName(name);
		product_new.setPrice(price);
		product_new.setColor(color);
		product_new.setQuatity(quatity);
		product_new.setYear(year);

		// watch_new.setCategory_id(categories);
		if (photo.isEmpty()) {
			return "/admin";
		} else {
			Path path = Paths.get("uploads/");
			try {
				InputStream inputStream = photo.getInputStream();
				Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				product_new.setImage(photo.getOriginalFilename().toLowerCase());
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
		return "edit_product";
	}

	@PostMapping("/admin/{id}")
	public String updateProducts(@PathVariable Long id, @RequestParam("name") String name,
			@RequestParam("price") int price, @RequestParam("color") String color,
			@RequestParam("quatity") String quatity, @RequestParam("year") int year,
			@RequestParam("image") MultipartFile photo) {

		// get watch from database by id
		Product existingProduct= productService.getProductById(id);
		existingProduct.setId(id);
		existingProduct.setName(name);
		existingProduct.setPrice(price);
		existingProduct.setColor(color);
		existingProduct.setQuatity(quatity);
		existingProduct.setYear(year);
		
		if (photo.isEmpty()) {
			return "/admin";
		} else {
			Path path = Paths.get("uploads/");
			try {
				InputStream inputStream = photo.getInputStream();
				Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
				existingProduct.setImage(photo.getOriginalFilename().toLowerCase());
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

}
