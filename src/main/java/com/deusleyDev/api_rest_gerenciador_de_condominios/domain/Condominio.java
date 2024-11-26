package com.deusleyDev.api_rest_gerenciador_de_condominios.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "CONDOMINIOS")
public class Condominio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String endereco;
    private String notas;

    @OneToMany(mappedBy = "condominio")
    private List<Funcionario> funcionarios = new ArrayList<>();

    @OneToMany(mappedBy = "condominio")
    private List<Apartamento> apartamentos = new ArrayList<>();

}
