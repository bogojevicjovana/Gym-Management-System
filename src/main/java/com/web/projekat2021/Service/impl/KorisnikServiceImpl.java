package com.web.projekat2021.Service.impl;


import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Repository.KorisnikRepository;
import com.web.projekat2021.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    private final KorisnikRepository korisnikRepository;

    @Autowired
    public KorisnikServiceImpl(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    @Override
    public Korisnik login(String korisnickoIme, String lozinka) throws Exception {

        Korisnik korisnik = this.korisnikRepository.findByKorisnickoImeAndLozinka(korisnickoIme, lozinka);

        Boolean v = korisnik.getAktivan();



        if(korisnik == null) {
            throw new Exception("Unijeli ste pogresne podatke, pokušajte ponovo");
        } else if (v == false){
            throw new Exception("Vas profil nije aktiviran!");
        } else {
            return korisnik;
        }
    }

    @Override
    public Korisnik create(Korisnik korisnik) throws Exception {
        if(korisnik.getId() != null) {
            throw new Exception("ID must be null!");
        }

        Korisnik korisnik1 = korisnikRepository.findOneByKorisnickoIme(korisnik.getKorisnickoIme());
        if(korisnik1 != null) {
            throw new Exception("Korisnicko ime vec postoji!");
        }

        return this.korisnikRepository.save(korisnik);
    }
}
