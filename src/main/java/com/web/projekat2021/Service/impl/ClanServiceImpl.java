package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Repository.ClanRepository;
import com.web.projekat2021.Service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanServiceImpl implements ClanService {

    @Autowired
    private ClanRepository clanRepository;

    @Override
    public Clan createClan(Clan clan) throws Exception {

        clan.setAktivan(true);
        clan.setUloga("clan");
        Clan noviClan = this.clanRepository.save(clan);

        return noviClan;
    }
}
