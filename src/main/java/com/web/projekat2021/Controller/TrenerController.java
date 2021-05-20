package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.Trener;
import com.web.projekat2021.Service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrenerController {

    @Autowired
    private TrenerService trenerService;

    @GetMapping("/dodaj-trenera")
    public String dodajTrenera(Model model){
        Trener trener = new Trener();
        model.addAttribute("trener", trener);
        return "dodaj-trenera.html";
    }

    @PostMapping("/save-trener")
    public String saveTrener(@ModelAttribute Trener trener, BindingResult errors, Model model) throws Exception {
        this.trenerService.createTrener(trener);

        return "redirect:/";
    }

}
