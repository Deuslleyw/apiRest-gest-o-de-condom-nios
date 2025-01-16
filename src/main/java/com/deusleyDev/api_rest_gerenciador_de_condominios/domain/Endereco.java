package com.deusleyDev.api_rest_gerenciador_de_condominios.domain;

import com.deusleyDev.api_rest_gerenciador_de_condominios.Enuns.UF;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ENDERECOS")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    @Enumerated(EnumType.STRING)
    private UF uf;
    private String cep;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    @JsonBackReference
    private Condominio condominio;
}
