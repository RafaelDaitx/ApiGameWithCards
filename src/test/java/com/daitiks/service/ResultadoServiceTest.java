package com.daitiks.service;

import com.daitiks.dto.JogadaDTO;
import com.daitiks.model.Cartas;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class ResultadoServiceTest {
    @Autowired
    private ResultadoService resultadoService;
    @Test
    void vencedorDaRodada() {
        List<JogadaDTO> jogadas = new ArrayList<>();
        List<Cartas> cartas = Arrays.asList(
                new Cartas("10"),
                new Cartas("6"),
                new Cartas("2"),
                new Cartas("3"),
                new Cartas("6")
        );

        List<Cartas> cartas2 = Arrays.asList(
                new Cartas("3"),
                new Cartas("3"),
                new Cartas("3"),
                new Cartas("3"),
                new Cartas("3")
        );
        JogadaDTO jogadaDTO = new JogadaDTO("Jogador 1", cartas);
        JogadaDTO jogada2DTO = new JogadaDTO("Jogador 2", cartas2 );

        jogadas.add(jogadaDTO);
        jogadas.add(jogada2DTO);

        var vencedor = resultadoService.vencedorDaRodada(jogadas);

        assertEquals("Jogador 1", vencedor.stream().findFirst().get().getNomeVencedor());
        assertEquals(27, vencedor.stream().findFirst().get().getSomaCartas());
    }

    @Test
    void calcularSomaDasCartas() {
        List<Cartas> cartas = Arrays.asList(
                new Cartas("10"),
                new Cartas("6"),
                new Cartas("2"),
                new Cartas("3"),
                new Cartas("6")
        );

        JogadaDTO jogadaDTO = new JogadaDTO("Jogador 1", cartas);
        var somaCartas = resultadoService.calcularSomaDasCartas(jogadaDTO);

        assertEquals(27,somaCartas);
    }
}