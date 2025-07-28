package com.example.wish.controller;

import com.example.wish.dto.WishRequest;
import com.example.wish.dto.WishResponse;
import com.example.wish.model.WishLog;
import com.example.wish.service.WishService;
import java.util.List;



@RestController
@RequestMapping("/api")
public class WishController {

    private final WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @PostMapping("/wish")
    public WishResponse handleWish(@RequestBody WishRequest request) {
        String result = wishService.generateResponse(request.getWish());
        return new WishResponse(request.getWish(), result);
   }


   @GetMapping("/wishlog")
public List<WishLog> getWishLogs() {
    return wishService.getAllLogs();

}

public List<WishLog> getAllLogs() {
    return wishLogRepository.findAll();
}


}
