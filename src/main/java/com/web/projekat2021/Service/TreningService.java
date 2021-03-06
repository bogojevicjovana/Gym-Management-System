package com.web.projekat2021.Service;

import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Model.OdradjeniTrening;
import com.web.projekat2021.Model.Trening;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface TreningService {

    List<Trening> listaTreninga();

    List<Trening> sortByNaziv();

    List<Trening> sortByOpis();

    List<Trening> sortByTipTreninga();

    List<Trening> findByNazivTr(String naziv);

    List<Trening> findByTipTr(String naziv);

    List<Trening> findByOpisTr(String opis);

    Trening otkazi(Trening trening);

    Trening findOne(Long idTreninga);

    List<Trening> findAllByOpisOrNazivOrTipTreninga(String naziv, String opis, String tipTreninga);
}
