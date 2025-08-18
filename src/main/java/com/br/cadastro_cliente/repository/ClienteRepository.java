package com.br.cadastro_cliente.repository;

import com.br.cadastro_cliente.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    boolean existsByCpfCnpj(String cpfCnpj);
    Optional<Cliente>findByCpfCnpj(String cpfCnpj);
}
