package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.DTO.KorisnikDTO;
import com.web.projekat2021.Model.DTO.LoginKorisnikDTO;
import com.web.projekat2021.Model.Korisnik;
import com.web.projekat2021.Service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/api/korisnici")
public class KorisnikController {

    private final KorisnikService korisnikService;

    @Autowired
    public KorisnikController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }


    //login korisnika
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> login(@RequestBody LoginKorisnikDTO korisnikDTO) throws Exception{

        Korisnik korisnik = korisnikService.login(korisnikDTO.getKorisnickoIme(), korisnikDTO.getLozinka());
        KorisnikDTO ulogovanKorisnik = new KorisnikDTO();

        if (korisnik != null) {

            ulogovanKorisnik = new KorisnikDTO(korisnik.getId(),
                    korisnik.getKorisnickoIme(), korisnik.getLozinka(),
                    korisnik.getIme(), korisnik.getPrezime(), korisnik.getUloga(),
                    korisnik.getKontaktTelefon(), korisnik.getDatumRodjenja(),
                    korisnik.getEmail(), korisnik.getAktivan());
            return new ResponseEntity<>(ulogovanKorisnik, HttpStatus.OK);

        }
        return new ResponseEntity<>(ulogovanKorisnik, HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KorisnikDTO> getKorisnik(@PathVariable(name = "id") Long id) {
        Korisnik korisnik = this.korisnikService.findOne(id);

        KorisnikDTO korisnikDTO = new KorisnikDTO();
        korisnikDTO.setId(korisnik.getId());
        korisnikDTO.setKorisnickoIme(korisnik.getKorisnickoIme());
        korisnikDTO.setLozinka(korisnik.getLozinka());
        korisnikDTO.setIme(korisnik.getIme());
        korisnikDTO.setPrezime(korisnik.getPrezime());
        korisnikDTO.setKontaktTelefon(korisnik.getKontaktTelefon());
        korisnikDTO.setEmail(korisnik.getEmail());
        korisnikDTO.setDatumRodjenja(korisnik.getDatumRodjenja());


        return new ResponseEntity<>(korisnikDTO, HttpStatus.OK);
    }

}
