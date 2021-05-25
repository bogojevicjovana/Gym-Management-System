package com.web.projekat2021.Model.DTO;

public class FitnessCentarDTO {

    private Long id;
    private String naziv;
    private String adresa;
    private String brTelefonaCentrale;
    private String email;

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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrTelefonaCentrale() {
        return brTelefonaCentrale;
    }

    public void setBrTelefonaCentrale(String brTelefonaCentrale) {
        this.brTelefonaCentrale = brTelefonaCentrale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FitnessCentarDTO(){}

    public FitnessCentarDTO(Long id, String naziv, String adresa, String brTelefonaCentrale, String email) {
        this.id = id;
        this.naziv = naziv;
        this.adresa = adresa;
        this.brTelefonaCentrale = brTelefonaCentrale;
        this.email = email;
    }
}
