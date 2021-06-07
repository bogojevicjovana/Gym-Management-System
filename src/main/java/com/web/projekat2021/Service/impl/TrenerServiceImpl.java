package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.Trener;
import com.web.projekat2021.Repository.ClanRepository;
import com.web.projekat2021.Repository.TrenerRepository;
import com.web.projekat2021.Service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerServiceImpl implements TrenerService {

    private final TrenerRepository trenerRepository;

    @Autowired
    public TrenerServiceImpl(TrenerRepository trenerRepository) {
        this.trenerRepository = trenerRepository;
    }

    @Override
    public Trener create(Trener trener) throws Exception{

        if(trener.getId() != null) {
            throw new Exception("ID must be null!");
        }

        Trener trenerNovi = trenerRepository.findOneByKorisnickoIme(trener.getKorisnickoIme());
        if(trenerNovi != null) {
            throw new Exception("Korisnicko ime vec postoji!");
        }

        trener.setAktivan(false);
        Trener novi = this.trenerRepository.save(trener);
        return novi;
    }

    public List<Trener> listaTrenera() {
        List<Trener> listaTrenera = this.trenerRepository.findByAktivanIsFalse();
        return listaTrenera;
    }

    @Override
    public Trener findOne(Long id){
        Trener novi = trenerRepository.getOne(id);
        return novi;
    }

    @Override
    public Trener update(Trener trener) throws Exception{
        Trener trenerUpdate = this.trenerRepository.getOne(trener.getId());

        if(trenerUpdate == null) {
            throw new Exception("Trener ne postoji!");
        }

        trenerUpdate.setAktivan(true);
        Trener nt = this.trenerRepository.saveAndFlush(trenerUpdate);
        return nt;
    }

}
