package com.rafael.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cards-service")
public class CardsController {

    @GetMapping
    public List Test(){
        return null;
    }
}
