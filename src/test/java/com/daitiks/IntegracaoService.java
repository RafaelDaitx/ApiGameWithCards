package com.daitiks;

import com.daitiks.dto.VencedoresDTO;
import com.daitiks.service.CartaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class IntegracaoService {

    @Autowired
    private CartaService cartaService1;
    @Test
    public void testarChamadaAPICard2() {
        List<VencedoresDTO> testeIntegracao = cartaService1.realizarJogada();

        //Significa que deve ter feito a lógica, e retornado um vecedor :)
        assertNotNull(testeIntegracao);
    }
}
