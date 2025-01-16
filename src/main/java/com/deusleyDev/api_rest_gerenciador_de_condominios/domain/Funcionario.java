package com.deusleyDev.api_rest_gerenciador_de_condominios.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @CPF
    private String cpf;

    ///IMPLEMENTAR  A VALIDAçÃO
    private Long telefone;

    @Size(max = 25)
    private String cargo;

    @ManyToOne
    @JsonBackReference
    private Condominio condominio;
}
