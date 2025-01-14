package com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions;

public class FuncionarioNotFoundException extends RuntimeException{
    public FuncionarioNotFoundException(String message){
        super(message);
    }
}
