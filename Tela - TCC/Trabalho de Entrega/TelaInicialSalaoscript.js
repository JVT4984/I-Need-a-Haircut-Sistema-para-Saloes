function irInfSalaobySalao() {
    document.location.href = "InfoSalaoParaSalao.html"
}

function irClientesSalao() {
    document.location.href = "ListaClientesSalao.html"
}

function carregarAgendaSalao() {

    fetch('http://localhost:8080/agendaPedido/salaoAgenda', {
        headers: {
            'Authorization': localStorage.getItem("token")
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        let row = document.querySelector('#AgendaSalão');
        let gruposAdicionados = [];
        data.forEach(agenda => {
            if(!gruposAdicionados.includes(agenda.agendamento_id)) {
                gruposAdicionados.push(agenda.agendamento_id);
                row.innerHTML += `
                <tr>
                  <td>${agenda.agendamento_id}</td>
                  <td>${agenda.cliente_nome}</td>
                  <td>${agenda.servico_nome}</td>
                  <td>R$ ${agenda.servico_valor}</td>
                  <td>${agenda.agenda_data}</td>
                  <td>${agenda.agenda_hora}</td>
              </tr>`;
            }
        });
    }) 
    .catch(error => console.error('Erro:', error));
}
carregarAgendaSalao();