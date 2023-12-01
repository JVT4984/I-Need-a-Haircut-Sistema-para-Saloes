async function loginAPI(email, senha) {
    let response = await fetch("http://localhost:8080/login/", {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify ({
            email: email,
            senha: senha
        })
    });
    let token = await response.text();

    return token;
}

async function nivelAcesso() {
    console.log('Authorization', localStorage.getItem("token"))
    let response = await fetch("http://localhost:8080/login/", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
            }
    });
    
    let acesso = await response.json();
    console.log(acesso)

    //console.log(pessoas);

    return acesso;

}
