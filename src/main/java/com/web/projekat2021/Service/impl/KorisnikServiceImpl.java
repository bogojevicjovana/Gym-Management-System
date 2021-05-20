package com.web.projekat2021.Service.impl;


import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Repository.KorisnikRepository;
import com.web.projekat2021.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    @Override
    public List<Korisnik> pronadjiSve(){
        List<Korisnik> korisnici = this.korisnikRepository.findAll();
        return korisnici;
    }


}
