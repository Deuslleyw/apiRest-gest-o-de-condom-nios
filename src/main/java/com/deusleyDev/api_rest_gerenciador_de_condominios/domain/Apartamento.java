package com.deusleyDev.api_rest_gerenciador_de_condominios.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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
    private Long numero;
    private String bloco;

    @ManyToOne
    @JoinColumn(name = "condominio_id", nullable = false)
    @JsonBackReference
    private Condominio condominio;

    @OneToMany(mappedBy = "apartamento")
    @JsonBackReference
    private List<Morador> moradores = new ArrayList<>();
}
