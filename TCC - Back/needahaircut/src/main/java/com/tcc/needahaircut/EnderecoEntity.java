package com.tcc.needahaircut;

public class EnderecoEntity {
    public int endereco_id;
    public String endereco_bairro;
    public String endereco_rua;
    public String endereco_numero;
    public String endereco_complemento;
    public CidadeEntity cidadeEntity;

    public EnderecoEntity(int endereco_id, String endereco_bairro, String endereco_rua, String endereco_numero, String endereco_complemento, CidadeEntity cidadeEntity) {
        this.endereco_id = endereco_id;
        this.endereco_bairro = endereco_bairro;
        this.endereco_rua = endereco_rua;
        this.endereco_numero = endereco_numero;
        this.endereco_complemento = endereco_complemento;
        this.cidadeEntity = cidadeEntity;
    }

    public void setEndereco_id(int endereco_id) {
        this.endereco_id = endereco_id;
    }

    public String getEndereco_bairro() {
        return endereco_bairro;
    }

    public void setEndereco_bairro(String endereco_bairro) {
        this.endereco_bairro = endereco_bairro;
    }

    public String getEndereco_rua() {
        return endereco_rua;
    }

    public void setEndereco_rua(String endereco_rua) {
        this.endereco_rua = endereco_rua;
    }

    public String getEndereco_numero() {
        return endereco_numero;
    }

    public void setEndereco_numero(String endereco_numero) {
        this.endereco_numero = endereco_numero;
    }

    public String getEndereco_complemento() {
        return endereco_complemento;
    }

    public void setEndereco_complemento(String endereco_complemento) {
        this.endereco_complemento = endereco_complemento;
    }

    public CidadeEntity getCidadeEntity() {
        return cidadeEntity;
    }

    public void setCidadeEntity(CidadeEntity cidadeEntity) {
        this.cidadeEntity = cidadeEntity;
    }

    public EnderecoEntity(){

    }
}