package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.CondominioDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/condominios")
public class CondominioController {

    public static final String ID = "/{id}";

    @Autowired
    private CondominioService service;

    @PostMapping
    public ResponseEntity<CondominioDto> create(@RequestBody CondominioDto condominioDto){

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path(ID)
                .buildAndExpand(service.create(condominioDto).getId()).toUri();
        return ResponseEntity.created(uri).build();


    }

    @GetMapping
    public ResponseEntity<List<Condominio>> findAll() {
        var response = service.findAll();
        return ResponseEntity.ok().body(response);

    }
}

