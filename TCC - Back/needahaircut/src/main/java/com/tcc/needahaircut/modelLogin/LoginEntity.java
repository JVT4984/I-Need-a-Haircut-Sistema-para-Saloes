package com.tcc.needahaircut.modelLogin;

import com.tcc.needahaircut.modelSalao.SalaoEntity;
import com.tcc.needahaircut.modelCliente.ClienteEntity;

public class LoginEntity {

    public int login_id;
    public ClienteEntity cliente_id;
    public SalaoEntity salao_id;
    public String token;
}
