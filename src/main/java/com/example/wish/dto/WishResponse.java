package com.example.wish.dto;

public class WishResponse {
    private String wish;
    private String response;

    public WishResponse(String wish, String response) {
        this.wish = wish;
        this.response = response;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}