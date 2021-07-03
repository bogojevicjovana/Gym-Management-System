package com.web.projekat2021.Model.DTO;

public class OdradjeniTreningDTO {

    private Long id;
    private Float ocena;
    private Long idClana;
    private Long idTreninga;

    public OdradjeniTreningDTO(Long id, Float ocena, Long idClana, Long idTreninga) {
        this.id = id;
        this.ocena = ocena;
        this.idClana = idClana;
        this.idTreninga = idTreninga;
    }

    public OdradjeniTreningDTO(){}

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

    public Long getIdTreninga() {
        return idTreninga;
    }

    public void setIdTreninga(Long idTreninga) {
        this.idTreninga = idTreninga;
    }
}
