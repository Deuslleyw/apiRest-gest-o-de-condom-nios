package com.deusleyDev.api_rest_gerenciador_de_condominios.utils.phoneValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final String PHONE_REGEX = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$";
    // Exemplo de telefone: (48) 55555-5555  /////@DeusleyDev

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
