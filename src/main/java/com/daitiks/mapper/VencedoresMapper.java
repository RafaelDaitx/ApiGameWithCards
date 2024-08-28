package com.daitiks.mapper;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.entity.Vencedores;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VencedoresMapper {

    VencedoresMapper INSTANCE = Mappers.getMapper(VencedoresMapper.class);
    List<VencedoresDTO> convertFromVencedoresToVencedoresDto(Iterable<Vencedores> vencedores);
}
