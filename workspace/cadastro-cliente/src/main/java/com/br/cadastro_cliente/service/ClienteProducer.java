package com.br.cadastro_cliente.service;

import com.br.cadastro_cliente.config.RabbitConfig;
import com.br.cadastro_cliente.dtos.ClienteResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ClienteProducer {
    private final RabbitTemplate rabbitTemplate;

    public void enviarEventoCliente(ClienteResponseDto cliente) {
        System.out.println("📤 Enviando cliente para fila: " + cliente.getNome());
        rabbitTemplate.convertAndSend(
                "cliente.exchange",
                "cliente.created", // mesma routing key do binding
                cliente
        );


    }


}
