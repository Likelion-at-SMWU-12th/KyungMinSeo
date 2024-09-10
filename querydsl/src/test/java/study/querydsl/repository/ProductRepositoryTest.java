package study.querydsl.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import study.querydsl.entity.Product;
import study.querydsl.entity.QProduct;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    EntityManager entityManager;

    // 더미 데이터
    @BeforeEach
    void setUp() {
        productRepository.save(new Product("펜", 1000, 100));
        productRepository.save(new Product("연필", 500, 200));
        productRepository.save(new Product("노트", 2000, 150));
        productRepository.save(new Product("지우개", 300, 300));
        productRepository.save(new Product("자", 700, 250));
    }

    @Test
    @DisplayName("테스트")
    void queryDslTest() {
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product; // = new QProduct()

        List<Product> productList =
                query.selectFrom(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Product product : productList) {
            System.out.println("----------------------");
            System.out.println("Product Number : " + product.getId());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println("----------------------");
        }
    }
}