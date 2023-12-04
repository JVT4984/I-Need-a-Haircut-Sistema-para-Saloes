async function getCliente() {
    let response = await fetch("http://localhost:8080/cliente/get", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
            }
    });
        
    let cliente = await response.json();

    return cliente;

}

async function putCliente(nome, sobrenome, cpf, telefone, email, senha) {
    let response = await fetch("http://localhost:8080/cliente/edit", {
        method: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
        },
        body: JSON.stringify ({
            cliente_nome: nome,
            cliente_sobrenome: sobrenome,
            cliente_cpf: cpf,
            cliente_telefone: telefone,
            cliente_email: email,
            cliente_senha: senha
        })
    });
    let cliente = await response.json();

    return cliente;
}

async function deleteCliente() {
    try {
        await fetch("http://localhost:8080/cliente/excluir", {
            method: "DELETE",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': localStorage.getItem("token")
            },
        });
    } catch (error) {
        console.error('Erro ao excluir o cliente:', error);
    }
}

async function loadCliente() {
    getCliente().then(cliente => {
        document.getElementById('nomeCliente').placeholder = cliente.cliente_nome;
        document.getElementById('sobrenomeCliente').placeholder = cliente.cliente_sobrenome;
        document.getElementById('cpfCliente').placeholder = cliente.cliente_cpf;
        document.getElementById('telefoneCliente').placeholder = cliente.cliente_telefone;
        document.getElementById('emailCliente').placeholder = cliente.cliente_email;
        document.getElementById('senhaCliente').placeholder = cliente.cliente_senha;
    });
}

    async function loadClienteEdit() {
        getCliente().then(cliente => {
            document.getElementById('nomeCliente').value = cliente.cliente_nome;
            document.getElementById('sobrenomeCliente').value = cliente.cliente_sobrenome;
            document.getElementById('cpfCliente').value = cliente.cliente_cpf;
            document.getElementById('telefoneCliente').value = cliente.cliente_telefone;
            document.getElementById('emailCliente').value = cliente.cliente_email;
            document.getElementById('senhaCliente').value = cliente.cliente_senha;
        });
    }

    function irInicio(){
        document.location.href = 'Tela Inicial.html'
    }



