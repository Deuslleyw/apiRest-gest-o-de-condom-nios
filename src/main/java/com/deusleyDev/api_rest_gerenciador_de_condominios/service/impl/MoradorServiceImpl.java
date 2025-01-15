package com.deusleyDev.api_rest_gerenciador_de_condominios.service.impl;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Morador;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.MoradorDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.ApartamentoNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.CondominioNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.DataIntegrityViolationException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.MoradorNotFoundException;
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
                .orElseThrow(() -> new ApartamentoNotFoundException(
                        "Apartamento não encontrado com ID: " + apartamentoId));

        var condominio = condominioRepository.findById(condominioId)
                .orElseThrow(() -> new CondominioNotFoundException(
                        "Condomínio não encontrado com ID: " + condominioId));
        if (!apartamentoExistente.getCondominio().getId().equals(condominioId)) {
            throw new DataIntegrityViolationException(
                    "O apartamento não pertence ao condomínio informado.");
        }

        var morador = moradorMapper.toMorador(moradorDto);
        morador.setApartamento(apartamentoExistente);
        return moradorRepository.save(morador);


    }

    @Override
    public Morador update(Long condominioId, Long apartamentoId, Long moradorId, MoradorDto moradorDto) {

        var apartamentoExistente = apartamentoRepository.findById(apartamentoId)
                .orElseThrow(() -> new RuntimeException(
                        "Apartamento não encontrado com ID: " + apartamentoId));

        var condominio = condominioRepository.findById(condominioId)
                .orElseThrow(() -> new RuntimeException(
                        "Condomínio não encontrado com ID: " + condominioId));

        if (!apartamentoExistente.getCondominio().getId().equals(condominioId)) {
            throw new IllegalArgumentException(
                    "O apartamento não pertence ao condomínio informado.");
        }

        var moradores = apartamentoExistente.getMoradores();
        var moradorExistente = moradores.stream()
                .filter(morador -> morador.getId().equals(moradorId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Morador não encontrado no apartamento."));

        moradorExistente.setNome(moradorDto.getNome());
        moradorExistente.setCpf(moradorDto.getCpf());
        moradorExistente.setTelefone(moradorDto.getTelefone());
        moradorExistente.setEmail(moradorDto.getEmail());

        return moradorRepository.save(moradorExistente);
    }

    @Override
    public void delete(Long condominioId, Long apartamentoId, Long moradorId) {

        var apartamentoExistente = apartamentoRepository.findById(apartamentoId)
                .orElseThrow(() -> new ApartamentoNotFoundException(
                        "Apartamento não encontrado com ID: " + apartamentoId));

        if (!apartamentoExistente.getCondominio().getId().equals(condominioId)) {
            throw new DataIntegrityViolationException(
                    "O apartamento não pertence ao condomínio informado.");
        }

        var moradorExistente = apartamentoExistente.getMoradores().stream()
                .filter(morador -> morador.getId().equals(moradorId))
                .findFirst()
                .orElseThrow(() -> new MoradorNotFoundException(
                        "Morador não encontrado no apartamento."));
        apartamentoExistente.getMoradores().remove(moradorExistente);

        moradorRepository.deleteById(moradorExistente.getId());
    }

    @Override
    public MoradorDto findByCpf(String cpf) {

        var morador = moradorRepository.findByCpf(cpf)
                .orElseThrow(() -> new MoradorNotFoundException(
                        "Morador não encontrado com o CPF: " + cpf));
        return moradorMapper.fromMorador(morador);
    }

}
