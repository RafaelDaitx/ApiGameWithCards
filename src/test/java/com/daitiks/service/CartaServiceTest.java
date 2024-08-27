package com.daitiks.service;

import com.daitiks.client.CardApiClient;
import com.daitiks.dto.JogadaDTO;
import com.daitiks.dto.JogadoresDTO;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.entity.Jogadores;
import com.daitiks.entity.Vencedores;
import com.daitiks.model.Cartas;
import com.daitiks.repository.JogadoresRepository;
import com.daitiks.repository.VencedoresRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class CartaServiceTest {

    @Autowired
    private CartaService cartaService;

    @Autowired
    private VencedoresRepository vencedoresRepository;

    @Autowired
    private CardApiClient cardApiClient;
    @Test
    void salvarVencedor() {
        var criaDeckCartas = cardApiClient.criaDeckCartas();

        List<VencedoresDTO> teste = cartaService.distribuirCartas(criaDeckCartas);
        VencedoresDTO vencedoresDTO = new VencedoresDTO(
                teste.get(0).getId(),
                teste.get(0).getNomeVencedor(),
                teste.get(0).getCartasDoJogador(),
                teste.get(0).getSomaCartas()
        );

        cartaService.salvarVencedor(vencedoresDTO);
        var dadosBuscadosDoBancp = vencedoresRepository.findById(vencedoresDTO.getId());
        // Verifica se o ID foi corretamente setado
        assertNotNull(dadosBuscadosDoBancp.get().getNome_vencedor());
        assertNotNull(dadosBuscadosDoBancp.get().getSoma_cartas());
        assertNotNull(dadosBuscadosDoBancp.get().getValor_carta());
    }

    @Test
    void carregarJogadores() {
        List<JogadoresDTO> jogadorTest = cartaService.carregarJogadores();

        assertEquals("Jogador 1", jogadorTest.get(0).getNomeJogador());
        assertEquals("Jogador 2", jogadorTest.get(1).getNomeJogador());
        assertEquals("Jogador 3", jogadorTest.get(2).getNomeJogador());
        assertEquals("Jogador 4", jogadorTest.get(3).getNomeJogador());
    }

    @Test
    void distribuirCartas() {
        var criaDeckCartas = cardApiClient.criaDeckCartas();

        List<VencedoresDTO> teste = cartaService.distribuirCartas(criaDeckCartas);
        System.out.println(teste);

        assertNotNull(teste.get(0).getNomeVencedor());
        assertNotNull(teste.get(0).getSomaCartas());
        assertNotNull(teste.get(0).getCartasDoJogador());

        assertTrue(teste.get(0).getSomaCartas() > 0);
    }

    @Test
    void definindoJogada() {
        var criaDeckCartas = cardApiClient.criaDeckCartas();

        List<JogadoresDTO> jogadorTest = cartaService.carregarJogadores();
        List<Cartas> cartas = criaDeckCartas.getCards();

        List<JogadaDTO> definindoJogadaTest = cartaService.definindoJogada(jogadorTest, cartas);

        assertEquals("Jogador 1", definindoJogadaTest.get(0).getNomeJogador());
        assertEquals("Jogador 2", definindoJogadaTest.get(1).getNomeJogador());
        assertEquals("Jogador 3", definindoJogadaTest.get(2).getNomeJogador());
        assertEquals("Jogador 4", definindoJogadaTest.get(3).getNomeJogador());

        assertEquals(5, definindoJogadaTest.get(0).getCartasNaMao().size());
        assertEquals(5, definindoJogadaTest.get(1).getCartasNaMao().size());
        assertEquals(5, definindoJogadaTest.get(2).getCartasNaMao().size());
        assertEquals(5, definindoJogadaTest.get(3).getCartasNaMao().size());

        //Verifica se tem a carta possui valor
        assertNotNull(definindoJogadaTest.get(0).getCartasNaMao().get(0).getValue());
        assertNotNull(definindoJogadaTest.get(0).getCartasNaMao().get(1).getValue());
        assertNotNull(definindoJogadaTest.get(0).getCartasNaMao().get(2).getValue());
        assertNotNull(definindoJogadaTest.get(0).getCartasNaMao().get(3).getValue());
        assertNotNull(definindoJogadaTest.get(0).getCartasNaMao().get(4).getValue());
    }
}