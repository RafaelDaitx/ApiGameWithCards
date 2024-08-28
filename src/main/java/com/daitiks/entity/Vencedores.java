package com.daitiks.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity(name = "vencedores")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vencedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_vencedor")
    private String nomeVencedor;

    @Column(name = "soma_cartas")
    private Integer somaCartas;

    @Column(name = "valor_carta")
    private String valorCartas;

    public Vencedores(String nomeVencedor, int somaCartas, String valorCartas) {
        this.nomeVencedor = nomeVencedor;
        this.somaCartas = somaCartas;
        this.valorCartas = valorCartas;
    }
}
