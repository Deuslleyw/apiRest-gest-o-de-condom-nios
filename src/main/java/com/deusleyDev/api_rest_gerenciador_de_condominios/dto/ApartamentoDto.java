package com.deusleyDev.api_rest_gerenciador_de_condominios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartamentoDto {


    private Long id;
    private Long numero;
    private String bloco;
    private List<MoradorDto> moradores = new ArrayList<>();
}
