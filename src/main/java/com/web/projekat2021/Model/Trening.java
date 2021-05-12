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



}
