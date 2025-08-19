package com.br.cadastro_cliente.dtos;

import com.br.cadastro_cliente.domain.Endereco;
import com.br.cadastro_cliente.domain.enums.Status;
import com.br.cadastro_cliente.domain.enums.TipoPessoa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateClienteDto {
    private String nome;
    private String cpfCnpj;
    private TipoPessoa tipoPessoa;
    private String email;
    private String telefone;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private Status status;
    private LocalDateTime dataCadastro;

    public CreateClienteDto() {
    }

    public CreateClienteDto(String nome, String cpfCnpj, TipoPessoa tipoPessoa, String telefone, String email, LocalDate dataNascimento, Endereco endereco, Status status, LocalDateTime dataCadastro) {
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.tipoPessoa = tipoPessoa;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.status = status;
        this.dataCadastro = dataCadastro;
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

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
