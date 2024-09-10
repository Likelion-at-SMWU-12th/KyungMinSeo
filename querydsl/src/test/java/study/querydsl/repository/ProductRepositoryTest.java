//package study.querydsl.repository;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import study.querydsl.entity.Product;
//import study.querydsl.entity.QProduct;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@Transactional
//class ProductRepositoryTest {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    EntityManager entityManager;
//
//    // 더미 데이터
//    @BeforeEach
//    void setUp() {
//        productRepository.save(new Product("펜", 1000, 100, 20L));
//        productRepository.save(new Product("연필", 500, 200, 50L));
//        productRepository.save(new Product("노트", 2000, 150, 38L));
//        productRepository.save(new Product("지우개", 300, 300, 90L));
//        productRepository.save(new Product("자", 700, 250, 180L));
//        productRepository.save(new Product("펜", 1200, 50, 60L));
//        productRepository.save(new Product("테이프", 800, 80, 120L));
//        productRepository.save(new Product("풀", 600, 40, 110L));
//        productRepository.save(new Product("책", 3000, 20, 70L));
//        productRepository.save(new Product("필통", 2500, 15, 95L));
//        productRepository.save(new Product("샤프", 1500, 80, 85L));
//    }
//
//    @Test
//    @DisplayName("테스트")
//    void queryDslTest() {
//        JPAQueryFactory query = new JPAQueryFactory(entityManager);
//        QProduct qProduct = QProduct.product; // = new QProduct()
//
//        List<Product> productList =
//                query.selectFrom(qProduct)
//                .where(qProduct.name.eq("펜"))
//                .orderBy(qProduct.price.asc())
//                .fetch();
//
//        for (Product product : productList) {
//            System.out.println("-----가장 비싼 펜------");
//            System.out.println("Product Number : " + product.getId());
//            System.out.println("Product Name : " + product.getName());
//            System.out.println("Product Price : " + product.getPrice());
//            System.out.println("Product Stock : " + product.getStock());
//            System.out.println("----------------------\n");
//        }
//
//        List<Product> productList2 = productRepository.findTop10ByOrderByPopularityDesc();
//
//        System.out.println("-----인기도 TOP 10------");
//        for (Product product : productList2) {
//            System.out.println(product.getPopularity() + "\t" + product.getId() + "\t" + product.getName() + "\t" + product.getPrice() + "\t" + product.getStock());
//        }
//        System.out.println("----------------------\n");
//
//        List<Product> productList3 = productRepository.findTop10ByOrderByCreatedAtDesc();
//
//        System.out.println("-----최신순 TOP 10------");
//        for (Product product : productList2) {
//            System.out.println(product.getCreatedAt() + "\t" + product.getPopularity() + "\t" + product.getId() + "\t" + product.getName() + "\t" + product.getPrice() + "\t" + product.getStock());
//        }
//        System.out.println("----------------------\n");
//
//
//    }
//}