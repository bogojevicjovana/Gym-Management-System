package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Service.ClanService;
import com.web.projekat2021.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clanovi")
public class ClanController {

    private final ClanService clanService;

    @Autowired
    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }

    /*@GetMapping("/dodaj-clana")
    public String dodajClana(Model model){
        Clan clan = new Clan();
        model.addAttribute("clan", clan);
        return "dodaj-clana.html";
    }

    @PostMapping("/save-clan")
    public String saveClana(@ModelAttribute Clan clan, BindingResult errors, Model model) throws Exception {
        this.clanService.createClan(clan);

        return "redirect:/";
    }*/

}
