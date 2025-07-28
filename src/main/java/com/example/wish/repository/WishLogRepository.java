package com.example.wish.repository;

import com.example.wish.model.WishLog;
import java.util.List;

public interface WishLogRepository {
    void save(WishLog wishLog);
    List<WishLog> findAll();
}