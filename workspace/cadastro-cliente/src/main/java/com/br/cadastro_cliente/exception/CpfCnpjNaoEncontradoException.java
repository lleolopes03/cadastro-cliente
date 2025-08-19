package com.br.cadastro_cliente.exception;

public class CpfCnpjNaoEncontradoException extends RuntimeException{
    public CpfCnpjNaoEncontradoException(String message){
        super(message);

    }
}
