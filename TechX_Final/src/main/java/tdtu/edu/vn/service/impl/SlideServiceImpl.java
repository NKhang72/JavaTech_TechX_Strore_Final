package tdtu.edu.vn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import tdtu.edu.vn.entity.Slide;
import tdtu.edu.vn.entity.Product;
import tdtu.edu.vn.repository.SlideRepository;
import tdtu.edu.vn.service.SlideService;

@Service
public class SlideServiceImpl implements SlideService{
	private SlideRepository slideRepository;
	public SlideServiceImpl(SlideRepository slideRepository) {
		super();
		this.slideRepository = slideRepository;
	}
	@Override
	public Page<Slide> findAll(Pageable pageable)
	{
		return slideRepository.findAll(pageable);
	}
	@Override
	public Slide getLastSlide() {
		int n=slideRepository.findAll().size();
		return slideRepository.findAll().get(n-1);
	}
	
	@Override
	public Slide saveSlide(Slide Slide)
	{
		return slideRepository.save(Slide);
	}
	@Override
	public Slide getSlideById(Long id)
	{
		return slideRepository.findById(id).get();
	}
	@Override
	public Slide updateSlide(Slide Slide)
	{
		return slideRepository.save(Slide);
	}
	@Override
	public void deleteSlideById(Long id) 
	{
		 slideRepository.deleteById(id);
	}
	@Override
	public int count() {
		return slideRepository.findAll().size();
	}
	
	

}
