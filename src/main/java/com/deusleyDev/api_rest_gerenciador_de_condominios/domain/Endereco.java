package com.deusleyDev.api_rest_gerenciador_de_condominios.domain;

import com.deusleyDev.api_rest_gerenciador_de_condominios.Enums.UF;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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


    @Column(nullable = false, length = 150)
    private String logradouro;

    @Size(max = 10)
    private String numero;

    @Column(nullable = false, length = 10)
    private String complemento;

    @Column(nullable = false, length = 25)
    private String bairro;

    @Column(nullable = false, length = 25)
    private String cidade;

    @Valid
    @Column(nullable = false )
    @Enumerated(EnumType.STRING)
    private UF uf;

    @Column(nullable = false, length = 9)
    private String cep;

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    @JsonBackReference
    private Condominio condominio;
}
