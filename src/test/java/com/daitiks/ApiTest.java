package com.daitiks;

import com.daitiks.client.CardApiClient;
import com.daitiks.client.response.CartaDtoApi;
import com.daitiks.dto.JogadaDTO;
import com.daitiks.dto.JogadoresDTO;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.entity.Vencedores;
import com.daitiks.model.Cartas;
import com.daitiks.repository.JogadoresRepository;
import com.daitiks.repository.VencedoresRepository;
import com.daitiks.service.CardService;
import com.daitiks.service.ResultadoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ApiTest {
    @Mock
    private CardApiClient cardApiClient;

    @Mock
    private VencedoresRepository vencedoresRepository;

    @Mock
    private JogadoresRepository jogadoresRepository;

    @Mock
    private ResultadoService resultadoService;
    @Mock
    private CardService cardService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testaSomaCartas() {
        Map<String, Integer> valorDasCartas = new HashMap<>();
        valorDasCartas.put("10", 10);
        valorDasCartas.put("6", 6);
        valorDasCartas.put("1", 1);
        valorDasCartas.put("3", 3);

        List<Cartas> cartas = Arrays.asList(
                new Cartas("10"),
                new Cartas("6"),
                new Cartas("1"),
                new Cartas("3"),
                new Cartas("6")
        );
        JogadaDTO jogadaDTO = new JogadaDTO("Jogador 1", cartas);
        when(resultadoService.calcularSomaDasCartas(any(JogadaDTO.class))).thenAnswer(invocation -> {
            JogadaDTO dto = invocation.getArgument(0);
            return dto.getCartasNaMao().stream()
                    .mapToInt(carta -> valorDasCartas.getOrDefault(carta.getValue(), 0))
                    .sum();
        });

        // Executar o método a ser testado
        int somaCartas = resultadoService.calcularSomaDasCartas(jogadaDTO);

        // Verificar o resultado
        assertEquals(26, somaCartas);
    }

}
