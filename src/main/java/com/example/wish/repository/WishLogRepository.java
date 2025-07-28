package com.example.wish.repository;

import com.example.wish.model.WishLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishLogRepository extends JpaRepository<WishLog, Long> {
}
