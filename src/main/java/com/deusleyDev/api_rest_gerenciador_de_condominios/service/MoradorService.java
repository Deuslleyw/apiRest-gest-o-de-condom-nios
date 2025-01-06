package com.deusleyDev.api_rest_gerenciador_de_condominios.service;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Morador;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.MoradorDto;

public interface MoradorService {

    Morador create (Long condominioId, Long apartamentoId, MoradorDto moradorDto);

    Morador update( Long condominioId, Long apartamentoId, Long moradorId, MoradorDto moradorDto);

    void delete(Long condominioId, Long apartamentoId, Long moradorId);
}
