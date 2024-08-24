package com.daitiks.client;

import com.daitiks.client.response.CartaDtoApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "deckOfCardsClient", url = "https://deckofcardsapi.com/api/deck")
public interface CardApiClient {
    @GetMapping("/new/draw/?count=25")
    public CartaDtoApi criaDeckCartas();

}
