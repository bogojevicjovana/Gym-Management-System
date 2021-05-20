package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @GetMapping(value = "/")
    public String welcome() {
        return "home.html";
    }

    @GetMapping(value = "/registracija-korisnika")
    public String odabirNaloga() {
        return "odaberiNalog.html";
    }


    @GetMapping("/korisnici")
    public String getEmployees(Model model) {
        List<Korisnik> listaKorisnika = this.korisnikService.pronadjiSve();
        model.addAttribute("korisnici", listaKorisnika);
        return "korisnici.html";
    }



}
