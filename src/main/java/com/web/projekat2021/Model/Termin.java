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

    @ManyToMany(mappedBy = "terminiSala")
    private Set<Sala> saleTermin = new HashSet<>();

    @ManyToOne
    private FitnessCentar fitnessCentar;

}
