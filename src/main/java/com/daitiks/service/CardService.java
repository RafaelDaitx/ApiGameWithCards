package com.daitiks.service;

import com.daitiks.client.CardApiClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    private final Logger logger = LoggerFactory.getLogger(CardService.class);

    @Autowired
    private CardApiClient cardApiClient;

    public List<String> realizarJogada(){
        var response =  cardApiClient.criaDeckCartas();
        return null;
    }
}
