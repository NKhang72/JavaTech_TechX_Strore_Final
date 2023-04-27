package tdtu.edu.vn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.entity.Product;
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
	public Page<News> findAll(Pageable pageable)
	{
		return newsRepository.findAll(pageable);
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
	@Override
	public int count() {
		return newsRepository.findAll().size();
	}

}
