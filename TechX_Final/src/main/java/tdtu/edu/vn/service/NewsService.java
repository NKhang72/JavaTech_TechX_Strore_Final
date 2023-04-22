package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.News;

public interface NewsService {
	public List<News> getAllNewss();

	public News saveNews(News news);

	public News getNewsById(Long id);

	public News updateNews(News news);
	
	public void deleteNewsById(Long id);


}
