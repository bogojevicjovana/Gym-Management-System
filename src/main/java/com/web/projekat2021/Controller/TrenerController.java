package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.DTO.ClanDTO;
import com.web.projekat2021.Model.DTO.TrenerDTO;
import com.web.projekat2021.Model.DTO.TreningDTO;
import com.web.projekat2021.Model.Trener;
import com.web.projekat2021.Model.Trening;
import com.web.projekat2021.Service.KorisnikService;
import com.web.projekat2021.Service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value="/api/treneri")
public class TrenerController {

    private final TrenerService trenerService;

    @Autowired
    public TrenerController(TrenerService trenerService) {
        this.trenerService = trenerService;
    }

    //registracija trenera fitnes centra
    @PostMapping(
            value = "/dodaj-trenera",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> registracija(@RequestBody TrenerDTO trenerDTO) throws Exception {

        Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(),
                trenerDTO.getPrezime(), trenerDTO.getUloga(), trenerDTO.getKontaktTelefon(), trenerDTO.getDatumRodjenja(),
                trenerDTO.getEmail(), trenerDTO.getAktivan());


        Trener noviTrener = trenerService.create(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(noviTrener.getId(), noviTrener.getKorisnickoIme(), noviTrener.getLozinka(),
                noviTrener.getIme(), noviTrener.getPrezime(), noviTrener.getUloga(), noviTrener.getKontaktTelefon(), noviTrener.getDatumRodjenja(),
                noviTrener.getEmail(), noviTrener.getAktivan());
        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
    }

    //odobravanje registracije
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> odobriTrenera(@PathVariable Long id, @RequestBody TrenerDTO trenerDTO) throws Exception{

        Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(),
                trenerDTO.getPrezime(), trenerDTO.getUloga(), trenerDTO.getKontaktTelefon(), trenerDTO.getDatumRodjenja(),
                trenerDTO.getEmail(), trenerDTO.getAktivan());
        trener.setId(id);

        Trener noviTrener = trenerService.update(trener);

        TrenerDTO odobrenTrenerDTO = new TrenerDTO(noviTrener.getId(), noviTrener.getKorisnickoIme(), noviTrener.getLozinka(),
                noviTrener.getIme(), noviTrener.getPrezime(), noviTrener.getUloga(), noviTrener.getKontaktTelefon(), noviTrener.getDatumRodjenja(),
                noviTrener.getEmail(), noviTrener.getAktivan());

        return new ResponseEntity<>(odobrenTrenerDTO, HttpStatus.OK);
    }

    //lista trenera
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/dobavi-trenere")
    public ResponseEntity<List<TrenerDTO>> dobaviTrenere(){

        List<Trener> listaTrenera = this.trenerService.listaTrenera();
        List<TrenerDTO> trenerDTOs = new ArrayList<>();

        for(Trener noviTrener: listaTrenera){
            TrenerDTO odobrenTrenerDTO = new TrenerDTO(noviTrener.getId(), noviTrener.getKorisnickoIme(), noviTrener.getLozinka(),
                    noviTrener.getIme(), noviTrener.getPrezime(), noviTrener.getUloga(), noviTrener.getKontaktTelefon(), noviTrener.getDatumRodjenja(),
                    noviTrener.getEmail(), noviTrener.getAktivan());
            trenerDTOs.add(odobrenTrenerDTO);
        }

        return new ResponseEntity<>(trenerDTOs, HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/dobavi-sve-trenere")
    public ResponseEntity<List<TrenerDTO>> dobaviSveTrenere(){

        List<Trener> listaTrenera = this.trenerService.listaSvihTrenera();
        List<TrenerDTO> trenerDTOs = new ArrayList<>();

        for(Trener noviTrener: listaTrenera){
            TrenerDTO odobrenTrenerDTO = new TrenerDTO(noviTrener.getId(), noviTrener.getKorisnickoIme(), noviTrener.getLozinka(),
                    noviTrener.getIme(), noviTrener.getPrezime(), noviTrener.getUloga(), noviTrener.getKontaktTelefon(), noviTrener.getDatumRodjenja(),
                    noviTrener.getEmail(), noviTrener.getAktivan());
            trenerDTOs.add(odobrenTrenerDTO);
        }

        return new ResponseEntity<>(trenerDTOs, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTrenera(@PathVariable Long id) {
        this.trenerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(
            value = "/dodaj-trenera-admin",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrenerDTO> registracijaTrenera(@RequestBody TrenerDTO trenerDTO) throws Exception {

        Trener trener = new Trener(trenerDTO.getKorisnickoIme(), trenerDTO.getLozinka(), trenerDTO.getIme(),
                trenerDTO.getPrezime(), trenerDTO.getUloga(), trenerDTO.getKontaktTelefon(), trenerDTO.getDatumRodjenja(),
                trenerDTO.getEmail(), trenerDTO.getAktivan());


        Trener noviTrener = trenerService.createTrener(trener);

        TrenerDTO newTrenerDTO = new TrenerDTO(noviTrener.getId(), noviTrener.getKorisnickoIme(), noviTrener.getLozinka(),
                noviTrener.getIme(), noviTrener.getPrezime(), noviTrener.getUloga(), noviTrener.getKontaktTelefon(), noviTrener.getDatumRodjenja(),
                noviTrener.getEmail(), noviTrener.getAktivan());
        return new ResponseEntity<>(newTrenerDTO, HttpStatus.CREATED);
    }

}
