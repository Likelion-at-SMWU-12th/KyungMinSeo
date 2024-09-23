package com.example.spring5thhw.repository;

import com.example.spring5thhw.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
