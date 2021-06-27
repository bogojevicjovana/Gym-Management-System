package com.web.projekat2021.Controller;

import com.web.projekat2021.Service.SalaService;
import com.web.projekat2021.Service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/termini")
public class TerminController {

    private final TerminService terminService;

    @Autowired
    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }


}
