function login() {
    let email = document.getElementById("email").value;
    let senha = document.getElementById("senha").value;
    loginAPI(email, senha).then(token => {
        if (token === "") { //Usuario ou senha Invalida
            alert("Usuario ou senha invalido");
        } else { //OK
            //Salvar o token
            window.localStorage.setItem("token", token);
            //Redirecionar para a tela de pessoas
        }
    })
}