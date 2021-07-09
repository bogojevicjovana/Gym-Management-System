package com.web.projekat2021.Model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("trener")
public class Trener extends Korisnik {

    private Float prosecnaOcena;

    public FitnessCentar getFitnesscentar() {
        return fitnesscentar;
    }

    public void setFitnesscentar(FitnessCentar fitnesscentar) {
        this.fitnesscentar = fitnesscentar;
    }

    // fitnes centar u kom radi trener
    @ManyToOne(fetch =  FetchType.LAZY)
    private FitnessCentar fitnesscentar;

    //trener drzi vise treninga
    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY)
    private Set<Trening> treninziTrenera = new HashSet<>();

    public Set<Trening> getTreninziTrenera() {
        return treninziTrenera;
    }

    public void setTreninziTrenera(Set<Trening> treninziTrenera) {
        this.treninziTrenera = treninziTrenera;
    }

    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String kontaktTelefon, String datumRodjenja, String email, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, uloga, kontaktTelefon, datumRodjenja, email, aktivan);
    }

    public Trener(){}
}
