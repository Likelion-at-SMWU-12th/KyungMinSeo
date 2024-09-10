package study.querydsl.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.querydsl.entity.Product;
import study.querydsl.entity.ProductDetail;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductDetailRepositoryTest {
    @Autowired
    ProductDetailRepository productDetailRepository;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveAndReadTest() {
        Product product = new Product();
        product.setName("스프링 부트 JPA");
        product.setPrice(500);
        product.setStock(500);

        productRepository.save(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(product);
        productDetail.setDescription("스프링 부트와 JPA를 함께 보는 책");

        productDetailRepository.save(productDetail);

        System.out.println("savedProduct : " + productDetailRepository.findById(
                productDetail.getId()
        ).get().getProduct());
        System.out.println("savedProductDetail : " + productDetailRepository.findById(
                productDetail.getId()
        ).get());
    }
}