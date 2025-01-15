package com.deusleyDev.api_rest_gerenciador_de_condominios.mapper;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.CondominioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CondominioMapper {

    @Mapping(source = "endereco", target = "endereco")
    CondominioDto fromCondominio(Condominio condominio);

    @Mapping(source = "endereco", target = "endereco")
    Condominio toCondominio(CondominioDto condominioDto);

    List<CondominioDto> toDTOList(List<Condominio> condominios);
}

