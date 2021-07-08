package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.*;
import com.web.projekat2021.Model.DTO.*;
import com.web.projekat2021.Repository.OdradjeniTreningRepository;
import com.web.projekat2021.Repository.TreningRepository;
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

    @Autowired
    public OdradjeniTreningRepository odradjeniTreningRepository;

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
    public ResponseEntity<Set<OdradjeniDTO>> pregledOdradjenihTreningaBezOcene(@PathVariable(name = "id") Long idClana) throws Exception{

        Clan clan = clanService.findOne(idClana);
        Set<OdradjeniTrening> odradjeniTreninzi = clan.getOdradjeniTreninziClana();
        Set<Trening> treninziOdr = new HashSet<>();


        for (OdradjeniTrening odrTr: odradjeniTreninzi) {
            if(odrTr.getOcena() == null) {
                Trening trening = odrTr.getTrening();
                treninziOdr.add(trening);
            }
        }

        Set<OdradjeniDTO> odrDTOs = new HashSet<>();

        for(OdradjeniTrening odradjeni: odradjeniTreninzi){
            for(Trening tr: treninziOdr){
                if(odradjeni.getTrening().equals(tr)){
                    OdradjeniDTO odradjeniDTO = new OdradjeniDTO(tr.getId(), tr.getNaziv(), tr.getOpis(), tr.getTipTreninga(), tr.getTrajanje(), odradjeni.getOcena());
                    odrDTOs.add(odradjeniDTO);
                }
            }
        }

        return new ResponseEntity<>(odrDTOs, HttpStatus.OK);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OdradjeniTreningDTO> izmeniCentar(@RequestBody OdradjeniTreningDTO odradjeniDTO) throws Exception
    {
        Trening trening = this.treningService.findOne(odradjeniDTO.getIdTreninga());
        Clan clan = this.clanService.findOne(odradjeniDTO.getIdClana());

        List<OdradjeniTrening> odradjeni = this.odradjeniTreningRepository.findAll();

        for(OdradjeniTrening odr: odradjeni){
            if(odr.getTrening().equals(trening)){
                if(odr.getClan().equals(clan)){
                    odr.setOcena(odradjeniDTO.getOcena());
                    OdradjeniTrening odradjeniTr = this.odradjeniTreningRepository.save(odr);
                    OdradjeniTreningDTO dtoOdr = new OdradjeniTreningDTO(odradjeniTr.getId(), odradjeniTr.getTrening().getId(), odradjeniTr.getOcena(), odradjeniTr.getClan().getId());
                    return new ResponseEntity<>(dtoOdr, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(null, HttpStatus.OK);

    }

    @GetMapping(value = "/prikazOdradjenihSaOcenom/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<OdradjeniDTO>> pregledOdradjenihTreningaSaOcenom(@PathVariable(name = "id") Long idClana) throws Exception{

        Clan clan = clanService.findOne(idClana);
        Set<OdradjeniTrening> odradjeniTreninzi = clan.getOdradjeniTreninziClana();
        Set<Trening> treninziOdr = new HashSet<>();


        for (OdradjeniTrening odrTr: odradjeniTreninzi) {
            if(odrTr.getOcena() != null) {
                Trening trening = odrTr.getTrening();
                treninziOdr.add(trening);
            }
        }

        Set<OdradjeniDTO> odrDTOs = new HashSet<>();

        for(OdradjeniTrening odradjeni: odradjeniTreninzi){
            for(Trening tr: treninziOdr){
                if(odradjeni.getTrening().equals(tr)){
                    OdradjeniDTO odradjeniDTO = new OdradjeniDTO(tr.getId(), tr.getNaziv(), tr.getOpis(), tr.getTipTreninga(), tr.getTrajanje(), odradjeni.getOcena());
                    odrDTOs.add(odradjeniDTO);
                }
            }
        }

        return new ResponseEntity<>(odrDTOs, HttpStatus.OK);
    }
}




