package com.daitiks.mapper;
import com.daitiks.dto.JogadoresDTO;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.entity.Jogadores;
import com.daitiks.entity.Vencedores;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface JogadoresMapper {

    JogadoresMapper INSTANCE = Mappers.getMapper(JogadoresMapper.class);

    List<JogadoresDTO> convertFromJogadoresToDto(Iterable<Jogadores> jogadores);
}
