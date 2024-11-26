package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/condominios")
public class CondominioController {

    @Autowired
    private CondominioService service;

    @PostMapping
    public Condominio create(@RequestBody Condominio condominio) {

        var creates = service.create(condominio);
        return creates;

    }

    @GetMapping
    public ResponseEntity<List<Condominio>> findAll() {
        var response = service.findAll();
        return ResponseEntity.ok().body(response);

    }
}

