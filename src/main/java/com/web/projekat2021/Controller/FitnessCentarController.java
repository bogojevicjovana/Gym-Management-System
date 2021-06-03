package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.DTO.ClanDTO;
import com.web.projekat2021.Model.DTO.FitnessCentarDTO;
import com.web.projekat2021.Model.FitnessCentar;
import com.web.projekat2021.Service.FitnessCentarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/fc")
public class FitnessCentarController {

    private final FitnessCentarService fitnessCentarService;

    public FitnessCentarController(FitnessCentarService fitnessCentarService){
        this.fitnessCentarService = fitnessCentarService;
    }

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


}
