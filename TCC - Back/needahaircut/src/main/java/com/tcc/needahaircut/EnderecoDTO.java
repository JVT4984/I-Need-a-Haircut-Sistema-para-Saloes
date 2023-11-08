package com.tcc.needahaircut;

public class EnderecoDTO {
    public int endereco_id;
    public String endereco_bairro;
    public String endereco_rua;
    public String endereco_numero;
    public String endereco_complemento;
    public CidadeEntity cidade_cidade_id;

    public EnderecoDTO(int endereco_id, String endereco_bairro, String endereco_rua, String endereco_numero, String endereco_complemento, CidadeEntity cidade_cidade_id) {
        this.endereco_id = endereco_id;
        this.endereco_bairro = endereco_bairro;
        this.endereco_rua = endereco_rua;
        this.endereco_numero = endereco_numero;
        this.endereco_complemento = endereco_complemento;
        this.cidade_cidade_id = cidade_cidade_id;
    }

    public int getEndereco_id() {
        return endereco_id;
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

    public CidadeEntity getCidade_cidade_id() {
        return cidade_cidade_id;
    }

    public void setCidade_cidade_id(CidadeEntity cidade_cidade_id) {
        this.cidade_cidade_id = cidade_cidade_id;
    }

    public EnderecoDTO(){

    }
}
