package com.web.projekat2021.Model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Trening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String naziv;

    @Column
    private String opis;

    @Column
    private Boolean otkazan;

    public Boolean getOtkazan() {
        return otkazan;
    }

    public void setOtkazan(Boolean otkazan) {
        this.otkazan = otkazan;
    }

    @Column
    private String tipTreninga;

    @Column
    private String trajanje;

    // trener koji odrzava trening
    @ManyToOne(fetch =  FetchType.LAZY)
    private Trener trener;

    // za jedan trening se moze prijaviti vise clanova
    @ManyToMany(mappedBy = "prijavljeniTreninzi")
    private Set<Clan> prijavljeniClanovi = new HashSet<>();

    @OneToMany(mappedBy = "trening")
    private Set<Termin> treningTermini = new HashSet<>();

    public Set<Termin> getTreningTermini() {
        return treningTermini;
    }

    public void setTreningTermini(Set<Termin> treningTermini) {
        this.treningTermini = treningTermini;
    }

    public Trening(Long id, String naziv, String opis, String tipTreninga, String trajanje, Boolean otkazan) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.otkazan = otkazan;
    }

    public Trening(){}

    @OneToMany(mappedBy = "trening")
    private Set<OdradjeniTrening> odradjeniTreninzi = new HashSet<>();

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
}
