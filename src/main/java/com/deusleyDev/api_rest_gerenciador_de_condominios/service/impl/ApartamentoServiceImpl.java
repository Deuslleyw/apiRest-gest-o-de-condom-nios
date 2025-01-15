package com.deusleyDev.api_rest_gerenciador_de_condominios.service.impl;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Apartamento;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.ApartamentoDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.ApartamentoNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.CondominioNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.DataIntegrityViolationException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.ApartamentoMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.ApartamentoRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.CondominioRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        var condominio = condominioRepository.findById(condominioId)
                .orElseThrow(() -> new CondominioNotFoundException("Condomínio não encontrado"));
        var apartamento = apartamentoMapper.toApartamento(apartamentoDto);
        apartamento.setCondominio(condominio);
        return apartamentoRepository.save(apartamento);
    }

    @Override
    public List<Apartamento> findAll() {
        return apartamentoRepository.findAll();
    }

    @Override
    public Apartamento findById(Long id) {
        Optional<Apartamento> apartamento = apartamentoRepository.findById(id);
        return apartamento.orElseThrow(() -> new ApartamentoNotFoundException(
                "Ops! Não encontrado o apartamento com ID: " + id));
    }

    @Override
    public Apartamento update(Long condominioId, Long id, ApartamentoDto apartamentoDto) {
        var apartamentoExistente = apartamentoRepository.findById(id)
                .orElseThrow(() -> new ApartamentoNotFoundException(
                        "Apartamento não encontrado com ID: " + id));

        var condominio = condominioRepository.findById(condominioId)
                .orElseThrow(() -> new CondominioNotFoundException(
                        "Condomínio não encontrado com ID: " + condominioId));

        if (!apartamentoExistente.getCondominio().getId().equals(condominioId)) {
            throw new DataIntegrityViolationException(
                    "O apartamento não pertence ao condomínio informado.");
        }

        var apartamentoAtualizado = apartamentoMapper.toApartamento(apartamentoDto);
        apartamentoAtualizado.setId(apartamentoExistente.getId());
        apartamentoAtualizado.setCondominio(condominio);

        return apartamentoRepository.save(apartamentoAtualizado);

    }

    @Override
    public void delete(Long condominioId, Long id) {
        var apartamentoExistente = apartamentoRepository.findById(id)
                .orElseThrow(() -> new ApartamentoNotFoundException(
                        "Apartamento não encontrado com ID: " + id));

        var condominio = condominioRepository.findById(condominioId)
                .orElseThrow(() -> new CondominioNotFoundException(
                        "Condomínio não encontrado com ID: " + condominioId));

        if (!apartamentoExistente.getCondominio().getId().equals(condominioId)) {
            throw new DataIntegrityViolationException(
                    "O apartamento não pertence ao condomínio informado.");
        }
        apartamentoRepository.delete(apartamentoExistente);

    }


}