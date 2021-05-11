package com.web.projekat2021.Model;

import javax.persistence.*;
import java.io.Serializable;

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







}
