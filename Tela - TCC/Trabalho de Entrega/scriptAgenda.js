$(function(){
    $('#datepicker').datepicker({
        format: 'dd/mm/yyyy'
    });
  });


function postAgendamento(){

    let cliente = document.getElementById("cliente-agenda").value;
    let servico = document.getElementById("servico-agenda").value;
    let data = document.getElementById("date").value;
    let hora = document.getElementById("hora-agenda").value;

    if (!cliente || !servico || !data || !hora) {
        const modalErro = new bootstrap.Modal(document.getElementById('modalErro'), {})
            modalErro.show();
            return
    } else {
        getAgendaID(data, hora).then(id => {

            postAgendamento(cliente, servico, id)
        })
    }
}