async function postPessoa(nome, sobrenome, email, senha, cidade, estado, cep) {
let response = await fetch("https://650eeb4554d18aabfe999fd2.mockapi.io/pessoas", {
    method: "POST",
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    },
    body: JSON.stringify ({
        nome: nome,
        sobrenome: sobrenome,
        email: email,
        senha: senha,
        cidade: cidade,
        estado: estado,
        cep: cep
    })
});
let pessoa = await response.json();

//console.log(pessoas);

return pessoa;
}
    
async function getPessoas() {
    let response = await fetch("https://64f62ed72b07270f705e41cb.mockapi.io/pessoas-api/pessoa")
    let pessoas = await response.json();

    //console.log(pessoas);

    return pessoas;

}