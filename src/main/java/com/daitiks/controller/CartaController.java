package com.daitiks.controller;

import com.daitiks.client.response.CartaDtoApi;
import com.daitiks.dto.VencedoresDTO;
import com.daitiks.entity.Vencedores;
import com.daitiks.service.CartaService;
import com.daitiks.service.VencedoresService;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/cartas")
public class CartaController {

    @Autowired
    private CartaService cartaService;

    @Autowired
    private VencedoresService vecedoresService;

    @GetMapping
    @Operation(
            summary = "Realiza uma jogada", description = "Faz a jogada distribuindo 5 cartas para cada jogadores, verificando quem tem a maior soma.",
            tags = {"Item"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = CartaDtoApi.class)))
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Void.class)))
                    ),
                    @ApiResponse(
                            description = "Internal Error",
                            responseCode = "500",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Void.class)))
                    ),
                    @ApiResponse(
                            description = "Bad Gateway",
                            responseCode = "502",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Void.class)))
                    )}
    )
    public ResponseEntity<List<VencedoresDTO>> realizarJogada() {
        try {
            return ResponseEntity.ok(cartaService.realizarJogada());
        } catch (FeignException ex) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                    .body(Collections.emptyList());
        } catch (HttpClientErrorException.BadRequest ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.emptyList());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.emptyList());
        }
    }


    @GetMapping("/vencedores")
    public List<VencedoresDTO> findAll(){
        return vecedoresService.findAll();
    }

    @GetMapping("/vencedores/{nome}")
    public List<VencedoresDTO> findVencedorByName(@PathVariable String nome){
        return vecedoresService.findByName(nome);
    }
}
