package com.tcc.needahaircut;

import java.sql.Date;
import java.sql.Time;

public class AgendaEntity {

    public int agenda_id;
    public Date data;
    public Time hrInicio;
    public Time hrFinal;
    public int atendentes;
    public SalaoEntity salao_id;

    public AgendaEntity() {

    }

    public AgendaEntity(int id) {
    }


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

    public Time getHrInicio() {
        return hrInicio;
    }

    public void setHrInicio(Time hrInicio) {
        this.hrInicio = hrInicio;
    }

    public Time getHrFinal() {
        return hrFinal;
    }

    public void setHrFinal(Time hrFinal) {
        this.hrFinal = hrFinal;
    }

    public int getAtendentes() {
        return atendentes;
    }

    public void setAtendentes(int atendentes) {
        this.atendentes = atendentes;
    }

    public SalaoEntity getSalao_id() {
        return salao_id;
    }

    public void setSalao_id(SalaoEntity salao_id) {
        this.salao_id = salao_id;
    }

    public AgendaEntity(int agenda_id, Date data, Time hrInicio, Time hrFinal, int atendentes, SalaoEntity salao_id) {
        this.agenda_id = agenda_id;
        this.data = data;
        this.hrInicio = hrInicio;
        this.hrFinal = hrFinal;
        this.atendentes = atendentes;
        this.salao_id = salao_id;
    }
}
