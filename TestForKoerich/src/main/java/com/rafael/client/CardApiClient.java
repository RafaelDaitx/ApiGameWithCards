package com.rafael.client;

import com.rafael.client.response.CardApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "CardClient", url = "https://deckofcardsapi.com/api/deck/new/draw/?count=5")
public interface CardApiClient {

    @GetMapping(value = "/newCards")
    List<CardApiResponse> getCards();
}
