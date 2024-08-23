package com.rafael.service;

import com.rafael.client.CardApiClient;
import com.rafael.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardApiClient cardApiClient;
    private CardRepository repository;

    public List<String> realizarJogada(){
        return null;
    }
}
