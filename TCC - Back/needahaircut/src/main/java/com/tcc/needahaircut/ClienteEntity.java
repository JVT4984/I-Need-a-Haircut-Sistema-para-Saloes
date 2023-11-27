package com.tcc.needahaircut;

public class ClienteEntity {

    public int cliente_id;
    public String cliente_nome;
    public String cliente_sobrenome;
    public String cliente_cpf;
    public String cliente_telefone;
    public String cliente_email;
    public String cliente_senha;


    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCliente_sobrenome() {
        return cliente_sobrenome;
    }

    public void setCliente_sobrenome(String cliente_sobrenome) {
        this.cliente_sobrenome = cliente_sobrenome;
    }

    public String getCliente_cpf() {
        return cliente_cpf;
    }

    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    public String getCliente_telefone() {
        return cliente_telefone;
    }

    public void setCliente_telefone(String cliente_telefone) {
        this.cliente_telefone = cliente_telefone;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    public String getCliente_senha() {
        return cliente_senha;
    }

    public void setCliente_senha(String cliente_senha) {
        this.cliente_senha = cliente_senha;
    }

    public ClienteEntity(int cliente_id, String cliente_nome, String cliente_sobrenome, String cliente_cpf, String cliente_telefone, String cliente_email, String cliente_senha) {
        this.cliente_id = cliente_id;
        this.cliente_nome = cliente_nome;
        this.cliente_sobrenome = cliente_sobrenome;
        this.cliente_cpf = cliente_cpf;
        this.cliente_telefone = cliente_telefone;
        this.cliente_email = cliente_email;
        this.cliente_senha = cliente_senha;
    }
    public ClienteEntity(){
    }
}