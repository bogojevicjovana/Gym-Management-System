package com.web.projekat2021.Model;

import javax.persistence.*;
import java.io.Serializable;

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




}
