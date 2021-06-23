package com.web.projekat2021.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("trener")
public class Trener extends Korisnik {

    private Float prosecnaOcena;

    // fitnes centar u kom radi trener
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private FitnessCentar fitnesscentar;

    //trener drzi vise treninga
    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trening> treninziTrenera = new HashSet<>();


    public Trener(String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String kontaktTelefon, String datumRodjenja, String email, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, uloga, kontaktTelefon, datumRodjenja, email, aktivan);
    }

    public Trener(){}
}
