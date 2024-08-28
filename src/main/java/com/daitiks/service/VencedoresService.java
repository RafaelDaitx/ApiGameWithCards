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
    }

    public List<VencedoresDTO> findByName() {
        return VencedoresMapper.INSTANCE.convertFromVencedoresToVencedoresDto(vencedoresRepository.findAll());
    }
}
