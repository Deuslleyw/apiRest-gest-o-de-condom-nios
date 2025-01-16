package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Morador;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.MoradorDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.ApartamentoNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.DataIntegrityViolationException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.MoradorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/condominios/apartamentos/moradores")
public class MoradorController {

    public static final String COND_ID_AP_ID = "/{condominioId}/{apartamentoId}/morador";
    public static final String COND_ID_AP_ID_MID = "/{condominioId}/{apartamentoId}/{moradorId}/morador";
    public static final String M_CPF = "/morador/cpf/{cpf}";


    @Autowired
    private MoradorService moradorService;


    @PostMapping(COND_ID_AP_ID)
    public ResponseEntity<?> create(@Valid
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

    @PutMapping(COND_ID_AP_ID_MID)
    public ResponseEntity<?> update(@Valid
                                    @PathVariable Long condominioId,
                                    @PathVariable Long apartamentoId,
                                    @PathVariable Long moradorId,
                                    @RequestBody MoradorDto moradorDto) {
        try {
            Morador moradorAtualizado = moradorService.update(condominioId, apartamentoId, moradorId, moradorDto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(moradorAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar morador.");
        }
    }

    @DeleteMapping(COND_ID_AP_ID_MID)
    public ResponseEntity<?> delete(@PathVariable Long condominioId,
                                    @PathVariable Long apartamentoId,
                                    @PathVariable Long moradorId) {
        moradorService.delete(condominioId, apartamentoId, moradorId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(M_CPF)
    public ResponseEntity<MoradorDto> findByCpf(@PathVariable String cpf) {
        MoradorDto moradorDto = moradorService.findByCpf(cpf);
        return ResponseEntity.ok().body(moradorDto);
    }


}
