package com.deusleyDev.api_rest_gerenciador_de_condominios.utils.cepAnotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CepValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Cep {
    String message() default "CEP inválido, verifique e tente novamente!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
