package study.querydsl.repository;

import com.fasterxml.jackson.databind.node.POJONode;
import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findTop10ByOrderByPopularityDesc();
}
