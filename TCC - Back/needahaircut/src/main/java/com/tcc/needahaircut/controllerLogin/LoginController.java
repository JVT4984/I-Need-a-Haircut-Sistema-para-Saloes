package com.tcc.needahaircut.controllerLogin;

import com.tcc.needahaircut.controllerNivelAcesso.NiveldeAcessoDTO;
import com.tcc.needahaircut.modelCliente.ClienteDAO;
import com.tcc.needahaircut.modelCliente.ClienteEntity;
import com.tcc.needahaircut.modelLogin.LoginDAO;
import com.tcc.needahaircut.modelLogin.LoginEntity;
import com.tcc.needahaircut.modelSalao.SalaoDAO;
import com.tcc.needahaircut.modelSalao.SalaoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.UUID;

@RestController
@RequestMapping("/login/")
public class LoginController {
    @Autowired
    public ClienteDAO clienteDAO;
    @Autowired
    public LoginDAO loginDAO;
    @Autowired
    public SalaoDAO salaoDAO;

    @PostMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> postLogin(@RequestBody ClienteLoginDTO clienteLoginDTO) throws SQLException {
        ClienteEntity clienteLogin = new ClienteEntity();
        clienteLogin.cliente_email = clienteLoginDTO.email;
        clienteLogin.cliente_senha = clienteLoginDTO.senha;
        ClienteEntity clienteExiste = clienteDAO.getByCliente(clienteLoginDTO.email, clienteLoginDTO.senha);

        if (clienteExiste != null) {
            System.out.println("Cliente Existe");
            String token = UUID.randomUUID().toString();
            System.out.println(clienteExiste);

            LoginEntity loginEntity = new LoginEntity();
            loginEntity.cliente_id = clienteExiste;
            loginEntity.token = token;

            loginDAO.insertLoginCliente(loginEntity);

            return ResponseEntity.ok().body(token);
        } else {
            SalaoEntity salaoLogin = new SalaoEntity();
            salaoLogin.salao_email = clienteLoginDTO.email;
            salaoLogin.salao_senha = clienteLoginDTO.senha;
            SalaoEntity salaoExiste = salaoDAO.getBySalao(clienteLoginDTO.email, clienteLoginDTO.senha);

            if (salaoExiste != null) {
                System.out.println("Salão Existe");
                String token = UUID.randomUUID().toString();
                System.out.println(salaoExiste);

                LoginEntity loginEntity = new LoginEntity();
                loginEntity.salao_id = salaoExiste;
                loginEntity.token = token;

                loginDAO.insertLoginSalao(loginEntity);

                return ResponseEntity.ok().body(token);
            } else {
                System.out.println("Nenhum Existe");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public ResponseEntity<NiveldeAcessoDTO> NivelEntrada(@RequestHeader(HttpHeaders.AUTHORIZATION) String header) throws SQLException {
        Integer id = loginDAO.NivelAcesso(header);
        if (id > 0) {
            NiveldeAcessoDTO dto = new NiveldeAcessoDTO();
            dto.setIdCliente(id);
            return ResponseEntity.ok(dto);
        } else {
            NiveldeAcessoDTO dto = new NiveldeAcessoDTO();
            return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
        }
    }
}
