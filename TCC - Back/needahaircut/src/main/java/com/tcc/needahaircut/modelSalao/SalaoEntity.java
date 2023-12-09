package com.tcc.needahaircut.modelSalao;

import com.tcc.needahaircut.modelEndereco.EnderecoEntity;

public class SalaoEntity {

    public int salao_id;
    public String salao_nome;
    public String salao_cnpj;
    public String salao_telefone;
    public String salao_email;
    public String salao_senha;
    public EnderecoEntity endereco_endereco_id;


    public int getSalao_id() {
        return salao_id;
    }

    public void setSalao_id(int salao_id) {
        this.salao_id = salao_id;
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

    public EnderecoEntity getEndereco_endereco_id() {
        return endereco_endereco_id;
    }

    public void setEndereco_endereco_id(EnderecoEntity endereco_endereco_id) {
        this.endereco_endereco_id = endereco_endereco_id;
    }

    public SalaoEntity(int salao_id, String salao_nome, String salao_cnpj, String salao_telefone, String salao_email, String salao_senha, EnderecoEntity salao_endereco) {
        this.salao_id = salao_id;
        this.salao_nome = salao_nome;
        this.salao_cnpj = salao_cnpj;
        this.salao_telefone = salao_telefone;
        this.salao_email = salao_email;
        this.salao_senha = salao_senha;
        this.endereco_endereco_id = salao_endereco;
    }


    public SalaoEntity(){

    }
}
