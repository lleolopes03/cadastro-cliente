package com.br.cadastro_cliente.config;

import org.springframework.amqp.core.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    public static final String QUEUE = "cliente.queue";
    public static final String DLQ_QUEUE = "cliente.queue.dlx";
    public static final String EXCHANGE = "cliente.exchange";
    public static final String DLQ_EXCHANGE = "cliente.exchange.dlx";
    public static final String ROUTING_KEY = "cliente.created";
    public static final String DLQ_ROUTING_KEY = "cliente.created.dlx";

    @Bean
    public Queue clienteQueue() {
        return QueueBuilder.durable(QUEUE)
                .withArgument("x-dead-letter-exchange", DLQ_EXCHANGE)
                .withArgument("x-dead-letter-routing-key", DLQ_ROUTING_KEY)
                .build();
    }

    @Bean
    public DirectExchange clienteExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding clienteBinding() {
        return BindingBuilder.bind(clienteQueue()).to(clienteExchange()).with(ROUTING_KEY);
    }

    // Dead Letter Queue
    @Bean
    public Queue clienteDlqQueue() {
        return QueueBuilder.durable(DLQ_QUEUE).build();
    }

    @Bean
    public DirectExchange clienteDlqExchange() {
        return new DirectExchange(DLQ_EXCHANGE);
    }

    @Bean
    public Binding clienteDlqBinding() {
        return BindingBuilder.bind(clienteDlqQueue()).to(clienteDlqExchange()).with(DLQ_ROUTING_KEY);
    }


}
