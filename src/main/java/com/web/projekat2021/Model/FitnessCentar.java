package com.web.projekat2021.Model;

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
    private Set<Trener> treneri = new HashSet<>();

    //u jednom fitnes centru nalazi se vise sala, jedna sala nalazi se samo u jednom fitnes centru
    @OneToMany(mappedBy = "fitnesscentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Sala> sale = new HashSet<>();


    @ManyToMany
    @JoinTable(name = "raspored_treninga",
            joinColumns = @JoinColumn(name = "fitnesscentar_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> treninzi = new HashSet<>();

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
                ", treninzi=" + treninzi +
                '}';
    }
}
