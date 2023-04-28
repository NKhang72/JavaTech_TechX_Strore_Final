package tdtu.edu.vn.service;

import java.util.List;

import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.entity.Slide;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface SlideService {
	public Page<Slide> findAll(Pageable pageable);

	public Slide saveSlide(Slide slide);

	public Slide getSlideById(Long id);

	public Slide updateSlide(Slide slide);
	
	public void deleteSlideById(Long id);
	
	public int count();
	
	public Slide getLastSlide();


}
