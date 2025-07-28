package com.example.wish.service;

import com.example.wish.model.WishLog;
import com.example.wish.repository.WishLogRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WishService {

    private final WishLogRepository wishLogRepository;

    public WishService(WishLogRepository wishLogRepository) {
        this.wishLogRepository = wishLogRepository;
    }

    public String generateResponse(String wish) {
        String response;

        if (wish.contains("사랑")) {
            response = "💔 사랑은 언제나 타이밍이지만, 당신은 늘 늦습니다 피이~";
        } else if (wish.contains("돈") || wish.contains("부자")) {
            response = "💸 돈이 많아지면 걱정도 많아져요. 다만 월세는 편해지겠죠 에잇~";
        } else if (wish.contains("행복")) {
            response = "😊 행복이란 착각은, 가끔 미소를 지을 때 오는 착시일 뿐입니다";
        } else if (wish.contains("잠") || wish.contains("피곤")) {
            response = "😪 지쳤다고 말하지만, 사실 아무것도 안 했잖아요?";
        } else {
            response = "🤷‍♀️ 당신의 소원은 소중합니다. 그래서 반납하겠습니다. 퉤엣~";
        }

        wishLogRepository.save(new WishLog(wish, response));
        return response;
    }

    public List<WishLog> getAllLogs() {
        return wishLogRepository.findAll();
    }
}