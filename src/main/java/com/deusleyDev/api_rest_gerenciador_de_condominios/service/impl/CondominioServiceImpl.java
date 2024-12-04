package com.deusleyDev.api_rest_gerenciador_de_condominios.service.impl;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.CondominioDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.CondominioMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.CondominioRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondominioServiceImpl implements CondominioService {

    @Autowired
    private CondominioRepository repository;

    @Autowired
    private CondominioMapper condominioMapper;


    @Override
    public Condominio create(CondominioDto condominioDto) {
        var condominio = condominioMapper.toCondominio(condominioDto);
        var newCondominio  = repository.save(condominio);
        return newCondominio;
    }

    @Override
    public List<Condominio> findAll() {
        var condominios  =  repository.findAll();
        return condominios.stream().toList();
    }
}
