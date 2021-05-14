package com.web.projekat2021.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Termin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String datum;

    @Column
    private String vreme;

    @Column
    private String cena;

    @Column
    private Integer brojPrijavljenihCl;

    @ManyToOne
    private Trening trening;

    // trening u odredjenom terminu se moze odrzati u vise sala
    @ManyToMany(mappedBy = "terminiSala")
    private Set<Sala> saleTermin = new HashSet<>();

    // fitnes centar u kom se odvija termin
    @ManyToOne
    private FitnessCentar fitnessCentar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public Integer getBrojPrijavljenihCl() {
        return brojPrijavljenihCl;
    }

    public void setBrojPrijavljenihCl(Integer brojPrijavljenihCl) {
        this.brojPrijavljenihCl = brojPrijavljenihCl;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public Set<Sala> getSaleTermin() {
        return saleTermin;
    }

    public void setSaleTermin(Set<Sala> saleTermin) {
        this.saleTermin = saleTermin;
    }

    public FitnessCentar getFitnessCentar() {
        return fitnessCentar;
    }

    public void setFitnessCentar(FitnessCentar fitnessCentar) {
        this.fitnessCentar = fitnessCentar;
    }
}
