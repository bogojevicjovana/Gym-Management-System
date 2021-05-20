package com.web.projekat2021.Repository;

import com.web.projekat2021.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByKorisnickoImeAndLozinka(String korisnicko, String lozinka);



}
