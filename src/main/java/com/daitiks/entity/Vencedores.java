package com.daitiks.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private String nome_vencedor;

    @Column(name = "soma_cartas")
    private Integer soma_cartas;

    @Column(name = "valor_carta")
    private String valor_carta;

    public Vencedores(String nomeVencedor, int somaCartas, String cartas) {
        this.nome_vencedor = nomeVencedor;
        this.soma_cartas = somaCartas;
        this.valor_carta = cartas;
    }
}
