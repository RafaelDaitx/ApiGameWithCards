package com.daitiks.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "jogadores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Jogadores {

    @Id
    private Long id;

    @Column(name = "nomeJogador")
    private String nomeJogador;
}
