package com.tcc.needahaircut.controllerCliente;

public class ClienteDTO {

    public int cliente_id;
    public String cliente_nome;
    public String cliente_sobrenome;
    public String cliente_cpf;
    public String cliente_telefone;
    public String cliente_email;
    public String cliente_senha;

    public ClienteDTO(int cliente_id, String cliente_nome, String cliente_sobrenome, String cliente_cpf, String cliente_telefone, String cliente_email, String cliente_senha) {
        this.cliente_id = cliente_id;
        this.cliente_nome = cliente_nome;
        this.cliente_sobrenome = cliente_sobrenome;
        this.cliente_cpf = cliente_cpf;
        this.cliente_telefone = cliente_telefone;
        this.cliente_email = cliente_email;
        this.cliente_senha = cliente_senha;
    }
    public ClienteDTO(){
    }
}
