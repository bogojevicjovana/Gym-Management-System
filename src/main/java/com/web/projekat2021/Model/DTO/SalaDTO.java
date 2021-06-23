package com.web.projekat2021.Model.DTO;

import com.web.projekat2021.Model.FitnessCentar;

public class SalaDTO {

    private Long id;
    private String kapacitet;
    private String oznaka;
    private FitnessCentar centar;

    public SalaDTO(){}

    public SalaDTO(Long id, String kapacitet, String oznaka, FitnessCentar centar) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.centar = centar;
    }

    public SalaDTO(Long id, String kapacitet, String oznaka) {
        this.id = id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public SalaDTO(String kapacitet, String oznaka, FitnessCentar centar) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.centar = centar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(String kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }
}
