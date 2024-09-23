package com.example.spring5thhw.repository;

import com.example.spring5thhw.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
