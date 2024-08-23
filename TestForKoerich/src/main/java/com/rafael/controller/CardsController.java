package com.rafael.controller;
import com.rafael.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cards-service")
public class CardsController {

    private CardService cardService;

    @PostMapping
    public List<String> realizarJogada(){
        return cardService.realizarJogada();
    }
}
