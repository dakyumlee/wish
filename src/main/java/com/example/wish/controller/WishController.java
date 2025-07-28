package com.example.wish.controller;

import com.example.wish.dto.WishRequest;
import com.example.wish.dto.WishResponse;
import com.example.wish.model.WishLog;
import com.example.wish.service.WishService;
import java.util.List;

public class WishController {

    private final WishService wishService = new WishService();

    public WishResponse handleWish(WishRequest request) {
        String result = wishService.generateResponse(request.getWish());
        return new WishResponse(request.getWish(), result);
    }

    public List<WishLog> getWishLogs() {
        return wishService.getAllLogs();
    }
}