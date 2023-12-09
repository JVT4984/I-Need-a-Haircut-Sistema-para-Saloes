package com.tcc.needahaircut.modalAgenda;

import com.tcc.needahaircut.modelSalao.SalaoEntity;

import java.time.LocalDate;
import java.time.LocalTime;

public class AgendaEntity {

    public int agenda_id;
    public LocalDate data;
    public LocalTime hrInicio;
    public LocalTime hrFinal;
    public int atendentes;
    public SalaoEntity salao_id;

    public AgendaEntity() {

    }

    public AgendaEntity(int id) {
        this.agenda_id = id;
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

    public LocalTime getHrInicio() {
        return hrInicio;
    }

    public void setHrInicio(LocalTime hrInicio) {
        this.hrInicio = hrInicio;
    }

    public LocalTime getHrFinal() {
        return hrFinal;
    }

    public void setHrFinal(LocalTime hrFinal) {
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

}
