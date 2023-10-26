function salvar(event) {
    // Impedir que a página seja recarregada
    event.preventDefault();

    let nome = document.getElementById("validationCustom01").value;
    let sobrenome = document.getElementById("validationCustom02").value;
    let email = document.getElementById("validationCustomUsername").value;
    let cidade = document.getElementById("validationCustom03").value;
    let estado = document.getElementById("validationCustom04").value;
    let senha = document.getElementById("validationCustom06").value;
    let cep = document.getElementById("validationCustom05").value;

    // Verificar se todos os campos estão preenchidos
    if (!nome || !sobrenome || !email || !cidade || !estado || !senha || !cep) {
        const modalErro = new bootstrap.Modal(document.getElementById('modalErro'), {})
            modalErro.show();
        return;  // Não prosseguir se algum campo estiver vazio
    } else {
        let spinner = document.getElementById("spinner");
        spinner.style.display = "inline-block";  // Exibir o spinner

        // Desabilitar o botão de envio do formulário
        let submitButton = document.querySelector('button[type="submit"]');
        submitButton.disabled = true;

        postPessoa(nome, sobrenome, email, senha, cidade, estado, cep).then(pessoa => {
            const modalSucesso = new bootstrap.Modal(document.getElementById('modalSucesso'), {})
            modalSucesso.show();
            spinner.style.display = "none";  // Ocultar o spinner

            // Habilitar o botão de envio do formulário
            submitButton.disabled = false;

            // Limpar os campos do formulário
            document.getElementById("validationCustom01").value = "";
            document.getElementById("validationCustom02").value = "";
            document.getElementById("validationCustomUsername").value = "";
            document.getElementById("validationCustom03").value = "";
            document.getElementById("validationCustom04").value = "";
            document.getElementById("validationCustom06").value = "";
            document.getElementById("validationCustom05").value = "";
        })
    }
}

function Reload(){
    window.location.reload(true);
}

function login(email, senha) {
    getPessoas().then(pessoas => {
        for(let pessoa of pessoas) {
            if(pessoa.email === email && pessoa.senha === senha) {
                console.log("Acesso permitido"); // Acesso permitido
                return;
            }
        }
        console.log("Acesso negado"); // Acesso negado
    });
}
