async function getSalao() {
    let response = await fetch("http://localhost:8080/pessoa/", {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem("token")
            }
    });
        
    let pessoas = await response.json();

    //console.log(pessoas);

    return pessoas;

}