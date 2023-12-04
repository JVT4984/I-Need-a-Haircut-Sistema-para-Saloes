package com.tcc.needahaircut;

public class GetSalaoDTO {

    public String salao_nome;
    public String salao_cnpj;
    public String salao_telefone;
    public String salao_email;
    public String salao_senha;
    public String bairro;
    public String rua;
    public String numero;
    public String cidade;
    public String estado;

    public GetSalaoDTO() {

    }

    public String getSalao_nome() {
        return salao_nome;
    }

    public void setSalao_nome(String salao_nome) {
        this.salao_nome = salao_nome;
    }

    public String getSalao_cnpj() {
        return salao_cnpj;
    }

    public void setSalao_cnpj(String salao_cnpj) {
        this.salao_cnpj = salao_cnpj;
    }

    public String getSalao_telefone() {
        return salao_telefone;
    }

    public void setSalao_telefone(String salao_telefone) {
        this.salao_telefone = salao_telefone;
    }

    public String getSalao_email() {
        return salao_email;
    }

    public void setSalao_email(String salao_email) {
        this.salao_email = salao_email;
    }

    public String getSalao_senha() {
        return salao_senha;
    }

    public void setSalao_senha(String salao_senha) {
        this.salao_senha = salao_senha;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public GetSalaoDTO(String salao_nome, String salao_cnpj, String salao_telefone, String salao_email, String salao_senha, String bairro, String rua, String numero, String cidade, String estado) {
        this.salao_nome = salao_nome;
        this.salao_cnpj = salao_cnpj;
        this.salao_telefone = salao_telefone;
        this.salao_email = salao_email;
        this.salao_senha = salao_senha;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }
}
