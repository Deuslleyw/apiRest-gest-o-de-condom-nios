package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Apartamento;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.ApartamentoDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.ApartamentoMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/condominios/apartamentos")
public class ApartamentoController {

        @Autowired
        private ApartamentoService apartamentoService;

        @Autowired
        private ApartamentoMapper apartamentoMapper;

        @PostMapping("/{condominioId}")
        public ResponseEntity<Apartamento> create(
                @PathVariable Long condominioId,
                @RequestBody ApartamentoDto apartamentoDto) {

            Apartamento novoApartamento = apartamentoService.create(condominioId, apartamentoDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoApartamento);
        }
    }

