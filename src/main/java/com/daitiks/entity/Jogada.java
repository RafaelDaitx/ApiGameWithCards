package com.daitiks.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "jogadas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Jogada {

    @Id
    private Long id;

    @Column(name = "nomeJogador")
    private String nomeJogador;

    @Column(name = "pontos")
    private int pontos;

    @Column(name = "rodada")
    private int rodada;

    @Column(name = "cartas")
    private String cartas;
}
