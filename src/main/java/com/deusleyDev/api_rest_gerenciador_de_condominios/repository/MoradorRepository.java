package com.deusleyDev.api_rest_gerenciador_de_condominios.repository;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Morador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MoradorRepository extends JpaRepository<Morador, Long> {

    Optional<Morador> findByCpf(String cpf);
}
