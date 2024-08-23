package com.rafael.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
