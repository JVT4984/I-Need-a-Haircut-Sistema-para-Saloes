// Função para carregar produtos
function carregarServicos() {
    fetch('http://localhost:8080/servico/')
        .then(response => response.json())
        .then(data => {
            let row = document.querySelector('#lista-servico .row');
            // lista com grupos que já foram adicionados, serve para colocar 1 produto por grupo na pagina inicial
            let gruposAdicionados = [];
            data.forEach(servico => {
                // verifiqua se o algum produto com o mesmo id_grupo ja está na lista de adicionados, caso não tiver, então coloque um card do novo produto
                if(!gruposAdicionados.includes(servico.servico_id)) {
                    gruposAdicionados.push(servico.servico_id);
                    // criando um novo card e colocando no botão 'comparar' que eu quero passar por parâmetro
                    row.innerHTML += `
                    <div class="col-md-4">
                    <div class="card mb-4 box-shadow">
                      <div class="card-body">
                        <p class="card-text">Serviço: ${servico.servico_nome}</p>
                        <p class="card-text">Tipo de Serviço: ${servico.servico_tipo}</p>
                        <div class="d-flex justify-content-between align-items-center">
                          <small class="text-muted">Tempo Estimado: ${servico.servico_tempo}</small>
                          <small class="text-muted">Valor Estimado: R$ ${servico.servico_valor}</small>
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
carregarServicos();

function irInfoSalao() {
    document.location.href = 'InfoSalao.html'
  }


function irParaInfCliente() {
    document.location.href = "infoCliente.html"
}

function irAgendaCliente(){
    document.location.href = "TelaAgendaCliente.html"
}

function irAgendar(){
    document.location.href = "AgendarHorario.html"
}

function SairConta(){
  localStorage.removeItem('token')
  document.location.href = "Login.html"
}