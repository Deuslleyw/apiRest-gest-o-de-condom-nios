package com.deusleyDev.api_rest_gerenciador_de_condominios.repository;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondominioRepository extends JpaRepository<Condominio,Long> {


}