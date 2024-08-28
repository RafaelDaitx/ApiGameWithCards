package com.daitiks.service;

import com.daitiks.dto.JogadaDTO;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.model.Cartas;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResultadoService {

    private static final Map<String, Integer> valorDasCartas = new HashMap<>();

    static {
        valorDasCartas.put("ACE", 1);
        valorDasCartas.put("KING", 13);
        valorDasCartas.put("QUEEN", 12);
        valorDasCartas.put("JACK", 11);
        valorDasCartas.put("2", 2);
        valorDasCartas.put("3", 3);
        valorDasCartas.put("4", 4);
        valorDasCartas.put("5", 5);
        valorDasCartas.put("6", 6);
        valorDasCartas.put("7", 7);
        valorDasCartas.put("8", 8);
        valorDasCartas.put("9", 9);
        valorDasCartas.put("10", 10);
    }

    public List<VencedoresDTO> vencedorDaRodada(List<JogadaDTO> jogadas){
        List<VencedoresDTO> vencedores = new ArrayList<>();

        int somaPontosVencedor = 0;

        for (JogadaDTO jogada : jogadas) {
            int somaCartasJogador = calcularSomaDasCartas(jogada);

            if (somaCartasJogador > somaPontosVencedor) {
                somaPontosVencedor = somaCartasJogador;
                vencedores.clear();
                adicionarVencedores(vencedores, jogada, somaPontosVencedor);
            } else if (somaCartasJogador == somaPontosVencedor) {
                adicionarVencedores(vencedores, jogada, somaCartasJogador);
            }
        }
        return vencedores;
    }

    public int calcularSomaDasCartas(JogadaDTO jogadaDTO){
        return jogadaDTO.getCartasNaMao().stream()
                .mapToInt(carta -> valorDasCartas.get(carta.getValue()))
                .sum();
    }

    public void adicionarVencedores(List<VencedoresDTO> vencedores, JogadaDTO jogada, int somaCartas){
        VencedoresDTO vencedoresDTO = new VencedoresDTO();

        String cartas = jogada.getCartasNaMao().stream()
                .map(carta -> {
                    String value = carta.getValue();
                    return valorDasCartas.getOrDefault(value, 0).toString();
                })
                .collect(Collectors.joining(","));
        vencedoresDTO.setNomeVencedor(jogada.getNomeJogador());
        vencedoresDTO.setValorCartas(cartas);
        vencedoresDTO.setSomaCartas(somaCartas);
        vencedores.add(vencedoresDTO);
    }
}
