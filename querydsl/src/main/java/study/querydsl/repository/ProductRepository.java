package study.querydsl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
