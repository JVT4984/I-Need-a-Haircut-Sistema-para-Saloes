$(function () {
    $('#datepicker').datepicker({
        format: 'yyyy-mm-dd'
    });
});

function salvarAgendamento(event) {

    event.preventDefault();

    let servico = document.getElementById("servico-agenda").value;
    let data = document.getElementById("date").value;
    let hora = document.getElementById("hora-agenda").value;

    if (!servico || !data || !hora) {
        const modalErro = new bootstrap.Modal(document.getElementById('modalErroAgenda'), {})
        modalErro.show();
        return;
    } else {
        let spinner = document.getElementById("spinner");
        spinner.style.display = "inline-block";

        let submitButton = document.querySelector('button[type="submit"]');

        postAgendamento(servico, data, hora).then(agendamento => {
            const modalSucesso = new bootstrap.Modal(document.getElementById('modalSucessoAgenda'), {})
            modalSucesso.show();
            spinner.style.display = "none";
        })
    }

}
