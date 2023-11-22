package com.tcc.needahaircut;

public class ClienteLoginDTO {

    public int id;
    public String email;
    public String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public ClienteLoginDTO(int id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public ClienteLoginDTO(){

    }
}
