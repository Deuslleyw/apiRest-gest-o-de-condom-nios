package com.deusleyDev.api_rest_gerenciador_de_condominios.service;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.CondominioDto;

import java.util.List;

public interface CondominioService {

    Condominio create(CondominioDto condominioDto);

    List<Condominio> findAll ();

    Condominio findById(Long id);

    Condominio update(Long id , CondominioDto condominioDto);

    void delete (Long id);

}
