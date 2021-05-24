package com.web.projekat2021.Service;

import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Model.Trening;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TreningService {

    List<Trening> listaTreninga();

}
