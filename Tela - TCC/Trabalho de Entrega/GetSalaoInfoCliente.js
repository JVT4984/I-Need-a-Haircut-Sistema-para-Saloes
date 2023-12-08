function carregarSalao() {
    fetch('http://localhost:8080/salaoTeste/')
        .then(response => response.json())
        .then(data => {
            let row = document.querySelector('#salaoInfo');
            let gruposAdicionados = [];
            data.forEach(salao => {
                if(!gruposAdicionados.includes(salao.salao_nome)) {
                    gruposAdicionados.push(salao.salao_nome);
                    row.innerHTML += `
                    <h2>Sobre o Salão</h2>
                                <br>
                                <label for="nomeSalao" class="form-label">Nome do Salão</label>
                                <input type="text" class="form-control" id="nomeSalao" placeholder="${salao.salao_nome}" readonly>
                                <br>
                                <label for="cnpjSalao" class="form-label">CNPJ</label>
                                <input type="text" class="form-control" id="cnpjSalao" placeholder="${salao.salao_cnpj}" readonly>
                                <br>
                                <label for="telefoneSalao" class="form-label">Telefone</label>
                                <input type="text" class="form-control" id="telefoneSalao" placeholder="${salao.salao_telefone}" readonly>
                                <br>
                                <label for="emailSalao" class="form-label">Email</label>
                                <input type="email" class="form-control" id="emailSalao" placeholder="${salao.salao_email}" readonly>
                                <br>
                                <h2>Endereço do Salão</h2>
                                <label for="estadoSalao" class="form-label">Estado</label>
                                <input type="text" class="form-control" id="estadoSalao" placeholder="${salao.estado}" readonly>
                                <br>
                                <label for="cidadeSalao" class="form-label">Cidade</label>
                                <input type="text" class="form-control" id="cidadeSalao" placeholder="${salao.cidade}" readonly>
                                <br>
                                <label for="bairroSalao" class="form-label">Bairro</label>
                                <input type="text" class="form-control" id="bairroSalao" placeholder="Bairro ${salao.bairro}" readonly>
                                <br>
                                <label for="ruaSalao" class="form-label">Rua</label>
                                <input type="text" class="form-control" id="ruaSalao" placeholder="Rua ${salao.rua}" readonly>
                                <br>
                                <label for="numeroSalao" class="form-label">Numero da Residencia</label>
                                <input type="text" class="form-control" id="numeroSalao" placeholder="${salao.numero}" readonly>
                                <br>
                                <button type="button" class="btn btn-danger" onclick="voltarTelaInicial()">Voltar</button>`;
                }
            });
        }) 
        .catch(error => console.error('Erro:', error));
  }
  carregarSalao();