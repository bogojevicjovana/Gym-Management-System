package com.web.projekat2021.Model.DTO;

public class OdradjeniTreningDTO {

    private Long id;
    private Long idTreninga;
    private Float ocena;
    private Long idClana;

    public OdradjeniTreningDTO(){}

    public OdradjeniTreningDTO(Long id, Long idTreninga, Float ocena, Long idClana) {
        this.id = id;
        this.idTreninga = idTreninga;
        this.ocena = ocena;
        this.idClana = idClana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTreninga() {
        return idTreninga;
    }

    public void setIdTreninga(Long idTreninga) {
        this.idTreninga = idTreninga;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        this.ocena = ocena;
    }

    public Long getIdClana() {
        return idClana;
    }

    public void setIdClana(Long idClana) {
        this.idClana = idClana;
    }
}
