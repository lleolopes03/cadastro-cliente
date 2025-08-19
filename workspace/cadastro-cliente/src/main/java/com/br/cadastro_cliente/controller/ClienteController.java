package com.br.cadastro_cliente.controller;

import com.br.cadastro_cliente.dtos.ClienteResponseDto;
import com.br.cadastro_cliente.dtos.CreateClienteDto;
import com.br.cadastro_cliente.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<ClienteResponseDto>salvar(@RequestBody @Valid CreateClienteDto createClienteDto){
        ClienteResponseDto responseDto=clienteService.salvar(createClienteDto);
        URI location=URI.create("/api/v1/cliente/"+responseDto.getId());
        return ResponseEntity.created(location).body(responseDto);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto>buscarPorId(@PathVariable Long id){
        ClienteResponseDto clienteResponseDto=clienteService.buscarPorId(id);
        return ResponseEntity.ok(clienteResponseDto);
    }
    @GetMapping("cpfcnpj/{cpfCnpj}")
    public ResponseEntity<ClienteResponseDto>buscarCpfCnpj(@PathVariable String cpfCnpj){
        ClienteResponseDto responseDto=clienteService.buscarPorCpfCnpj(cpfCnpj);
        return ResponseEntity.ok(responseDto);
    }
    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>>buscarTodos(){
        List<ClienteResponseDto>responseDtos=clienteService.buscarTodos();
        return ResponseEntity.ok(responseDtos);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deletarPorId(@PathVariable Long id){
        clienteService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDto>atualizarCliente(@PathVariable Long id, @RequestBody @Valid CreateClienteDto createClienteDto){
        ClienteResponseDto responseDto=clienteService.atualizar(id,createClienteDto);
        return ResponseEntity.ok(responseDto);
    }


}
