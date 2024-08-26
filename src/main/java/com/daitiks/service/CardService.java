package com.daitiks.service;

import com.daitiks.client.CardApiClient;
import com.daitiks.client.response.CartaDtoApi;
import com.daitiks.dto.JogadaDTO;
import com.daitiks.dto.JogadoresDTO;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.entity.Vencedores;
import com.daitiks.mapper.JogadoresMapper;
import com.daitiks.model.Cartas;
import com.daitiks.repository.VencedoresRepository;
import com.daitiks.repository.JogadoresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final Logger logger = LoggerFactory.getLogger(CardService.class);

    @Autowired
    private CardApiClient cardApiClient;

    @Autowired
    private ResultadoService resultadoService;

    @Autowired
    private JogadoresRepository jogadoresRepository;

    @Autowired
    private VencedoresRepository vencedoresRepository;

    public CardService(
            CardApiClient cardApiClient,
            ResultadoService resultadoService,
            VencedoresRepository vencedoresRepository,
            JogadoresRepository jogadoresRepository) {
        this.cardApiClient = cardApiClient;
        this.resultadoService = resultadoService;
        this.jogadoresRepository = jogadoresRepository;
        this.vencedoresRepository = vencedoresRepository;
    }

    public List<VencedoresDTO> realizarJogada() {
        logger.info("Realiando jogada!");
        var criaDeckCartas = cardApiClient.criaDeckCartas();

        List<VencedoresDTO> listaVencedores =  distribuirCartas(criaDeckCartas);

        try{
            for(VencedoresDTO vencedorDaRodada : listaVencedores){
                String cartas = vencedorDaRodada.getCartasDoJogador().stream()
                        .map(Cartas::getValue)
                        .collect(Collectors.joining(","));
                Vencedores vencedorConvertido = new Vencedores(vencedorDaRodada.getNomeVencedor(), vencedorDaRodada.getSomaCartas(), cartas);

                var vencedorSalvo = vencedoresRepository.save(vencedorConvertido);

                vencedorDaRodada.setId(vencedorSalvo.getId());
            }
        } catch (RuntimeException e){
            throw e;
        }

        return listaVencedores;
    }

    public List<JogadoresDTO> carregarJogadores() {
        logger.info("Carregando jogadores!");
        return JogadoresMapper.INSTANCE.convertFromJogadoresToDto(jogadoresRepository.findAll());
    }

    private List<VencedoresDTO> distribuirCartas(CartaDtoApi criaDeckCartas) {
        logger.info("Destribuindo cartas!");
        List<Cartas> cartas = criaDeckCartas.getCards();
        List<JogadoresDTO> jogadoresCarregados = carregarJogadores();

        List<JogadaDTO> jogadas = distribuiCartas(jogadoresCarregados, cartas);

        return resultadoService.vencedorDaRodada(jogadas);
    }

    public List<JogadaDTO> distribuiCartas(List<JogadoresDTO> jogadoresDTO, List<Cartas> cartas) {
        logger.info("Destribuindo cartas entre jogadores!");
        int totalDeCartasParaJogador = 5;
        int numeroTotalCartasDistribuidas = 0;

        List<JogadaDTO> jogada = new ArrayList<>();

        try {
            for (JogadoresDTO jogador : jogadoresDTO) {
                List<Cartas> cartasParaJogador = obterCartasParaJogador(cartas, numeroTotalCartasDistribuidas + totalDeCartasParaJogador);
                numeroTotalCartasDistribuidas += 5;
                jogada.add(criarJogada(jogador, cartasParaJogador));
            }
        } catch (RuntimeException e){
            throw e;
        }

        return jogada;
    }

    private JogadaDTO criarJogada(JogadoresDTO jogador, List<Cartas> cartasParaJogador) {
        logger.info("Criando jogada!");
        return new JogadaDTO(jogador.getNomeJogador(), cartasParaJogador);
    }

    private List<Cartas> obterCartasParaJogador(List<Cartas> cartas, int cartaAtual) {
        logger.info("Obtendo cartas para jogador!");
        return cartas.subList(cartaAtual, cartaAtual + 5);
    }

}
