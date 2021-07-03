package com.web.projekat2021.Model.DTO;

public class TreningDTO {

    private Long id;
    private String naziv;
    private String opis;
    private String tipTreninga;
    private String trajanje;
    private Boolean otkazan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getTipTreninga() {
        return tipTreninga;
    }

    public void setTipTreninga(String tipTreninga) {
        this.tipTreninga = tipTreninga;
    }

    public String getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(String trajanje) {
        this.trajanje = trajanje;
    }

    public TreningDTO(){}

    public TreningDTO(Long id, String naziv, String opis, String tipTreninga, String trajanje) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
    }

    public Boolean getOtkazan() {
        return otkazan;
    }

    public void setOtkazan(Boolean otkazan) {
        this.otkazan = otkazan;
    }

    public TreningDTO(Long id, String naziv, String opis, String tipTreninga, String trajanje, Boolean otkazan) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.otkazan = otkazan;
    }

    public TreningDTO(String naziv, String opis, String tipTreninga, String trajanje) {
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
    }


}
