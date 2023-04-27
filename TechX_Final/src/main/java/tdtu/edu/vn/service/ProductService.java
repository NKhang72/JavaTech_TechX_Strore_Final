package tdtu.edu.vn.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tdtu.edu.vn.entity.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	
	public Page<Product> findAll(Pageable pageable);

	public Product saveProduct(Product product);

	public Product getProductById(Long id);

	public Product updateProduct(Product product);

	public void deleteProductById(Long id);
	
	public Page<Product> getProductByMeta(String meta, Pageable pageable);
	
	public int addProduct(Product product);
	
	public int removeProduct(Product product);

	Product getProductById(Integer id);
	public int count();
	public  int countProductByMeta(String meta);


}
