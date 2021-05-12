package com.web.projekat2021.Repository;

import com.web.projekat2021.Model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByKorisnickoImeAndLozinka(String korisnickoIme, String lozinka);

    Korisnik findOneByKorisnickoIme(String korisnickoIme);

}
