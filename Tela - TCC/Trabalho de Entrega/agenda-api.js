function carregarAgendamentoServico() {
    fetch('http://localhost:8080/agendaPedido/servicoAgenda')
        .then(response => response.json())
        .then(data => {
            let row = document.querySelector('#servico-agenda');
            // lista com grupos que já foram adicionados, serve para colocar 1 produto por grupo na pagina inicial
            let gruposAdicionados = [];
            data.forEach(servico => {
                // verifiqua se o algum produto com o mesmo id_grupo ja está na lista de adicionados, caso não tiver, então coloque um card do novo produto
                if(!gruposAdicionados.includes(servico.servico_id)) {
                    gruposAdicionados.push(servico.servico_id);
                    // criando um novo card e colocando no botão 'comparar' que eu quero passar por parâmetro
                    row.innerHTML += `
                    <option>${servico.servico_nome}</option>`;
                }
            });
        }) 
        .catch(error => console.error('Erro:', error));
  
  // Chamar a função quando a página carregar
  }

  function carregarTudoAgendamento() {
    carregarAgendamentoServico();
}

async function postAgendamento(servico, data, hora) {
    let response = await fetch("http://localhost:8080/agendaPedido/", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
        },
        body: JSON.stringify ({
            servico_nome: servico,
	        data: data,
	        horario: hora
        })
    });
    let agendamento = await response.json();
    
    return agendamento;
    }

window.onload = carregarTudoAgendamento;

async function getAgendaCliente() {
    let response = await fetch("http://localhost:8080/agendaPedido/clienteAgenda", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
            }
    });
        
    let agendaCliente = await response.json();

    return agendaCliente;

}

async function deleteagendamento(id) {
    let response = await fetch("http://localhost:8080/agendaPedido/" + id, {
        method: "DELETE",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
        },
    });
    let agenda = await response.json();

    

    return agenda;
}