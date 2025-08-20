package com.br.cadastro_cliente.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "🚀 API Cadastro Cliente está rodando!";
    }


}
