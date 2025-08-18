package com.br.cadastro_cliente.dtos;

import com.br.cadastro_cliente.domain.Endereco;
import com.br.cadastro_cliente.domain.enums.Status;
import com.br.cadastro_cliente.domain.enums.TipoPessoa;

import java.io.Serializable;
import java.time.LocalDate;

public class ClienteResponseDto  implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cpfCnpj;
    private TipoPessoa tipoPessoa;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Status status;

    public ClienteResponseDto() {
    }


    public ClienteResponseDto(Long id, String nome, String cpfCnpj, TipoPessoa tipoPessoa, String email, String telefone, LocalDate dataNascimento, Endereco endereco, Status status) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.tipoPessoa = tipoPessoa;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
