package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.CondominioDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.CondominioMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/v1/condominios")
public class CondominioController {

    public static final String ID = "/{id}";

    @Autowired
    private CondominioService service;

    @Autowired
    private CondominioMapper condominioMapper;

    @PostMapping
    public ResponseEntity<Condominio> create(@RequestBody CondominioDto condominioDto) {
        var condominioCriado = service.create(condominioDto);
        return ResponseEntity.ok().body(condominioCriado);

    }

    @GetMapping
    public ResponseEntity<List<CondominioDto>> findAll() {
        var responseAll = service.findAll();
        var mapper = condominioMapper.toDTOList(responseAll);
        return ResponseEntity.ok().body(mapper);

    }

    @GetMapping(value = ID)
    public ResponseEntity<CondominioDto> findById(@PathVariable Long id) {
        var responseId = service.findById(id);
        var mapper = condominioMapper.fromCondominio(responseId);
        return ResponseEntity.ok().body(mapper);

    }
    @PutMapping(value = ID)
    public ResponseEntity<Condominio> update(@PathVariable Long id, @RequestBody CondominioDto condominioDto) {
        condominioDto.setId(id);
        Condominio condominioAtualizado = service.update(id, condominioDto);
        return ResponseEntity.ok().body(condominioAtualizado);
    }

}