package com.web.projekat2021.Model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("clan")
public class Clan extends Korisnik{

    //jedan clan moze da odradi vise treninga
    @ManyToMany
    @JoinTable(name = "odradjeni_treninzi",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> odradjeniTreninzi = new HashSet<>();


    //vise clanova se moze prijaviti za jedan trening
    @ManyToMany
    @JoinTable(name = "prijavljeni_treninzi",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> prijavljeniTreninzi = new HashSet<>();




}
