package tdtu.edu.vn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Product> findAll(Pageable pageable)
	{
		return productRepository.findAll(pageable);
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
	@Override
	public  List<Product> getProductByMeta(String meta){
		List<Product> allProduct =  productRepository.findAll();
		List<Product> result=new ArrayList<Product>();
		for( Product product: allProduct) {
			if( product.getCategory().getName().equals(meta)) {
				result.add(product);
			}
		}
		return result;
	}

}
