package com.deusleyDev.api_rest_gerenciador_de_condominios.domain;

import com.deusleyDev.api_rest_gerenciador_de_condominios.utils.phoneAnotation.Phone;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MORADORES")
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @CPF(message = "Cpf inválido!")
    @Column(nullable = false)
    private String cpf;

    @Phone
    @Column(nullable = false)
    private String telefone;

    @Email(message = "email inválido!")
    private String email;

    @ManyToOne
    @JsonManagedReference
    private Apartamento apartamento;
}
