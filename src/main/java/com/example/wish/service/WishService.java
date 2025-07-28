package com.example.wish.service;

import com.example.wish.model.WishLog;
import java.util.List;
import java.util.ArrayList;

public class WishService {

    private List<WishLog> wishLogs = new ArrayList<>();

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

        wishLogs.add(new WishLog(wish, response));
        return response;
    }

    public List<WishLog> getAllLogs() {
        return wishLogs;
    }

    private String analyzeEmotion(String wish) {
        if (wish.contains("사랑") || wish.contains("외로움")) return "외로움";
        if (wish.contains("돈") || wish.contains("부자")) return "욕망";
        if (wish.contains("하기 싫어") || wish.contains("현실")) return "회피";
        if (wish.contains("슬퍼") || wish.contains("울고")) return "슬픔";
        return "혼종";
    }
    
    private String generateSadReality(String wish, String emotion) {
        switch (emotion) {
            case "외로움":
                return "당신이 원하는 건 사람의 손길이지만, 지금 손에 쥔 건 스마트폰입니다 피이~";
            case "욕망":
                return "갖고 싶은 건 많죠. 하지만 갖고 있는 게 뭐죠? 부재감입니다 퉤엣!!";
            case "회피":
                return "하기 싫은 건 삶이 아니라 의무죠. 근데 삶이 의무라면 뭐가 남죠? 피곤함만 남습니다";
            case "슬픔":
                return "울고 싶죠. 근데 눈물도 메말라서 감정 대신 유머로 버티고 있잖아요";
            default:
                return "현실은 늘 예고 없이 당신을 찌릅니다. 감정 없이도요.";
        }
    }
    
}