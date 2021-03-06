package com.web.projekat2021.Service;


import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface KorisnikService {


    Korisnik login(String korisnicko, String lozinka) throws Exception;

    Korisnik findOne(Long id);
}
