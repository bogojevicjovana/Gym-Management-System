package com.web.projekat2021.Model;


import javax.persistence.*;
import java.io.Serializable;

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




}
