package com.example.wish.model;

import java.time.LocalDateTime;

public class WishLog {

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

    // Getters
    public Long getId() { return id; }
    public String getWish() { return wish; }
    public String getResponse() { return response; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setWish(String wish) { this.wish = wish; }
    public void setResponse(String response) { this.response = response; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}