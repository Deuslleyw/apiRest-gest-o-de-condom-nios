package com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions;

public class CondominioNotFoundException extends RuntimeException{
    public CondominioNotFoundException(String message){
        super(message);
    }

}
