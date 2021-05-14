package com.web.projekat2021.Model;

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

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

}
