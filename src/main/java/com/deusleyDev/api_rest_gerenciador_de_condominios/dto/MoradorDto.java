package com.deusleyDev.api_rest_gerenciador_de_condominios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoradorDto {


    private Long id;
    private String nome;
    private String cpf;
    private Long telefone;
    private String email;
}
