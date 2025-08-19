package com.br.cadastro_cliente.service;

import com.br.cadastro_cliente.config.RabbitConfig;
import com.br.cadastro_cliente.dtos.ClienteResponseDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ClienteConsumer {
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receberMensagem(ClienteResponseDto cliente) {
        System.out.println("📥 Mensagem recebida: " + cliente);
    }


}
