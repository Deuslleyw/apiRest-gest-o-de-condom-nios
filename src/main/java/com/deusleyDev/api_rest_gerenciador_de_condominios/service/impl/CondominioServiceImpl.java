package com.deusleyDev.api_rest_gerenciador_de_condominios.service.impl;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.CondominioDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.CondominioNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.CondominioMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.CondominioRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondominioServiceImpl implements CondominioService {

    @Autowired
    private CondominioRepository repository;

    @Autowired
    private CondominioMapper condominioMapper;


    @Override
    public Condominio create(CondominioDto condominioDto) {
        var convertedCondominio = condominioMapper.toCondominio(condominioDto);
        var condominioCriado = repository.save(convertedCondominio);
        return condominioCriado;

    }

    @Override
    public List<Condominio> findAll() {
        return repository.findAll();

    }

    @Override
    public Condominio findById(Long id) {
        Optional<Condominio> condominio = repository.findById(id);
        return condominio.orElseThrow(() -> new CondominioNotFoundException("Ops! Não encontrado com ID: " + id));
    }

    @Override
    public Condominio update(Long id, CondominioDto condominioDto) {

        var condominioExistente = repository.findById(id)
                .orElseThrow(() -> new CondominioNotFoundException("Condomínio não encontrado com ID: " + id));
       var condominioAtualizado = condominioMapper.toCondominio(condominioDto);
         condominioAtualizado.setId(condominioExistente.getId());
        return repository.save(condominioAtualizado);
    }

    @Override
    public void delete(Long id) {
        var condominioExistente = repository.findById(id)
                .orElseThrow(() -> new CondominioNotFoundException("Condomínio não encontrado com ID: " + id));
        repository.deleteById(id);
    }
}