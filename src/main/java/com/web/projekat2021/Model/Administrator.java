package com.web.projekat2021.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
public class Administrator extends Korisnik {

    public Administrator(String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String kontaktTelefon, String datumRodjenja, String email, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, uloga, kontaktTelefon, datumRodjenja, email, aktivan);
    }

    public Administrator(){}
}
