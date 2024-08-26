package com.daitiks.service;

import com.daitiks.client.CardApiClient;
import com.daitiks.client.response.CartaDtoApi;
import com.daitiks.dto.JogadaDTO;
import com.daitiks.dto.JogadoresDTO;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.entity.Jogadores;
import com.daitiks.mapper.JogadoresMapper;
import com.daitiks.model.Cartas;
import com.daitiks.repository.JogadoresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {

    private final Logger logger = LoggerFactory.getLogger(CardService.class);

    @Autowired
    private CardApiClient cardApiClient;

    private ResultadoService resultadoService;

    public CardService(
            CardApiClient cardApiClient,
            ResultadoService resultadoService,
            JogadoresRepository jogadoresRepository) {
        this.cardApiClient = cardApiClient;
        this.resultadoService = resultadoService;
        this.jogadoresRepository = jogadoresRepository;
    }

    @Autowired
    private JogadoresRepository jogadoresRepository;

    public List<VencedoresDTO> realizarJogada() {
        var criaDeckCartas = cardApiClient.criaDeckCartas();

        return distribuirCartas(criaDeckCartas);
    }

    public List<JogadoresDTO> carregarJogadores() {
        return JogadoresMapper.INSTANCE.convertFromJogadoresToDto(jogadoresRepository.findAll());
    }

    private List<VencedoresDTO> distribuirCartas(CartaDtoApi criaDeckCartas) {

        List<Cartas> cartas = criaDeckCartas.getCards();
        List<JogadoresDTO> jogadoresCarregados = carregarJogadores();

        List<JogadaDTO> jogadas = distribuiCartas(jogadoresCarregados, cartas);

        return resultadoService.vencedorDaRodada(jogadas);

    }

    public List<JogadaDTO> distribuiCartas(List<JogadoresDTO> jogadoresDTO, List<Cartas> cartas) {

        int totalDeCartasParaJogador = 5;
        int cartaAtual = 0;
        List<JogadaDTO> jogada = new ArrayList<>();

        for (JogadoresDTO jogador : jogadoresDTO) {
            List<Cartas> cartasParaJogador = obterCartasParaJogador(cartas, cartaAtual + totalDeCartasParaJogador);
            cartaAtual += 5;
            jogada.add(criarJogada(jogador, cartasParaJogador));
        }

        return jogada;
    }


    private JogadaDTO criarJogada(JogadoresDTO jogador, List<Cartas> cartasParaJogador) {
        return new JogadaDTO(jogador.getNomeJogador(), cartasParaJogador);
    }

    private List<Cartas> obterCartasParaJogador(List<Cartas> cartas, int cartaAtual) {
        return cartas.subList(cartaAtual, cartaAtual + 5);
    }

}
