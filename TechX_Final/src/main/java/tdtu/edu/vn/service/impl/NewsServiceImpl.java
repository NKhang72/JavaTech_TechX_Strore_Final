package tdtu.edu.vn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.repository.NewsRepository;
import tdtu.edu.vn.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService{
	private NewsRepository newsRepository;
	public NewsServiceImpl(NewsRepository newsRepository) {
		super();
		this.newsRepository = newsRepository;
	}
	@Override
	public List<News> getAllNewss()
	{
		
//		List<News> News = newsRepository.findAll();
//		List<News> result = new ArrayList<News>();
//		for (News news : News) {
//			if (news.getHide() == true) {
//				result.add(news);
//			}
//		}

		return newsRepository.findAll();
	}
	
	@Override
	public News saveNews(News news)
	{
		return newsRepository.save(news);
	}
	@Override
	public News getNewsById(Long id)
	{
		return newsRepository.findById(id).get();
	}
	@Override
	public News updateNews(News news)
	{
		return newsRepository.save(news);
	}
	@Override
	public void deleteNewsById(Long id) 
	{
		 newsRepository.deleteById(id);
	}

}
