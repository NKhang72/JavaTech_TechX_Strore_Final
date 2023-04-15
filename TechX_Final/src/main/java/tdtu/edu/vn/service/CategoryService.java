package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.Category;

public interface CategoryService {
	public List<Category> getAllCategorys();

	public Category saveCategory(Category category);

	public Category getCategoryById(Long id);

	public Category updateCategory(Category category);

	public void deleteCategoryById(Long id);
}
