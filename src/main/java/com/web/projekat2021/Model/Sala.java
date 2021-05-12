package com.web.projekat2021.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String kapacitet;

    @Column
    private String oznaka;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fitnescentar_id")
    private FitnessCentar fitnesscentar;

    @ManyToMany(mappedBy = "listaSalaTreninga")
    private Set<Trening> listaTreninga = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKapacitet() {
        return kapacitet;
    }

    public void setKapacitet(String kapacitet) {
        this.kapacitet = kapacitet;
    }

    public String getOznaka() {
        return oznaka;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public FitnessCentar getFitnesscentar() {
        return fitnesscentar;
    }

    public void setFitnesscentar(FitnessCentar fitnesscentar) {
        this.fitnesscentar = fitnesscentar;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", kapacitet='" + kapacitet + '\'' +
                ", oznaka='" + oznaka + '\'' +
                '}';
    }
}
