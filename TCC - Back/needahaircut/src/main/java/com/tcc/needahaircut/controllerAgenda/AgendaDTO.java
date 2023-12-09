package com.tcc.needahaircut.controllerAgenda;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class AgendaDTO {

    public int agenda_id;
    public LocalDate data;
    public LocalTime horario;

    public AgendaDTO() {

    }


    public int getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(int agenda_id) {
        this.agenda_id = agenda_id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
}
