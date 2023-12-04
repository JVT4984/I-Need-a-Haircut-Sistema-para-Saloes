function editarSalao() {

    let nome = document.getElementById("salaoNomeEdit").value;
    let cnpj = document.getElementById("salaoCNPJEdit").value;
    let telefone = document.getElementById("salaoTelefoneEdit").value;
    let email = document.getElementById("salaoEmailEdit").value;
    let senha = document.getElementById("salaoSenhaEdit").value;

    // Verificar se todos os campos estão preenchidos
    if (!nome || !cnpj || !telefone || !email || !senha) {
        const modalErro = new bootstrap.Modal(document.getElementById('modalErro'), {})
            modalErro.show();
        return;  // Não prosseguir se algum campo estiver vazio
    } else {
        let spinner = document.getElementById("spinner");
        spinner.style.display = "inline-block";  // Exibir o spinner

        // Desabilitar o botão de envio do formulário
        let submitButton = document.querySelector('button[type="submit"]');
        //submitButton.disabled = true; COMENTARIO PARA TIRAR

        putSalao(nome, cnpj, telefone, email, senha).then(salao => {
            const modalSucesso = new bootstrap.Modal(document.getElementById('modalSucesso'), {})
            modalSucesso.show();
            spinner.style.display = "none";  // Ocultar o spinner

            // Habilitar o botão de envio do formulário
            //submitButton.disabled = false; COMENTARIO PARA TIRAR

            // Limpar os campos do formulário
            document.getElementById("salaoNomeEdit").value = "";
            document.getElementById("salaoCNPJEdit").value = "";
            document.getElementById("salaoTelefoneEdit").value = "";
            document.getElementById("salaoEmailEdit").value = "";
            document.getElementById("salaoSenhaEdit").value = "";
        })
    }
}

function voltarEditaSalao() {
    document.location.href = 'InfoSalaoParaSalao.html'
  }

window.onload = loadSalaoEdit;