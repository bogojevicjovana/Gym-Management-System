package com.web.projekat2021.Repository;

import com.web.projekat2021.Model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrenerRepository extends JpaRepository<Trener, Long> {

    Trener findOneByKorisnickoIme(String korisnickoIme);

    List<Trener> findByAktivanIsFalse();
}
