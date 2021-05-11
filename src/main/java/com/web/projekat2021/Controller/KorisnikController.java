package com.web.projekat2021.Controller;

import com.web.projekat2021.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KorisnikController {

    @GetMapping("/")
    public String welcome() {
        return "registration.html";
    }

}
