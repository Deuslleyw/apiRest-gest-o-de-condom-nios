package com.deusleyDev.api_rest_gerenciador_de_condominios.controller;

import com.deusleyDev.api_rest_gerenciador_de_condominios.domain.Funcionario;
import com.deusleyDev.api_rest_gerenciador_de_condominios.dto.FuncionarioDto;
import com.deusleyDev.api_rest_gerenciador_de_condominios.mapper.FuncionarioMapper;
import com.deusleyDev.api_rest_gerenciador_de_condominios.service.FuncionarioService;
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
    public ResponseEntity<Funcionario> create(
            @PathVariable Long condominioId,
            @RequestBody FuncionarioDto funcionarioDto) {

        var novoFuncionario = funcionarioService.create(condominioId, funcionarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

   @GetMapping(FUNC_CPF)
    public ResponseEntity<FuncionarioDto> findByCpfFuncionario(@PathVariable String cpf) {
       var funcionarioDto = funcionarioService.findByCpfFuncionario(cpf);
       return ResponseEntity.ok().body(funcionarioDto);

   }

   @DeleteMapping(COND_ID_FUNC_ID)
    public ResponseEntity<?> delete(
            @PathVariable Long condominioId,
            @PathVariable Long funcionarioId) {
        funcionarioService.delete(condominioId, funcionarioId);
        return ResponseEntity.noContent().build();


    }


}
