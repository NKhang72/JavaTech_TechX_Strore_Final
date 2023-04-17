package tdtu.edu.vn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.service.CategoryService;
import tdtu.edu.vn.service.ProductService;

@Controller
public class ShoppingCartController {
	public ProductService productService;
	public CategoryService categoryService;

//	
	public ShoppingCartController(ProductService productService, CategoryService categoryService) {
		super();
		this.productService = productService;
		this.categoryService=categoryService;
//		
	}

	@GetMapping("/detail/{id}")
	public String editProductForm(@PathVariable Long id, Model model) {
		Product product= new Product();
		product=productService.getProductById(id);
		model.addAttribute("product", product);
		if(product.getCategory().getName().equals("Phone")) {
			return "singlePhone";
		}
		if(product.getCategory().getName().equals("Laptop")) {
			return "singleLaptop";
		}
		if(product.getCategory().getName().equals("Tablet")) {
			return "singleTablet";
		}
		if(product.getCategory().getName().equals("Accessories")) {
			return "singleAccessories";
		}
		
		
		return "admin";

	}
}
