package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.DTO.KorisnikDTO;
import com.web.projekat2021.Model.DTO.LoginKorisnikDTO;
import com.web.projekat2021.Model.DTO.TreningDTO;
import com.web.projekat2021.Model.Trening;
import com.web.projekat2021.Service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/treninzi")
public class TreningController {

    private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService){
        this.treningService = treningService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> dobaviTreninge(){

        List<Trening> listaTrenin = this.treningService.listaTreninga();
        List<TreningDTO> treningDTOs = new ArrayList<>();

        for(Trening trening: listaTrenin){
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje());
            treningDTOs.add(treningDTO);
        }

        return new ResponseEntity<>(treningDTOs, HttpStatus.OK);
    }
}
