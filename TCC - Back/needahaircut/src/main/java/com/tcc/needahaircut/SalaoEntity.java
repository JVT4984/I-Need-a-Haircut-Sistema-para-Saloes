package com.tcc.needahaircut;

public class SalaoEntity {

    public int salao_id;
    public String salao_nome;
    public String salao_cnpj;
    public String salao_telefone;
    public String salao_email;
    public String salao_senha;
    public int salao_endereco;

    public SalaoEntity(int salao_id, String salao_nome, String salao_cnpj, String salao_telefone, String salao_email, String salao_senha, int salao_endereco) {
        this.salao_id = salao_id;
        this.salao_nome = salao_nome;
        this.salao_cnpj = salao_cnpj;
        this.salao_telefone = salao_telefone;
        this.salao_email = salao_email;
        this.salao_senha = salao_senha;
        this.salao_endereco = salao_endereco;
    }
    public SalaoEntity(){

    }
}
