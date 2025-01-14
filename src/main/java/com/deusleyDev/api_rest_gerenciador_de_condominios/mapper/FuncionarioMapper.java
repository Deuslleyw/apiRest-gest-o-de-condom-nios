package com.deusleyDev.api_rest_gerenciador_de_condominios.mapper;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Funcionario;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.FuncionarioDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioDto fromFuncionario(Funcionario funcionario);

    Funcionario toFuncionario(FuncionarioDto funcionarioDto);
}
