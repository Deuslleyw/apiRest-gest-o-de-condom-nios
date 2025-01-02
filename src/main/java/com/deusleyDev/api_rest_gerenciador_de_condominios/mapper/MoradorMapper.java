package com.deusleyDev.api_rest_gerenciador_de_condominios.mapper;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Morador;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.MoradorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MoradorMapper {

    MoradorDto fromMorador(Morador morador);

    Morador toMorador(MoradorDto moradorDto);
}
