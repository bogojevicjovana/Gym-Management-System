package com.web.projekat2021.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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

    //fitnes centar u kom se nalazi sala
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCentar fitnesscentar;

    // u jednoj sali se moze odrzati vise treninga u razlicitim terminima
    @ManyToMany
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "raspored_sala_termin",
            joinColumns = @JoinColumn(name = "sala_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "termin_id", referencedColumnName = "id"))
    private Set<Termin> terminiSala = new HashSet<>();

    public Sala(String kapacitet, String oznaka) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }

    public Sala(){}

    public Sala(String kapacitet, String oznaka, FitnessCentar fitnesscentar) {
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
        this.fitnesscentar = fitnesscentar;
    }

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
