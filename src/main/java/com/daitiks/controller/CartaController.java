package com.daitiks.controller;

import com.daitiks.dto.VencedoresDTO;
import com.daitiks.service.CartaService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/cartas")
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @GetMapping
    public ResponseEntity<List<VencedoresDTO>> realizarJogada(){
        try{
            return ResponseEntity.ok(cartaService.realizarJogada());
        }catch (FeignException ex){
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(Collections.emptyList());
        } catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }
}
