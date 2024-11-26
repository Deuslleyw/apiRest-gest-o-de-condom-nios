package com.deusleyDev.api_rest_gerenciador_de_condominios.service;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;

import java.util.List;

public interface CondominioService {

    Condominio create(Condominio condominio);

    List<Condominio> findAll ();
}
