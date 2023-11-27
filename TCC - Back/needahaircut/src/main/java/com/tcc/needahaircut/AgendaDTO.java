package com.tcc.needahaircut;

import java.sql.Date;
import java.sql.Time;

public class AgendaDTO {

    public int agenda_id;
    public Date data;
    public Time horario;

    public int getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(int agenda_id) {
        this.agenda_id = agenda_id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public AgendaDTO(int agenda_id, Date data, Time horario) {
        this.agenda_id = agenda_id;
        this.data = data;
        this.horario = horario;
    }

    public AgendaDTO() {

    }

}
