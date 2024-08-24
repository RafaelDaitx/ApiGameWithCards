package com.daitiks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JogadaDTO {

    private Long id;
    private String nomeJogador;
    private int pontos;
    private int rodada;
    private String cartas;
}
