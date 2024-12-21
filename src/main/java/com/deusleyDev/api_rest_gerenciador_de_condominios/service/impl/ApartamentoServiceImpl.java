package com.deusleyDev.api_rest_gerenciador_de_condominios.service.impl;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Apartamento;
import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.ApartamentoDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.ApartamentoMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.ApartamentoRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.CondominioRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApartamentoServiceImpl implements ApartamentoService {

    @Autowired
    private CondominioRepository condominioRepository;

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private ApartamentoMapper apartamentoMapper;


    @Override
    public Apartamento create(Long condominioId, ApartamentoDto apartamentoDto) {
        Condominio condominio = condominioRepository.findById(condominioId)
                .orElseThrow(() -> new RuntimeException("Condomínio não encontrado"));
        Apartamento apartamento = apartamentoMapper.toApartamento(apartamentoDto);
        apartamento.setCondominio(condominio);
        return apartamentoRepository.save(apartamento);
    }

}

