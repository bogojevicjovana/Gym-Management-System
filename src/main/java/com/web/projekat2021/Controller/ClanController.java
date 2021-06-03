package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.DTO.ClanDTO;
import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Service.ClanService;
import com.web.projekat2021.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    //registracija clana fitnes centra
    @PostMapping(
            value = "/registration",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClanDTO> registracija(@RequestBody ClanDTO clanDTO) throws Exception {

        Clan clan = new Clan(clanDTO.getKorisnickoIme(), clanDTO.getLozinka(), clanDTO.getIme(),
                clanDTO.getPrezime(), clanDTO.getUloga(), clanDTO.getKontaktTelefon(), clanDTO.getDatumRodjenja(),
                clanDTO.getEmail(), clanDTO.getAktivan());

        Clan noviClan = clanService.create(clan);

        ClanDTO newClanDTO = new ClanDTO(noviClan.getId(), noviClan.getKorisnickoIme(), noviClan.getLozinka(),
                noviClan.getIme(), noviClan.getPrezime(), noviClan.getUloga(), noviClan.getKontaktTelefon(), noviClan.getDatumRodjenja(),
                noviClan.getEmail(), noviClan.getAktivan());
        return new ResponseEntity<>(newClanDTO, HttpStatus.CREATED);
    }

}
