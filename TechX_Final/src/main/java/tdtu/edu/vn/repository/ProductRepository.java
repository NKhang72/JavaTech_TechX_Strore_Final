package tdtu.edu.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tdtu.edu.vn.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
