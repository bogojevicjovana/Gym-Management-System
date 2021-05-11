package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Repository.KorisnikRepository;
import com.web.projekat2021.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikServiceImpl implements KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;
}
