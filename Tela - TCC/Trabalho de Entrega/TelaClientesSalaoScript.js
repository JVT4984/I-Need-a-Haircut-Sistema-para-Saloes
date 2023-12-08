function carregarClientesSalao() {

    fetch('http://localhost:8080/cliente/clienteSalao', {
        headers: {
            'Authorization': localStorage.getItem("token")
        }
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        let row = document.querySelector('#ClientesSalão');
        let gruposAdicionados = [];
        data.forEach(cliente => {
            if(!gruposAdicionados.includes(cliente.cliente_id)) {
                gruposAdicionados.push(cliente.cliente_id);
                row.innerHTML += `
                <tr>
                  <td>${cliente.cliente_id}</td>
                  <td>${cliente.cliente_nome}</td>
                  <td>${cliente.cliente_sobrenome}</td>
                  <td>${cliente.cliente_cpf}</td>
                  <td>${cliente.cliente_telefone}</td>
                  <td>${cliente.cliente_email}</td>
              </tr>`;
            }
        });
    }) 
    .catch(error => console.error('Erro:', error));
}
carregarClientesSalao();

function voltarInicioSalao() {
    document.location.href = "TelaSalão.html"
}