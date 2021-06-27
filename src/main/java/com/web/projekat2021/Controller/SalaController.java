package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.DTO.FitnessCentarDTO;
import com.web.projekat2021.Model.DTO.SalaDTO;
import com.web.projekat2021.Model.DTO.TrenerDTO;
import com.web.projekat2021.Model.FitnessCentar;
import com.web.projekat2021.Model.Sala;
import com.web.projekat2021.Model.Trener;
import com.web.projekat2021.Service.FitnessCentarService;
import com.web.projekat2021.Service.KorisnikService;
import com.web.projekat2021.Service.SalaService;
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
@RequestMapping(value = "/api/sale")
public class SalaController {

    private final SalaService salaService;

    @Autowired
    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @Autowired
    public FitnessCentarService fitnessCentarService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Set<SalaDTO>> dobaviSale(@PathVariable(name = "id") Long id) throws Exception{
        FitnessCentar centar = fitnessCentarService.findOne(id);        // pronaci centar po prosledjenom id-ju

        Set<Sala> listaSala = centar.getSale();                         // pronaci listu sala za taj centar

        Set<SalaDTO> salaDTOs = new HashSet<>();

        if (listaSala.isEmpty()) {
            throw new Exception("Lista sala prazna");
        } else
        for(Sala pronadjenaSala: listaSala) {
            SalaDTO sala = new SalaDTO(pronadjenaSala.getId(), pronadjenaSala.getKapacitet(), pronadjenaSala.getOznaka());
            salaDTOs.add(sala);
        }

        return new ResponseEntity<>(salaDTOs, HttpStatus.OK);

    }

    @PostMapping(
            value = "/dodaj-salu-za-centar/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> registracijaSale(@PathVariable(name = "id") Long id, @RequestBody SalaDTO salaDTO) throws Exception {
        FitnessCentar centar = fitnessCentarService.findOne(id);

        Sala novaSala = new Sala(salaDTO.getKapacitet(), salaDTO.getOznaka(), centar);

        Sala newSala = salaService.create(novaSala);

        SalaDTO novaDTO = new SalaDTO(newSala.getId(), newSala.getOznaka(), newSala.getKapacitet(), newSala.getFitnesscentar());

        return new ResponseEntity<>(novaDTO, HttpStatus.CREATED);
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDTO> izmeniSalu(@RequestBody SalaDTO salaDTO) throws Exception {
        Sala sala = salaService.findOne(salaDTO.getId());

        if(!salaDTO.getKapacitet().equals("")) { sala.setKapacitet(salaDTO.getKapacitet()); }
        if(!salaDTO.getOznaka().equals("")) { sala.setOznaka(salaDTO.getOznaka()); }

        Sala novaSala = this.salaService.update(sala);
        SalaDTO izmenjenaSalaDTO = new SalaDTO(novaSala.getId(), novaSala.getKapacitet(), novaSala.getOznaka());

        return new ResponseEntity<>(izmenjenaSalaDTO, HttpStatus.OK);
    }

}
