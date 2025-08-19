package com.br.cadastro_cliente.dtos.Mapper;

import com.br.cadastro_cliente.domain.Cliente;
import com.br.cadastro_cliente.dtos.ClienteResponseDto;
import com.br.cadastro_cliente.dtos.CreateClienteDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ClienteMapper {
    private final ModelMapper mapper;

    public ClienteMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Cliente toCliente(CreateClienteDto dto) {
        return mapper.map(dto, Cliente.class);
    }

    public ClienteResponseDto toDto(Cliente cliente) {
        return mapper.map(cliente, ClienteResponseDto.class);
    }

    public List<ClienteResponseDto> toListDto(List<Cliente> clientes) {
        return clientes.stream().map(this::toDto).collect(Collectors.toList());
    }

    public void atualizarCliente(Cliente clienteExistente, CreateClienteDto dto) {
        clienteExistente.setNome(dto.getNome());
        clienteExistente.setCpfCnpj(dto.getCpfCnpj());
        clienteExistente.setTipoPessoa(dto.getTipoPessoa());
        clienteExistente.setEmail(dto.getEmail());
        clienteExistente.setTelefone(dto.getTelefone());
        clienteExistente.setDataNascimento(dto.getDataNascimento());
        clienteExistente.setEndereco(dto.getEndereco());
        clienteExistente.setStatus(dto.getStatus());
    }



}
