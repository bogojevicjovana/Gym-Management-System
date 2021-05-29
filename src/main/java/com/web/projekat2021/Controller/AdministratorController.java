package com.web.projekat2021.Controller;


import com.web.projekat2021.Model.DTO.TreningDTO;
import com.web.projekat2021.Model.Trening;
import com.web.projekat2021.Service.AdministratorService;
import com.web.projekat2021.Service.ClanService;
import com.web.projekat2021.Service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/admini")
public class AdministratorController {

    private final AdministratorService administratorService;

    @Autowired
    public AdministratorController(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }



}
