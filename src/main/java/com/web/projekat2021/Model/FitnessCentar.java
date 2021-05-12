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


}
