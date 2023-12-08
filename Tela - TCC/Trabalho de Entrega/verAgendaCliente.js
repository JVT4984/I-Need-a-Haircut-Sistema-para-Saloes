getAgendaCliente().then(agendaCliente => agendaCliente.forEach(agenda => {
    let tabela = document.getElementById("tabela-dados");
    let linha = tabela.insertRow();
    let colunaCodigo = linha.insertCell();
    let colunaCliente = linha.insertCell();
    let colunaServico = linha.insertCell();
    let colunaValor = linha.insertCell();
    let colunaData = linha.insertCell();
    let colunaHorario = linha.insertCell();
    let colunaAcao = linha.insertCell();
    let partesDaData = agenda.agenda_data.split('-');
    let dataFormatada = new Date(partesDaData[0], partesDaData[1] - 1, partesDaData[2]).toLocaleDateString('pt-BR', { day: '2-digit', month: '2-digit', year: 'numeric' });
    colunaCodigo.innerHTML = agenda.agendamento_id;
    colunaCliente.innerHTML = agenda.cliente_nome
    colunaServico.innerHTML = agenda.servico_nome;
    colunaValor.innerHTML ="R$ "+ agenda.servico_valor;
    colunaHorario.innerHTML = agenda.agenda_hora;
    colunaData.innerHTML = dataFormatada;
    colunaAcao.innerHTML = "  <button class='btn btn-danger' onclick='cancelar(this)'>Cancelar</button>";
}));

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
function cancelar(element) {
    console.log(element);
    let tdElement = element.parentNode;
    let trElement = tdElement.parentNode;
    let tabela = trElement.parentNode;
    let id = trElement.childNodes[0].innerHTML;
    console.log(id);
    
  
    deleteagendamento(id).then(() => {
      tabela.deleteRow(trElement.rowIndex);
    })
  }