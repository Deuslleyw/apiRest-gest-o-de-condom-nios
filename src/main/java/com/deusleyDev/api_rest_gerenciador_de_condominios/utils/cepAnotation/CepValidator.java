package com.deusleyDev.api_rest_gerenciador_de_condominios.utils.cepAnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class CepValidator implements ConstraintValidator<Cep, String> {

    private static final String CEP_REGEX = "^(\\d{5})-(\\d{3})$";
    // Formato de CEP: 12345-678    ///@DeusleyDev

    @Override
    public void initialize(Cep constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return Pattern.matches(CEP_REGEX, value);
    }
}