package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.FitnessCentar;
import com.web.projekat2021.Model.Sala;
import com.web.projekat2021.Repository.SalaRepository;
import com.web.projekat2021.Repository.TrenerRepository;
import com.web.projekat2021.Service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;

    @Autowired
    public SalaServiceImpl(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    @Override
    public List<Sala> listaSala(Long id) {
        return this.salaRepository.findByFitnesscentar(id);
    }

    @Override
    public Sala create(Sala novaSala) {
        return this.salaRepository.save(novaSala);
    }

    @Override
    public Sala findOne(Long id) {
        return this.salaRepository.getOne(id);
    }

    @Override
    public Sala update(Sala sala) throws Exception {
        Sala salaUpdate = this.salaRepository.getOne(sala.getId());

        if(salaUpdate == null) {
            throw new Exception("Sala ne postoji!");
        }

        salaUpdate.setKapacitet(sala.getKapacitet());
        salaUpdate.setOznaka(sala.getOznaka());

        return this.salaRepository.save(salaUpdate);
    }

    @Override
    public void delete(Long id) {this.salaRepository.deleteById(id);}

}
