package com.deusleyDev.api_rest_gerenciador_de_condominios.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CONDOMINIOS")
public class Condominio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Size( max = 255)
    private String notas;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    @JsonManagedReference
    private Endereco endereco;

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Funcionario> funcionarios = new ArrayList<>();

    @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Apartamento> apartamentos = new ArrayList<>();

}
