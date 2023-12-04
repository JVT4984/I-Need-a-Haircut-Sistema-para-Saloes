function carregarSalao() {
  fetch('http://localhost:8080/salaoTeste/')
      .then(response => response.json())
      .then(data => {
          let row = document.querySelector('#salaoInfo');
          let gruposAdicionados = [];
          data.forEach(salao => {
              if(!gruposAdicionados.includes(salao.salao_nome)) {
                  gruposAdicionados.push(salao.salao_nome);
                  row.innerHTML += `
                  <h2>Sobre o Salão</h2>
                              <br>
                              <label for="nomeSalao" class="form-label">Nome do Salão</label>
                              <input type="text" class="form-control" id="nomeSalao" placeholder="${salao.salao_nome}" readonly>
                              <br>
                              <label for="cnpjSalao" class="form-label">CNPJ</label>
                              <input type="text" class="form-control" id="cnpjSalao" placeholder="${salao.salao_cnpj}" readonly>
                              <br>
                              <label for="telefoneSalao" class="form-label">Telefone</label>
                              <input type="text" class="form-control" id="telefoneSalao" placeholder="${salao.salao_telefone}" readonly>
                              <br>
                              <label for="emailSalao" class="form-label">Email</label>
                              <input type="email" class="form-control" id="emailSalao" placeholder="${salao.salao_email}" readonly>
                              <br>
                              <h2>Endereço do Salão</h2>
                              <label for="estadoSalao" class="form-label">Estado</label>
                              <input type="text" class="form-control" id="estadoSalao" placeholder="${salao.estado}" readonly>
                              <br>
                              <label for="cidadeSalao" class="form-label">Cidade</label>
                              <input type="text" class="form-control" id="cidadeSalao" placeholder="${salao.cidade}" readonly>
                              <br>
                              <label for="bairroSalao" class="form-label">Bairro</label>
                              <input type="text" class="form-control" id="bairroSalao" placeholder="Bairro ${salao.bairro}" readonly>
                              <br>
                              <label for="ruaSalao" class="form-label">Rua</label>
                              <input type="text" class="form-control" id="ruaSalao" placeholder="Rua ${salao.rua}" readonly>
                              <br>
                              <label for="numeroSalao" class="form-label">Numero da Residencia</label>
                              <input type="text" class="form-control" id="numeroSalao" placeholder="${salao.numero}" readonly>
                              <br>
                              <button type="button" class="btn btn-danger" onclick="voltarTelaInicial()">Voltar</button>`;
              }
          });
      }) 
      .catch(error => console.error('Erro:', error));
}

async function getSalao() {
    let response = await fetch("http://localhost:8080/salao/id", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
            }
    });
        
    let salao1 = await response.json();

    return salao1;

}

async function putSalao(nome, cnpj, telefone, email, senha) {
    let response = await fetch("http://localhost:8080/salao/put", {
        method: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
        },
        body: JSON.stringify ({
            salao_nome: nome,
            salao_cnpj: cnpj,
            salao_telefone: telefone,
            salao_email: email,
            salao_senha: senha
        })
    });
    let salao = await response.json();


    return salao;
}

async function loadSalao() {
    getSalao().then(salao1 => {
        document.getElementById('salaoNome').placeholder = salao1.salao_nome;
        document.getElementById('salaoCNPJ').placeholder = salao1.salao_cnpj;
        document.getElementById('salaoTelefone').placeholder = salao1.salao_telefone;
        document.getElementById('salaoEmail').placeholder = salao1.salao_email;
        document.getElementById('salaoSenha').placeholder = salao1.salao_senha;
    });
}

async function loadSalaoEdit() {
    getSalao().then(salao => {
        document.getElementById('salaoNomeEdit').value = salao.salao_nome;
        document.getElementById('salaoCNPJEdit').value = salao.salao_cnpj;
        document.getElementById('salaoTelefoneEdit').value = salao.salao_telefone;
        document.getElementById('salaoEmailEdit').value = salao.salao_email;
        document.getElementById('salaoSenhaEdit').value = salao.salao_senha;
    });
}

window.onload = carregarSalao;

window.onload = loadSalao;

function voltarTelaInicial() {
  document.location.href = 'Tela Inicial.html'
}

function irEditarSalao() {
    document.location.href = 'SalaoEditar.html'
  }

function votarTelaInicioSalao() {
    document.location.href = 'TelaSalão.html'
}


