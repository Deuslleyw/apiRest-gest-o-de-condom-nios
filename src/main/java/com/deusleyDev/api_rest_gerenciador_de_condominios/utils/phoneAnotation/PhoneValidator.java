package com.deusleyDev.api_rest_gerenciador_de_condominios.utils.phoneAnotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final String PHONE_REGEX = "^\\(\\d{2}\\)\\d{9}$";
    // Exemplo de telefone: (48)555555555  /////@DeusleyDev

    @Override
    public void initialize(Phone constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return Pattern.matches(PHONE_REGEX, value);


    }
}
