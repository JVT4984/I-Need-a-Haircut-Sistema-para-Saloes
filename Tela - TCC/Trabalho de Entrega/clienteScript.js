function excluirCliente() {
    deleteCliente().then(() => {
        document.location.href = 'Login.html'
    })
}

function abrirModal() {
    const modalErroLogin = new bootstrap.Modal(document.getElementById('modalAvisoDelete'), {})
    modalErroLogin.show();
}

function editarCliente() {

    let nome = document.getElementById("nomeCliente").value;
    let sobrenome = document.getElementById("sobrenomeCliente").value;
    let cpf = document.getElementById("cpfCliente").value;
    let telefone = document.getElementById("telefoneCliente").value;
    let email = document.getElementById("emailCliente").value;
    let senha = document.getElementById("senhaCliente").value;
    

    // Verificar se todos os campos estão preenchidos
    if (!nome || !sobrenome || !email || !cpf || !senha || !telefone) {
        const modalErro = new bootstrap.Modal(document.getElementById('modalErro'), {})
            modalErro.show();
        return;  // Não prosseguir se algum campo estiver vazio
    } else {
        let spinner = document.getElementById("spinner");
        spinner.style.display = "inline-block";  // Exibir o spinner

        // Desabilitar o botão de envio do formulário
        let submitButton = document.querySelector('button[type="submit"]');
        //submitButton.disabled = true; COMENTARIO PARA TIRAR

        putCliente(nome, sobrenome, cpf, telefone, email, senha).then(cliente => {
            const modalSucesso = new bootstrap.Modal(document.getElementById('modalSucesso'), {})
            modalSucesso.show();
            spinner.style.display = "none";  // Ocultar o spinner

            // Habilitar o botão de envio do formulário
            //submitButton.disabled = false; COMENTARIO PARA TIRAR

            // Limpar os campos do formulário
            document.getElementById("validationCustom01").value = "";
            document.getElementById("validationCustom02").value = "";
            document.getElementById("validationCustomUsername").value = "";
            document.getElementById("validationCustom03").value = "";
            document.getElementById("validationCustom06").value = "";
            document.getElementById("validationCustom05").value = "";
        })
    }
}

function irEditar(){
    document.location.href = 'editarCliente.html'
}

function voltarEditar(){
    document.location.href = "infoCliente.html"
}