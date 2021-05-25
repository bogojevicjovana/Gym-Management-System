package com.web.projekat2021.Repository;

import com.web.projekat2021.Model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanRepository extends JpaRepository<Clan, Long> {

    Clan findOneByKorisnickoIme(String korisnickoIme);
}
