package com.deusleyDev.api_rest_gerenciador_de_condominios.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ApartamentoNotFoundException.class)
    public ResponseEntity<StandardError> apartamentoNotFound(
            ApartamentoNotFoundException er, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime
                .now(), HttpStatus.NOT_FOUND.value(), er.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(CondominioNotFoundException.class)
    public ResponseEntity<StandardError> condominioNotFound(
            CondominioNotFoundException er, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime
                .now(), HttpStatus.BAD_REQUEST.value(), er.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolation(
            DataIntegrityViolationException er, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime
                .now(), HttpStatus.BAD_REQUEST.value(), er.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MoradorNotFoundException.class)
    public ResponseEntity<StandardError> moradorNotFound(
            MoradorNotFoundException er, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime
                .now(), HttpStatus.BAD_REQUEST.value(), er.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(FuncionarioNotFoundException.class)
    public ResponseEntity<StandardError> funcionarioNotFound(
            FuncionarioNotFoundException er, HttpServletRequest request) {
        StandardError error = new StandardError(LocalDateTime
                .now(), HttpStatus.BAD_REQUEST.value(), er.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }



    }
