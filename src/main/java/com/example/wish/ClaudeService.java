package com.example.wish.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class ClaudeService {

    @Value("${anthropic.api.key}")
    private String apiKey;

    private final WebClient webClient = WebClient.builder()
            .baseUrl("https://api.anthropic.com/v1")
            .defaultHeader("x-api-key", apiKey)
            .defaultHeader("anthropic-version", "2023-06-01")
            .build();

    public Mono<String> askClaude(String wish) {
        Map<String, Object> body = Map.of(
                "model", "claude-3-sonnet-20240229",
                "max_tokens", 300,
                "temperature", 0.9,
                "messages", new Object[]{
                        Map.of("role", "user", "content",
                                "너는 감성 철학 병맛 AI야. 사용자가 소원을 말하면 철학적이면서 냉정하고 현실 자각시켜주는 말을 해줘. " +
                                        "약간의 유머, 냉소, 위트와 함께 감정 분석 기반 반응을 해줘. 소원: \"" + wish + "\"")
                }
        );

        return webClient.post()
                .uri("/messages")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .map(json -> {
                        List<Map<String, Object>> contentList = (java.util.List<Map<String, Object>>)
                            ((Map<String, Object>) json.get("content"));
                    return (String) contentList.get(0).get("text");
                });
    }
}
