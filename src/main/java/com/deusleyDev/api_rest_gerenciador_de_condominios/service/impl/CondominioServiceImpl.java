package com.deusleyDev.api_rest_gerenciador_de_condominios.service.impl;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.CondominioRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.CondominioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondominioServiceImpl implements CondominioService {

    @Autowired
    private CondominioRepository repository;


    @Override
    public Condominio create(Condominio condominio) {

        var creates  = repository.save(condominio);
        return creates;
    }

    @Override
    public List<Condominio> findAll() {
        return repository.findAll();
    }
}
