package com.deusleyDev.api_rest_gerenciador_de_condominios.service;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Apartamento;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.ApartamentoDto;

import java.util.List;

public interface ApartamentoService {


    Apartamento create(Long condominioId, ApartamentoDto apartamentoDto);

    List<Apartamento> findAll();

    Apartamento findById(Long id);

    Apartamento update(Long condominioId, Long id, ApartamentoDto apartamentoDto);

    void delete(Long condominioId, Long id);

}
