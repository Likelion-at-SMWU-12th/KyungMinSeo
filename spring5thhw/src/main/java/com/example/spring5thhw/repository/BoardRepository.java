package com.example.spring5thhw.repository;

import com.example.spring5thhw.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
