package com.daitiks.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VencedoresDTO {

    private Long id;
    private String nomeVencedor;
    private String valorCartas;
    private Integer somaCartas;
}
