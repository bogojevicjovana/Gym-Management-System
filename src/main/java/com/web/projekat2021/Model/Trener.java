package com.web.projekat2021.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("trener")
public class Trener extends Korisnik {

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnessCentar fitnesscentar;

    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Trening> treninziTrenera = new HashSet<>();

}
