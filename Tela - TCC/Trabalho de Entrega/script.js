function salvar(event) {
    // Impedir que a página seja recarregada
    event.preventDefault();

    let nome = document.getElementById("validationCustom01").value;
    let sobrenome = document.getElementById("validationCustom02").value;
    let email = document.getElementById("validationCustomUsername").value;
    let cpf = document.getElementById("validationCustom03").value;
    let senha = document.getElementById("validationCustom06").value;
    let telefone = document.getElementById("validationCustom05").value;

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

        postPessoa(nome, sobrenome, email, senha, cpf, telefone).then(cliente => {
            const modalSucesso = new bootstrap.Modal(document.getElementById('modalSucesso'), {})
            modalSucesso.show();
            spinner.style.display = "none";  // Ocultar o spinner

            // Habilitar o botão de envio do formulário
            //submitButton.disabled = false; COMENTARIO PARA TIRAR

            // Limpar os campos do formulário
            //document.getElementById("validationCustom01").value = "";
            //document.getElementById("validationCustom02").value = "";
           // document.getElementById("validationCustomUsername").value = "";
           // document.getElementById("validationCustom03").value = "";
           // document.getElementById("validationCustom06").value = "";
            //document.getElementById("validationCustom05").value = "";
        })
    }
}

function Reload(){
    window.location.reload(true);
}

function irLogin(){
    document.location.href = 'Login.html'
}


