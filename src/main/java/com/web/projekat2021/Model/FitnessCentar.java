package com.web.projekat2021.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FitnessCentar implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String adresa;

    @Column
    private String brTelefonaCentrale;

    @Column
    private String email;

    // u jednom fitnescentru radi vise trenera
    @OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Trener> treneri = new HashSet<>();

    //u jednom fitnes centru nalazi se vise sala
    @OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Sala> sale = new HashSet<>();

    // u fitnes centru odrzavaju se treninzi u vise termina
    @OneToMany(mappedBy = "fitnessCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Termin> termini = new HashSet<>();

    public Set<Trener> getTreneri() {
        return treneri;
    }

    public Set<Sala> getSale() {
        return sale;
    }

    public Set<Termin> getTermini() {
        return termini;
    }

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

    public FitnessCentar(){}

    @Override
    public String toString() {
        return "FitnessCentar{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", adresa='" + adresa + '\'' +
                ", brTelefonaCentrale='" + brTelefonaCentrale + '\'' +
                ", email='" + email + '\'' +
                ", treneri=" + treneri +
                ", sale=" + sale +
                ", termini=" + termini +
                '}';
    }

    public FitnessCentar(String naziv, String adresa, String brTelefonaCentrale, String email) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brTelefonaCentrale = brTelefonaCentrale;
        this.email = email;
    }
}
