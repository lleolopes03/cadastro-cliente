package com.br.cadastro_cliente.service;

import com.br.cadastro_cliente.domain.Cliente;
import com.br.cadastro_cliente.dtos.ClienteResponseDto;
import com.br.cadastro_cliente.dtos.CreateClienteDto;
import com.br.cadastro_cliente.dtos.Mapper.ClienteMapper;
import com.br.cadastro_cliente.exception.CpfCnpjDuplicadoException;
import com.br.cadastro_cliente.exception.CpfCnpjNaoEncontradoException;
import com.br.cadastro_cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    ClienteProducer clienteProducer;
    @Autowired
    ClienteMapper clienteMapper;

    public ClienteResponseDto salvar(CreateClienteDto createClienteDto){
        if(clienteRepository.existsByCpfCnpj(createClienteDto.getCpfCnpj())){
            throw new CpfCnpjDuplicadoException("Cpf/Cnpj já cadastrado");

        }
        Cliente cliente= clienteMapper.toCliente(createClienteDto);
        Cliente clienteSalvo=clienteRepository.save(cliente);
        ClienteResponseDto responseDto=clienteMapper.toDto(clienteSalvo);
        clienteProducer.enviarEventoCliente(responseDto);
        return responseDto;
    }
    public ClienteResponseDto buscarPorId(Long id){
        Cliente cliente=clienteRepository.findById(id).orElseThrow(()->new CpfCnpjNaoEncontradoException(String.format("Cpf/Cnpj com id: %s não encontrado",id)));
        return clienteMapper.toDto(cliente);
    }
    public List<ClienteResponseDto>buscarTodos(){
        List<Cliente>clientes=clienteRepository.findAll();
        return clienteMapper.toListDto(clientes);
    }
    public ClienteResponseDto buscarPorCpfCnpj(String cpfCnpj){
        Cliente cliente=clienteRepository.findByCpfCnpj(cpfCnpj).orElseThrow(()->new CpfCnpjNaoEncontradoException(String.format("Cpf/Cnpj: %s não encontrado",cpfCnpj)));
        return clienteMapper.toDto(cliente);
    }
    public void deletarPorId(Long id){
        if(!clienteRepository.existsById(id)){
           throw  new RuntimeException("Id não encontrado");
        }

        clienteRepository.deleteById(id);
    }
    public ClienteResponseDto atualizar(Long id, CreateClienteDto dto) {
        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new CpfCnpjNaoEncontradoException("Cliente não encontrado"));

        clienteMapper.atualizarCliente(clienteExistente, dto);
        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);

        return clienteMapper.toDto(clienteAtualizado);
    }






}
