package com.example.spring5thhw.repository;

import com.example.spring5thhw.entity.Board;
import com.example.spring5thhw.entity.Comment;
import com.example.spring5thhw.entity.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void MappingTest() {
        // 게시판 생성
        Board board = new Board();
        board.setName("멋사게시판");

        // 유저 생성
        User user1 = new User();
        user1.setName("김멋사");
        userRepository.save(user1);

        User user2 = new User();
        user2.setName("이숙명");
        userRepository.save(user2);

        // 게시판에 유저 매핑
        board.setUser(user1);

        // 댓글 생성
        Comment comment1 = new Comment();
        comment1.setContent("멋사 짱짱~!");

        Comment comment2 = new Comment();
        comment2.setContent("멋사 화이팅~!");

        // 댓글에 유저 매핑
        comment1.setUser(user1);
        comment2.setUser(user2);

        commentRepository.save(comment1);
        commentRepository.save(comment2);

        // 게시판에 댓글 매핑
        board.getComment_list().addAll(Lists.newArrayList(comment1, comment2));
        boardRepository.save(board);

        // 확인
        Board savedBoard = boardRepository.findById(board.getId()).orElse(null);
        System.out.println("========================");
        if (savedBoard != null) {
            System.out.println("Board: " + savedBoard.getName());
            System.out.println("Board Owner: " + savedBoard.getUser().getName());

            List<Comment> comments = savedBoard.getComment_list();
            for (Comment comment : comments) {
                System.out.println("Comment: " + comment.getContent());
                System.out.println("Commented by: " + comment.getUser().getName());
            }
        }
        System.out.println("========================");

    }

}