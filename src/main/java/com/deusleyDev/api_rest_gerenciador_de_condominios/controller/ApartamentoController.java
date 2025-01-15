package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Apartamento;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.ApartamentoDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.ApartamentoMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/condominios/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @Autowired
    private ApartamentoMapper apartamentoMapper;

    public static final String ID = "/{id}";
    public static final String COND_ID_AP_ID = "/{condominioId}/{id}";


    @PostMapping("/{condominioId}")
    public ResponseEntity<Apartamento> create(
            @PathVariable Long condominioId,
            @RequestBody ApartamentoDto apartamentoDto) {

        var novoApartamento = apartamentoService.create(condominioId, apartamentoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoApartamento);
    }

    @GetMapping
    public ResponseEntity<List<ApartamentoDto>> findAll() {
        var responseAll = apartamentoService.findAll();
        var mapper = apartamentoMapper.toDTOList(responseAll);
        return ResponseEntity.status(HttpStatus.OK).body(mapper);
    }

    @GetMapping(value = ID)
    public ResponseEntity<ApartamentoDto> findById(@PathVariable Long id) {
        var responseId = apartamentoService.findById(id);
        var mapper = apartamentoMapper.fromApartamento(responseId);
        return ResponseEntity.status(HttpStatus.OK).body(mapper);
    }

    @PutMapping(COND_ID_AP_ID)
    public ResponseEntity<Apartamento> update(
            @PathVariable Long condominioId,

            @PathVariable Long id, @RequestBody ApartamentoDto apartamentoDto) {
        apartamentoDto.setId(id);
        Apartamento apartamentoAtualizado = apartamentoService.update(condominioId, id, apartamentoDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(apartamentoAtualizado);

    }

    @DeleteMapping(COND_ID_AP_ID)
    public ResponseEntity<?> delete(
            @PathVariable Long condominioId,
            @PathVariable Long id) {
        try {
            apartamentoService.delete(condominioId, id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao deletar o apartamento.");
        }
    }


}