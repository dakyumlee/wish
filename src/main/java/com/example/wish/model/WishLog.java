package com.example.wish.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WishLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String wish;
    private String response;

    private LocalDateTime timestamp;

    public WishLog() {}

    public WishLog(String wish, String response) {
        this.wish = wish;
        this.response = response;
        this.timestamp = LocalDateTime.now();
    }

}
