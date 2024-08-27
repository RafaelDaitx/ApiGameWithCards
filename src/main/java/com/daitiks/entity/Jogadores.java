package com.daitiks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "jogadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Jogadores {

    @Id
    private Long id;

    @Column(name = "nome_jogador")
    private String nomeJogador;
}
