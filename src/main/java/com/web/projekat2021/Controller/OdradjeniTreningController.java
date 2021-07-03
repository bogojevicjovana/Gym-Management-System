package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.DTO.*;
import com.web.projekat2021.Model.OdradjeniTrening;
import com.web.projekat2021.Model.Sala;
import com.web.projekat2021.Model.Trening;
import com.web.projekat2021.Service.ClanService;
import com.web.projekat2021.Service.OdradjeniTreningService;
import com.web.projekat2021.Service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/odradjeni")
public class OdradjeniTreningController {

    private final OdradjeniTreningService odradjeniTreningService;

    @Autowired
    public OdradjeniTreningController(OdradjeniTreningService odradjeniTreningService) {this.odradjeniTreningService = odradjeniTreningService;}

    @Autowired
    public ClanService clanService;

    @Autowired
    public TreningService treningService;


    @GetMapping(value = "/prikazOdradjenih/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TreningDTO>> pregledOdradjenihTreninga(@PathVariable(name = "id") Long idClana) throws Exception{

        Clan clan = clanService.findOne(idClana);
        Set<OdradjeniTrening> odradjeniTreninzi = clan.getOdradjeniTreninziClana();
        Set<Trening> treninziOdr = new HashSet<>();

        for (OdradjeniTrening odrTr: odradjeniTreninzi) {
            Trening trening = odrTr.getTrening();
            treninziOdr.add(trening);
        }

        Set<TreningDTO> treninziDTOS = new HashSet<>();

        if (treninziOdr == null) {
            throw new Exception("Ne postoje odradjeni treninzi");
        } else {
            for (Trening trening : treninziOdr) {
                TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(),
                        trening.getTipTreninga(), trening.getTrajanje());
                treninziDTOS.add(treningDTO);
            }
        }

        return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/prikazOdradjenihBezOcene/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TreningDTO>> pregledOdradjenihTreningaBezOcene(@PathVariable(name = "id") Long idClana) throws Exception{

        Clan clan = clanService.findOne(idClana);
        Set<OdradjeniTrening> odradjeniTreninzi = clan.getOdradjeniTreninziClana();
        Set<Trening> treninziOdr = new HashSet<>();

        for (OdradjeniTrening odrTr: odradjeniTreninzi) {
            if(odrTr.getOcena() == null) {
                Trening trening = odrTr.getTrening();
                treninziOdr.add(trening);
            }
        }

        Set<TreningDTO> treninziDTOS = new HashSet<>();

        if (treninziOdr == null) {
            throw new Exception("Ne postoje prijavljeni treninzi");
        } else {
            for (Trening trening : treninziOdr) {
                TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(),
                        trening.getTipTreninga(), trening.getTrajanje());
                treninziDTOS.add(treningDTO);
            }
        }

        return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
    }


    
}




