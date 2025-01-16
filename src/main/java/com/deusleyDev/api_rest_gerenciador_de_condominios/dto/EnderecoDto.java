package com.deusleyDev.api_rest_gerenciador_de_condominios.dto;

import com.deusleyDev.api_rest_gerenciador_de_condominios.Enums.UF;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnderecoDto {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private UF uf;
    private String cep;

}
