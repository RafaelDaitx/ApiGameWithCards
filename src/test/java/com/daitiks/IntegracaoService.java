package com.daitiks;

import com.daitiks.client.CardApiClient;
import com.daitiks.client.response.CartaDtoApi;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.service.CartaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class IntegracaoService {

    @Autowired
    private CardApiClient cardApiClient;
    @Test
    public void testarChamadaAPICard2() {
        CartaDtoApi response = cardApiClient.criaDeckCartas();

        assertNotNull(response.getCards());
        assertNotNull(response.getCards().get(0).getValue());
        assertEquals(25, response.getCards().size());
    }
}
