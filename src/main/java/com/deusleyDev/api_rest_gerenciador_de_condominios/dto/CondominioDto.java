package com.deusleyDev.api_rest_gerenciador_de_condominios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CondominioDto {

    private Long id;
    private String nome;
    private String notas;
    private EnderecoDto endereco;

    private List<FuncionarioDto> funcionarios = new ArrayList<>();
    private List<ApartamentoDto> apartamentos = new ArrayList<>();

}
