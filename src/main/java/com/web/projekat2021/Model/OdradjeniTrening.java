package com.web.projekat2021.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OdradjeniTrening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Float ocena;

    @ManyToOne
    private Clan clan;

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    @ManyToOne
    private Trening trening;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getOcena() {
        return ocena;
    }

    public void setOcena(Float ocena) {
        this.ocena = ocena;
    }

    public OdradjeniTrening(Long id, Float ocena, Clan clan, Trening trening) {
        this.id = id;
        this.ocena = ocena;
        this.clan = clan;
        this.trening = trening;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public OdradjeniTrening(){}

}
