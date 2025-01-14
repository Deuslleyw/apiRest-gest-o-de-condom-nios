package com.deusleyDev.api_rest_gerenciador_de_condominios.service.impl;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Condominio;
import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Funcionario;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.FuncionarioDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.CondominioNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.DataIntegrityViolationException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions.FuncionarioNotFoundException;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.FuncionarioMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.CondominioRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.repository.FuncionarioRepository;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private CondominioRepository condominioRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioMapper funcionarioMapper;


    @Override
    public Funcionario create(Long condominioId, FuncionarioDto funcionarioDto) {

        Condominio condominio = condominioRepository.findById(condominioId)
                .orElseThrow(() -> new CondominioNotFoundException("Condomínio não encontrado"));
        Funcionario funcionario = funcionarioMapper.toFuncionario(funcionarioDto);
        funcionario.setCondominio(condominio);

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public FuncionarioDto findByCpfFuncionario(String cpf) {
        var funcionario = funcionarioRepository.findByCpf(cpf)
                .orElseThrow(() -> new FuncionarioNotFoundException("Funcionario não encontrado com o CPF: " + cpf));
        return funcionarioMapper.fromFuncionario(funcionario);
    }

    @Override
    public void delete(Long condominioId, Long funcionarioId) {

            var funcionarioExistente = funcionarioRepository.findById(funcionarioId)
                    .orElseThrow(() -> new FuncionarioNotFoundException(
                            "Funcionário não encontrado com ID: " + funcionarioId));

            if (!funcionarioExistente.getCondominio().getId().equals(condominioId)) {
                throw new DataIntegrityViolationException("Funcionário não pertence ao condomínio informado.");
            }
            funcionarioRepository.deleteById(funcionarioId);

    }
}
