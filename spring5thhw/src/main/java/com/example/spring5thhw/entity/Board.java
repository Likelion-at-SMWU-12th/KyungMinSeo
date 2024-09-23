package com.example.spring5thhw.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {

    // 게시판 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 게시판 이름
    @Column(nullable = false)
    private String name;

    // 작성자 매핑 : ManyToOne
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    // 댓글 매핑 : OneToMany
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_id")
    private List<Comment> comment_list = new ArrayList<>();
}
