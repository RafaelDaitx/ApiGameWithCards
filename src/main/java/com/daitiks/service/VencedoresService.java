package com.daitiks.service;

import com.daitiks.dto.VencedoresDTO;
import com.daitiks.mapper.VencedoresMapper;
import com.daitiks.repository.VencedoresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VencedoresService {
    private final Logger logger = LoggerFactory.getLogger(CartaService.class);

    @Autowired
    private VencedoresRepository vencedoresRepository;

    public List<VencedoresDTO> findAll() {
        return VencedoresMapper.INSTANCE.convertFromVencedoresToVencedoresDto(vencedoresRepository.findAll());
//        logger.info("Procuradno todos os jogadores!");
//    List<VencedoresDTO> vencedoresDTO = new ArrayList<>();
//        List<Vencedores>  vencedoresBuscados = (List<Vencedores>) vencedoresRepository.findAll();
//
//        for (int i = 0; i < vencedoresBuscados.size(); i++) {
//            Vencedores entity = vencedoresBuscados.get(i);
//            VencedoresDTO dto = new VencedoresDTO();
//
//            dto.setNomeVencedor(entity.getNomeVencedor());
//            dto.setCartasDoJogador(entity.getValorCartas());
//            // Mapear outros campos conforme necessário
//
//            vencedoresDTO.add(dto);
//        }

    }
}
