package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.entity.Product;

public interface ProductService {
	public List<Product> getAllProducts();

	public Product saveProduct(Product product);

	public Product getProductById(Long id);

	public Product updateProduct(Product product);

	public void deleteProductById(Long id);
	

}
