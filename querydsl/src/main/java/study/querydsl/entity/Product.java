package study.querydsl.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int price;
    private int stock;
    private long popularity; // 인기도

    private LocalDateTime createdAt; // 등록 시간

    public Product(String name, int price, int stock, long popularity) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.popularity = popularity;
        this.createdAt = LocalDateTime.now();
    }
}
