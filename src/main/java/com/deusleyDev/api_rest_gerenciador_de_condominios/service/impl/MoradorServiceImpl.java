package com.deusleyDev.api_rest_gerenciador_de_condominios.service.impl;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Morador;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.MoradorDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.ApartamentoNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.CondominioNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.DataIntegrityViolationException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.MoradorMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.ApartamentoRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.CondominioRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.MoradorRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.MoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoradorServiceImpl implements MoradorService {

    @Autowired
    private CondominioRepository condominioRepository;

    @Autowired
    private ApartamentoRepository apartamentoRepository;

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private MoradorMapper moradorMapper;


    @Override
    public Morador create(Long condominioId, Long apartamentoId, MoradorDto moradorDto) {

        var apartamentoExistente = apartamentoRepository.findById(apartamentoId)
                .orElseThrow(() -> new ApartamentoNotFoundException("Apartamento não encontrado com ID: " + apartamentoId));

        var condominio = condominioRepository.findById(condominioId)
                .orElseThrow(() -> new CondominioNotFoundException("Condomínio não encontrado com ID: " + condominioId));
        if (!apartamentoExistente.getCondominio().getId().equals(condominioId)) {
            throw new DataIntegrityViolationException("O apartamento não pertence ao condomínio informado.");
        }

        Morador morador = moradorMapper.toMorador(moradorDto);
        morador.setApartamento(apartamentoExistente);
        return moradorRepository.save(morador);


    }
}
