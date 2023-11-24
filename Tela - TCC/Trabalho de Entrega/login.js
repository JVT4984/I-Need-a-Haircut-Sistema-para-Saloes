function login() {
let email = document.getElementById("email").value;
let senha = document.getElementById("senha").value;
    loginAPI(email, senha).then(token => {
        if (token === "") { //Usuario ou senha Invalida
            const modalErroLogin = new bootstrap.Modal(document.getElementById('modalErroLogin'), {})
            modalErroLogin.show();
        return;  // Não prosseguir se algum campo estiver vazio
        } else { //OK
            //Salvar o token
            window.localStorage.setItem("token", token);
            //Limpa os Campos
            document.getElementById("email").value = "";
            document.getElementById("senha").value = "";
            //Redirecionar para a tela de pessoas
            document.location.href = 'Tela Inicial.html'
        }
    })
}

function irCadastro() {
    document.location.href = 'Tela de Cadastro.html'
}