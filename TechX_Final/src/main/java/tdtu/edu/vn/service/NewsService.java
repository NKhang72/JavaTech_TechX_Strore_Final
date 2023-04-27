package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface NewsService {
	public Page<News> findAll(Pageable pageable);

	public News saveNews(News news);

	public News getNewsById(Long id);

	public News updateNews(News news);
	
	public void deleteNewsById(Long id);
	
	public int count();
	
	public List<News> getAllNewss();


}
