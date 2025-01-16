package com.deusleyDev.api_rest_gerenciador_de_condominios.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "APARTAMENTOS")
public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private Long numero;

    @Column(nullable = false, length = 10)
    private String bloco;

    @ManyToOne
    @JoinColumn(name = "condominio_id", nullable = false)
    @JsonBackReference
    private Condominio condominio;

    @OneToMany(mappedBy = "apartamento", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Morador> moradores = new ArrayList<>();
}
