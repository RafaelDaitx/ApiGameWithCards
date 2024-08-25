package com.daitiks.controller;

import com.daitiks.client.CardApiClient;

import com.daitiks.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardsController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<String> realizarJogada(){

         cardService.realizarJogada();
        return null;
    }
}
