package com.web.projekat2021.Model;


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
    private String tipTreninga;

    @Column
    private String trajanje;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trener trener;

    @ManyToMany(mappedBy = "treninzi")
    private Set<FitnessCentar> fitnesCentri = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Clan> clanovi = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "prijavljeni_treninzi",
            joinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"))
    private Set<Clan> prijavljeniClanovi = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "trening_odrzavanje_sala",
            joinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"))
    private Set<Sala> listaSalaTreninga = new HashSet<>();

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
