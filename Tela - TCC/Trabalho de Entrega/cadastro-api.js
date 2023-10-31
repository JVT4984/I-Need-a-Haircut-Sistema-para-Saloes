async function postPessoa(nome, sobrenome, email, senha, cidade, estado, cep) {
let response = await fetch("https://650eeb4554d18aabfe999fd2.mockapi.io/pessoas", {
    method: "POST",
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify ({
        nome: nome,
        sobrenome: sobrenome,
        email: email,
        senha: senha,
        cidade: cidade,
        estado: estado,
        cep: cep
    })
});
let pessoa = await response.json();

//console.log(pessoas);

return pessoa;
}

// Função para carregar produtos
function carregarServicos() {
    fetch('https://650eeb4554d18aabfe999fd2.mockapi.io/pessoas')
        .then(response => response.json())
        .then(data => {
            let row = document.querySelector('#lista-servico .row');
            // lista com grupos que já foram adicionados, serve para colocar 1 produto por grupo na pagina inicial
            let gruposAdicionados = [];
            data.forEach(pessoas => {
                // verifiqua se o algum produto com o mesmo id_grupo ja está na lista de adicionados, caso não tiver, então coloque um card do novo produto
                if(!gruposAdicionados.includes(pessoas.id)) {
                    gruposAdicionados.push(pessoas.id);
                    // criando um novo card e colocando no botão 'comparar' que eu quero passar por parâmetro
                    row.innerHTML += `
                <div class="col-md-4">
                  <div class="card mb-4 box-shadow">
                    <div class="card-body">
                      <p class="card-text">${pessoas.nome}</p>
                      <p class="card-text">${pessoas.sobrenome}</p>
                      <div class="d-flex justify-content-between align-items-center">
                        <div class="btn-group">
                          <button type="button" class="btn btn-sm btn-outline-secondary">Agendar</button>
                          <button type="button" class="btn btn-sm btn-outline-secondary">Editar</button>
                        </div>
                        <small class="text-muted">${pessoas.cidade}</small>
                        <small class="text-muted">${pessoas.cep}</small>
                      </div>
                    </div>
                  </div>
                </div>`;
                }
            });
        }) 
        .catch(error => console.error('Erro:', error));

// Chamar a função quando a página carregar
}

// Função para carregar produtos
function carregarAgenda() {
  fetch('https://650eeb4554d18aabfe999fd2.mockapi.io/pessoas')
      .then(response => response.json())
      .then(data => {
          let row = document.querySelector('#get-agenda');
          // lista com grupos que já foram adicionados, serve para colocar 1 produto por grupo na pagina inicial
          let gruposAdicionados = [];
          data.forEach(pessoas => {
              // verifiqua se o algum produto com o mesmo id_grupo ja está na lista de adicionados, caso não tiver, então coloque um card do novo produto
              if(!gruposAdicionados.includes(pessoas.id)) {
                  gruposAdicionados.push(pessoas.id);
                  // criando um novo card e colocando no botão 'comparar' que eu quero passar por parâmetro
                  row.innerHTML += `
                  <tr>
                  <td>${pessoas.nome}</td>
                  <td>${pessoas.sobrenome}</td>
                  <td>${pessoas.email}</td>
              </tr>`;
              }
          });
      }) 
      .catch(error => console.error('Erro:', error));

// Chamar a função quando a página carregar
}

// Função para carregar produtos
function carregarAgendamentoData() {
  fetch('https://650eeb4554d18aabfe999fd2.mockapi.io/pessoas')
      .then(response => response.json())
      .then(data => {
          let row = document.querySelector('#data-agenda');
          // lista com grupos que já foram adicionados, serve para colocar 1 produto por grupo na pagina inicial
          let gruposAdicionados = [];
          data.forEach(pessoas => {
              // verifiqua se o algum produto com o mesmo id_grupo ja está na lista de adicionados, caso não tiver, então coloque um card do novo produto
              if(!gruposAdicionados.includes(pessoas.id)) {
                  gruposAdicionados.push(pessoas.id);
                  // criando um novo card e colocando no botão 'comparar' que eu quero passar por parâmetro
                  row.innerHTML += `
                  <option>${pessoas.cidade}</option>`;
              }
          });
      }) 
      .catch(error => console.error('Erro:', error));

// Chamar a função quando a página carregar
}

// Função para carregar produtos
function carregarAgendamentoHora() {
  fetch('https://650eeb4554d18aabfe999fd2.mockapi.io/pessoas')
      .then(response => response.json())
      .then(data => {
          let row = document.querySelector('#hora-agenda');
          // lista com grupos que já foram adicionados, serve para colocar 1 produto por grupo na pagina inicial
          let gruposAdicionados = [];
          data.forEach(pessoas => {
              // verifiqua se o algum produto com o mesmo id_grupo ja está na lista de adicionados, caso não tiver, então coloque um card do novo produto
              if(!gruposAdicionados.includes(pessoas.id)) {
                  gruposAdicionados.push(pessoas.id);
                  // criando um novo card e colocando no botão 'comparar' que eu quero passar por parâmetro
                  row.innerHTML += `
                  <option>${pessoas.estado}</option>`;
              }
          });
      }) 
      .catch(error => console.error('Erro:', error));

// Chamar a função quando a página carregar
}

// Função para carregar ambos, serviços e agenda
function carregarTudo() {
  carregarAgendamentoHora();
  carregarAgendamentoData();
  carregarServicos();
  carregarAgenda();
}

// Chamar a função quando a página carregar
window.onload = carregarTudo;

