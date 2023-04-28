package tdtu.edu.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import tdtu.edu.vn.entity.News;
import tdtu.edu.vn.entity.Slide;

public interface SlideRepository extends JpaRepository<Slide, Long>{

}
