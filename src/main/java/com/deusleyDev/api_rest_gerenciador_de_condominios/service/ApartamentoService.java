package com.deusleyDev.api_rest_gerenciador_de_condominios.service;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Apartamento;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.ApartamentoDto;

public interface ApartamentoService {



    Apartamento create(Long condominioId, ApartamentoDto apartamentoDto);
}
