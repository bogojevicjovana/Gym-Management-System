package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.*;
import com.web.projekat2021.Model.DTO.ClanDTO;
import com.web.projekat2021.Model.DTO.FitnessCentarDTO;
import com.web.projekat2021.Model.DTO.TreningDTO;
import com.web.projekat2021.Service.FitnessCentarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/fc")
public class FitnessCentarController {

    private final FitnessCentarService fitnessCentarService;

    public FitnessCentarController(FitnessCentarService fitnessCentarService){
        this.fitnessCentarService = fitnessCentarService;
    }

    //dodavanje novog fitnes centra
    @PostMapping(
            value = "/dodaj-fitness-centar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> registracijaFitnessCentra(@RequestBody FitnessCentarDTO fcDTO) throws Exception {

        FitnessCentar noviCentar = new FitnessCentar(fcDTO.getNaziv(), fcDTO.getAdresa(), fcDTO.getBrTelefonaCentrale(),
                fcDTO.getEmail());

        FitnessCentar newFitnessCenter = fitnessCentarService.create(noviCentar);

        FitnessCentarDTO newFitnessCenterDTO = new FitnessCentarDTO(newFitnessCenter.getId(), newFitnessCenter.getNaziv(), newFitnessCenter.getAdresa(),
                newFitnessCenter.getBrTelefonaCentrale(), newFitnessCenter.getEmail());

        return new ResponseEntity<>(newFitnessCenterDTO, HttpStatus.CREATED);
    }

    @GetMapping(value = "/dobavi-centre", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCentarDTO>> dobaviCentre(){

        List<FitnessCentar> lista = this.fitnessCentarService.listaCentara();
        List<FitnessCentarDTO> centarDTOs = new ArrayList<>();

        for(FitnessCentar fitnessCentar: lista){
            FitnessCentarDTO centarDTO = new FitnessCentarDTO(fitnessCentar.getId(), fitnessCentar.getNaziv(), fitnessCentar.getBrTelefonaCentrale(), fitnessCentar.getAdresa(), fitnessCentar.getEmail());
            centarDTOs.add(centarDTO);
        }

        return new ResponseEntity<>(centarDTOs, HttpStatus.OK);
    }

    @PostMapping(value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCentarDTO> izmeniCentar(@RequestBody FitnessCentarDTO centarDTO) throws Exception {
        FitnessCentar centar = fitnessCentarService.findOne(centarDTO.getId());

        if(!centarDTO.getNaziv().equals("")) { centar.setNaziv(centarDTO.getNaziv()); }
        if(!centarDTO.getBrTelefonaCentrale().equals("")) { centar.setBrTelefonaCentrale(centarDTO.getBrTelefonaCentrale()); }
        if(!centarDTO.getAdresa().equals("")) { centar.setAdresa(centarDTO.getAdresa()); }
        if(!centarDTO.getEmail().equals("")) { centar.setEmail(centarDTO.getEmail()); }

        FitnessCentar izmenjenCentar = this.fitnessCentarService.update(centar);

        FitnessCentarDTO izmenjenCentarDTO = new FitnessCentarDTO(izmenjenCentar.getId(), izmenjenCentar.getNaziv(), izmenjenCentar.getBrTelefonaCentrale(),
                izmenjenCentar.getAdresa(), izmenjenCentar.getEmail());

        return new ResponseEntity<>(izmenjenCentarDTO, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCentar(@PathVariable Long id) {
        // Pozivanjem metode servisa brišemo zaposlenog po ID-ju
        this.fitnessCentarService.delete(id);
        // Vraćamo odgovor 204 NO_CONTENT koji signalizira uspešno brisanje
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
