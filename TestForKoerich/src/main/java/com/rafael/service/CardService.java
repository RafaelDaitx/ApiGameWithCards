package com.rafael.service;

import com.rafael.client.CardApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardApiClient cardApiClient;

    public List<String> realizarJogada(){
        return null;
    }
}
