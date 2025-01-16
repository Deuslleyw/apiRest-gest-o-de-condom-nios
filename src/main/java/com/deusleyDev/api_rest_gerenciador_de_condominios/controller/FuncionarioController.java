package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Funcionario;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.FuncionarioDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.FuncionarioMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/condominios/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    public static final String COND_ID = "/{condominioId}";
    public static final String FUNC_CPF = "/{cpf}";
    public static final String COND_ID_FUNC_ID = "/{condominioId}/{funcionarioId}";


    @PostMapping(COND_ID)
    public ResponseEntity<Funcionario> create(@Valid
                                              @PathVariable Long condominioId,
                                              @RequestBody FuncionarioDto funcionarioDto) {
        var novoFuncionario = funcionarioService.create(condominioId, funcionarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @GetMapping(FUNC_CPF)
    public ResponseEntity<FuncionarioDto> findByCpfFuncionario(@Valid @PathVariable String cpf) {
        var funcionarioDto = funcionarioService.findByCpfFuncionario(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioDto);

    }

    @DeleteMapping(COND_ID_FUNC_ID)
    public ResponseEntity<?> delete(@PathVariable Long condominioId,
                                    @PathVariable Long funcionarioId) {
        funcionarioService.delete(condominioId, funcionarioId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();


    }

    @PutMapping(COND_ID_FUNC_ID)
    public ResponseEntity<Funcionario> update(@Valid
                                              @PathVariable Long condominioId,
                                              @PathVariable Long funcionarioId,
                                              @RequestBody FuncionarioDto funcionarioDto) {
        funcionarioDto.setId(funcionarioId);
        var funcionarioAtualizado = funcionarioService.update(condominioId, funcionarioId, funcionarioDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(funcionarioAtualizado);

    }

}
