package tdtu.edu.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.vn.entity.News;

public interface NewsRepository extends JpaRepository<News, Long>{

}
