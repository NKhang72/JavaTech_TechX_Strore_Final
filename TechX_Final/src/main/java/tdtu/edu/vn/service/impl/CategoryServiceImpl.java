package tdtu.edu.vn.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tdtu.edu.vn.entity.Category;
import tdtu.edu.vn.repository.CategoryRepository;
import tdtu.edu.vn.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	private CategoryRepository CategoryRepository;
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.CategoryRepository = categoryRepository;
	}
	@Override
	public List<Category> getAllCategorys()
	{
		return CategoryRepository.findAll();
	}
	
	@Override
	public Category saveCategory(Category category)
	{
		return CategoryRepository.save(category);
	}
	@Override
	public Category getCategoryById(Long id)
	{
		return CategoryRepository.findById(id).get();
	}
	@Override
	public Category updateCategory(Category category)
	{
		return CategoryRepository.save(category);
	}
	@Override
	public void deleteCategoryById(Long id) 
	{
		 CategoryRepository.deleteById(id);
	}
}
