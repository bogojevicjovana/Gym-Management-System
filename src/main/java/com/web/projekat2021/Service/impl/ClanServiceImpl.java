package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Repository.ClanRepository;
import com.web.projekat2021.Repository.KorisnikRepository;
import com.web.projekat2021.Service.ClanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanServiceImpl implements ClanService {


    private final ClanRepository clanRepository;

    @Autowired
    public ClanServiceImpl(ClanRepository clanRepository) {
        this.clanRepository = clanRepository;
    }

    @Override
    public Clan create(Clan clan) throws Exception{

        if(clan.getId() != null) {
            throw new Exception("ID must be null!");
        }

        Clan clanR = clanRepository.findOneByKorisnickoIme(clan.getKorisnickoIme());
        if(clanR != null) {
            throw new Exception("Korisnicko ime vec postoji!");
        }

        clan.setAktivan(true);
        Clan noviClan = this.clanRepository.save(clan);
        return noviClan;
    }

    @Override
    public Clan findOne(Long idClana) {return this.clanRepository.getOne(idClana);}

}
