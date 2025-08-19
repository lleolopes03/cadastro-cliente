package com.br.cadastro_cliente.exception;

public class CepNaoEncontradoException extends RuntimeException{
    public CepNaoEncontradoException(String message){
        super(message);
    }
}
