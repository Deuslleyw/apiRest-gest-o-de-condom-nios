package com.deusleyDev.api_rest_gerenciador_de_condominios.mapper;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Apartamento;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.ApartamentoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApartamentoMapper {

    ApartamentoDto fromApartamento (Apartamento apartamento);

    Apartamento toApartamento (ApartamentoDto apartamentoDto);

}

