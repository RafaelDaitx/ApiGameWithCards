package com.daitiks.controller;



import com.daitiks.dto.VencedoresDTO;
import com.daitiks.service.CartaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cartas")
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @GetMapping
    public List<VencedoresDTO> realizarJogada(){
        return cartaService.realizarJogada();
    }
}
