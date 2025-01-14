package com.deusleyDev.api_rest_gerenciador_de_condominios.service;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Funcionario;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.FuncionarioDto;

public interface FuncionarioService {

    Funcionario create(Long condominioId, FuncionarioDto funcionarioDto);

    FuncionarioDto findByCpfFuncionario(String cpf);

    void delete(Long condominioId, Long funcionarioId);
}
