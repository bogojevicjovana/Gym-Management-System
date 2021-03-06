package com.web.projekat2021.Controller;

import com.web.projekat2021.Model.*;
import com.web.projekat2021.Model.DTO.*;
import com.web.projekat2021.Repository.TreningRepository;
import com.web.projekat2021.Service.ClanService;
import com.web.projekat2021.Service.TrenerService;
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
@RequestMapping(value = "/api/treninzi")
public class TreningController {

    private final TreningService treningService;

    @Autowired
    public TreningController(TreningService treningService){
        this.treningService = treningService;
    }

    @Autowired
    public ClanService clanService;

    @Autowired
    public TrenerService trenerService;

    @Autowired
    public TreningRepository treningRepository;

    // izlistavanje treninga
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

    //sortiranje po nazivu
    @GetMapping(value = "/sort/naziv/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> sortirajTreningePoNazivu(){

        List<Trening> listaTreninga = this.treningService.sortByNaziv();

        List<TreningDTO> listaTreningDTOs = new ArrayList<>();

        for(Trening trening: listaTreninga){
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(),
                                                    trening.getTipTreninga(), trening.getTrajanje());

            listaTreningDTOs.add(treningDTO);
        }

        return new ResponseEntity<>(listaTreningDTOs, HttpStatus.OK);
    }

    //sortiranje po opisu
    @GetMapping(value = "/sort/opis/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> sortirajTreningePoOpisu(){

        List<Trening> listaTreninga = this.treningService.sortByOpis();

        List<TreningDTO> listaTreningDTOs = new ArrayList<>();

        for(Trening trening: listaTreninga){
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(),
                    trening.getTipTreninga(), trening.getTrajanje());

            listaTreningDTOs.add(treningDTO);
        }

        return new ResponseEntity<>(listaTreningDTOs, HttpStatus.OK);
    }

    //sortiranje po tipu treninga
    @GetMapping(value = "/sort/tiptreninga/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDTO>> sortirajTreningePoTipuTreninga(){

        List<Trening> listaTreninga = this.treningService.sortByTipTreninga();

        List<TreningDTO> listaTreningDTOs = new ArrayList<>();

        for(Trening trening: listaTreninga){
            TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(),
                    trening.getTipTreninga(), trening.getTrajanje());

            listaTreningDTOs.add(treningDTO);
        }

        return new ResponseEntity<>(listaTreningDTOs, HttpStatus.OK);
    }

    // pretraga po nazivu
    @PostMapping(value="/pretragaPoNazivu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> getTreningByNaziv(@RequestBody Trening treningDTO) {

        List<Trening> treninzi = treningService.findByNazivTr(treningDTO.getNaziv());

        return new ResponseEntity<>(treninzi, HttpStatus.OK);
    }

    //pretraga po tipu
    @PostMapping(value="/pretragaPoTipu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> getTreningByTip(@RequestBody Trening treningDTO) {

        List<Trening> treninzi = treningService.findByTipTr(treningDTO.getTipTreninga());

        return new ResponseEntity<>(treninzi, HttpStatus.OK);
    }

    //pretraga po opisu
    @PostMapping(value="/pretragaPoOpis", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trening>> getTreningByOpis(@RequestBody Trening treningDTO) {

        List<Trening> treninzi = treningService.findByOpisTr(treningDTO.getOpis());

        return new ResponseEntity<>(treninzi, HttpStatus.OK);
    }

    @GetMapping(value = "/prikazPrijavljenih/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TreningDTO>> pregledPrijavljenihTreninga(@PathVariable(name = "id") Long idClana) throws Exception {

        Clan clan = clanService.findOne(idClana);
        Set<Trening> treninzi = clan.getPrijavljeniTreninzi();

        Set<TreningDTO> treninziDTOS = new HashSet<>();

        if (treninzi == null) {
            throw new Exception("Ne postoje prijavljeni treninzi");
        } else {
            for (Trening trening : treninzi) {
                if (trening.getOtkazan().equals(false)) {
                    TreningDTO treningDTO = new TreningDTO(trening.getId(), trening.getNaziv(), trening.getOpis(),
                            trening.getTipTreninga(), trening.getTrajanje());
                    treninziDTOS.add(treningDTO);
                }
            }
        }

        return new ResponseEntity<>(treninziDTOS, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningDTO> otkaziTrening(@PathVariable Long id, @RequestBody TreningDTO treningDTO) throws Exception{

       Trening trening = new Trening(treningDTO.getId(), treningDTO.getNaziv(), treningDTO.getOpis(), treningDTO.getTipTreninga(), treningDTO.getTrajanje(), treningDTO.getOtkazan());

       Trening novi = this.treningService.otkazi(trening);

       TreningDTO otkazanTrenerDTO = new TreningDTO(novi.getId(), novi.getNaziv(), novi.getOpis(), novi.getTipTreninga(), novi.getTrajanje(), novi.getOtkazan());

       return new ResponseEntity<>(otkazanTrenerDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/dobavi/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Set<TerminTreningDTO>> treninziTrenera(@PathVariable(name = "id") Long idTrenera) throws Exception {

        Trener trener = this.trenerService.findOne(idTrenera);
        Set<Trening> listaTreninga = trener.getTreninziTrenera();

        Set<TerminTreningDTO> terminiTrenDTOs = new HashSet<>();

        for(Trening tren: listaTreninga){
            Set<Termin> termini = tren.getTreningTermini();
            for(Termin termin: termini){
                if(termin.getTrening().equals(tren)){
                    TerminTreningDTO terminDTO = new TerminTreningDTO(tren.getId(), tren.getNaziv(), tren.getTipTreninga(), tren.getOpis(), tren.getTrajanje(), termin.getDatum(), termin.getVreme(), termin.getCena());
                    terminiTrenDTOs.add(terminDTO);
                }
            }
        }

        return new ResponseEntity<>(terminiTrenDTOs, HttpStatus.OK);
    }

}
