package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Model.Trening;
import com.web.projekat2021.Repository.KorisnikRepository;
import com.web.projekat2021.Repository.TreningRepository;
import com.web.projekat2021.Service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningServiceImpl implements TreningService {

    private final TreningRepository treningRepository;

    @Autowired
    public TreningServiceImpl(TreningRepository treningRepository) {
        this.treningRepository = treningRepository;
    }

    @Override
    public List<Trening> listaTreninga() {

            List<Trening> treninzi = this.treningRepository.findAll();
            return treninzi;
    }

    @Override
    public List<Trening> sortByNaziv(){
        return treningRepository.findByOrderByNaziv();
    }

    @Override
    public List<Trening> sortByOpis(){
        return treningRepository.findByOrderByOpis();
    }

    @Override
    public List<Trening> sortByTipTreninga(){
        return treningRepository.findByOrderByTipTreninga();
    }

    @Override
    public List<Trening> findByNazivTr(String naziv) {
        return treningRepository.findByNazivIgnoreCaseContaining(naziv);
    }

    @Override
    public List<Trening> findByTipTr(String tipTreninga) {
        return treningRepository.findByTipTreningaIgnoreCaseContaining(tipTreninga);
    }

    @Override
    public List<Trening> findByOpisTr(String opis){
        return treningRepository.findByOpisIgnoreCaseContaining(opis);
    }
}
