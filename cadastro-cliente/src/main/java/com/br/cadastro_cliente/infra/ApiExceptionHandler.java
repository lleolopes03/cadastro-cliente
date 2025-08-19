package com.br.cadastro_cliente.infra;

import com.br.cadastro_cliente.exception.CepNaoEncontradoException;
import com.br.cadastro_cliente.exception.CpfCnpjDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(CepNaoEncontradoException.class)

    public ResponseEntity<ApiError> handlerBusinessException(CepNaoEncontradoException ex) {
        ApiError error = new ApiError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(CpfCnpjDuplicadoException.class)
    public ResponseEntity<ApiError> handleUniqueConstraintViolation(CpfCnpjDuplicadoException ex) {
        ApiError error = new ApiError(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
