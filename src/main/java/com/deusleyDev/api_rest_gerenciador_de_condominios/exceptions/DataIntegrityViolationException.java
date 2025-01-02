package com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions;

public class DataIntegrityViolationException extends RuntimeException{
    public DataIntegrityViolationException (String message){
        super(message);
    }
}
