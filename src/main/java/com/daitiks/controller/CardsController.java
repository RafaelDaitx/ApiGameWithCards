package com.daitiks.controller;



import com.daitiks.dto.VencedoresDTO;
import com.daitiks.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cartas")
public class CardsController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<VencedoresDTO> realizarJogada(){
        return cardService.realizarJogada();
    }
}
