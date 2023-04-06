package tdtu.edu.vn.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.repository.ProductRepository;
import tdtu.edu.vn.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	@Override
	public List<Product> getAllProducts()
	{
		return productRepository.findAll();
	}
	@Override
	public Product saveProduct(Product Product)
	{
		return productRepository.save(Product);
	}
	@Override
	public Product getProductById(Long id)
	{
		return productRepository.findById(id).get();
	}
	@Override
	public Product updateProduct(Product Product)
	{
		return productRepository.save(Product);
	}
	@Override
	public void deleteProductById(Long id) 
	{
		 productRepository.deleteById(id);
	}

}
