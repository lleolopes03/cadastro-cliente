package com.br.cadastro_cliente.exception;

public class CpfCnpjDuplicadoException extends RuntimeException{
    public CpfCnpjDuplicadoException(String message){
        super(message);
    }
}
