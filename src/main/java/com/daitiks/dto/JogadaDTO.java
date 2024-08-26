package com.daitiks.dto;

import com.daitiks.model.Cartas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JogadaDTO {
    private String nomeJogador;
    private List<Cartas> cartasNaMao;
}
