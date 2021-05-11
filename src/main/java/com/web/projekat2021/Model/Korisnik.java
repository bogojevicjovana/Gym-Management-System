package com.web.projekat2021.Model;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tip")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String korisnickoIme;

    @Column
    private String lozinka;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String uloga;

    @Column
    private String kontaktTelefon;

    @Column
    private String datumRodjenja;

    @Column
    private String email;

    @Column
    private Boolean aktivan; //true ako je aktivan, false ako nije




}
