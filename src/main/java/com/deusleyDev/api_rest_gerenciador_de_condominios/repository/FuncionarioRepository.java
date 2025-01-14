package com.deusleyDev.api_rest_gerenciador_de_condominios.repository;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    Optional<Funcionario> findByCpf(String cpf);

}
