package com.daitiks.service;

import com.daitiks.client.CardApiClient;
import com.daitiks.client.response.CartaDtoApi;
import com.daitiks.dto.JogadaDTO;
import com.daitiks.dto.JogadoresDTO;
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

    @Autowired
    private JogadoresRepository jogadoresRepository;

    public List<String> realizarJogada(){
        var criaDeckCartas =  cardApiClient.criaDeckCartas();

        distribuirCartas(criaDeckCartas);
        return null;
    }

    private void distribuirCartas(CartaDtoApi criaDeckCartas) {

        List<Cartas> cards = criaDeckCartas.getCards();
        List<JogadoresDTO> jogadoresCarregados = JogadoresMapper.INSTANCE.convertFromJogadoresToDto(jogadoresRepository.findAll());

        int numCartasPorJogador = 5;
        int indexCartaAtual = 0;
        List<JogadaDTO> jogada = new ArrayList<>();

        for (JogadoresDTO jogador : jogadoresCarregados) {

            // Verifica se há cartas suficientes para todos os jogadores
            if (indexCartaAtual + numCartasPorJogador <= cards.size()) {
                List<Cartas> cartasParaJogador = cards.subList(indexCartaAtual, indexCartaAtual + numCartasPorJogador);
                JogadaDTO jogadaDTO = new JogadaDTO(jogador.getNomeJogador(), cartasParaJogador);
                jogada.add(jogadaDTO);
                indexCartaAtual += numCartasPorJogador;
            } else {
                // Lida com o caso onde não há cartas suficientes
                System.out.println("Cartas insuficientes para todos os jogadores!");
                break;
            }
            System.out.println("maoe");
        }


//        List<Cartas> cartasNaMao = jogador1.getCartasNaMao();
//        StringBuilder sb = new StringBuilder();
//        sb.append(jogador1.getNome()).append(" = [");
//        for (int i = 0; i < cartasNaMao.size(); i++) {
//            sb.append(cartasNaMao.get(i).getValue());
//            if (i < cartasNaMao.size() - 1) {
//                sb.append(",");
//            }
//        }
//        sb.append("]");


    }
}
