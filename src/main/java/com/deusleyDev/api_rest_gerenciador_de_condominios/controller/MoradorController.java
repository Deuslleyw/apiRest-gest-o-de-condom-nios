package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Morador;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.MoradorDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.ApartamentoNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.DataIntegrityViolationException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/condominios/apartamentos/moradores")
public class MoradorController {

    public static final String COND_ID_AP_ID = "/{condominioId}/{apartamentoId}";

    @Autowired
    private MoradorService moradorService;


    @PostMapping(COND_ID_AP_ID)
    public ResponseEntity<?> create(
            @PathVariable Long condominioId,
            @PathVariable Long apartamentoId,
            @RequestBody MoradorDto moradorDto) {
        try {
            Morador moradorAtribuido = moradorService.create(condominioId, apartamentoId, moradorDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(moradorAtribuido);
        } catch (ApartamentoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "Erro ao atribuir morador, verifique os dados do apartamento ou condominio");
        }
    }


}
