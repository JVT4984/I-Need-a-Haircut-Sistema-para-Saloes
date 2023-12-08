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
    getSalao().then(salao => {
        document.getElementById('salaoNome').placeholder = salao.salao_nome;
        document.getElementById('salaoCNPJ').placeholder = salao.salao_cnpj;
        document.getElementById('salaoTelefone').placeholder = salao.salao_telefone;
        document.getElementById('salaoEmail').placeholder = salao.salao_email;
        document.getElementById('salaoSenha').placeholder = salao.salao_senha;
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

function voltarEditar() {
    document.location.href = 'InfoSalaoParaSalao.html'
}


