package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.FitnessCentar;
import com.web.projekat2021.Repository.FitnessCentarRepository;
import com.web.projekat2021.Service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FitnessCentarServiceImpl implements FitnessCentarService{


            private final FitnessCentarRepository fitnessCentarRepository;

            @Autowired
            public FitnessCentarServiceImpl(FitnessCentarRepository fitnessCentarRepository){
                this.fitnessCentarRepository = fitnessCentarRepository;
            }

            @Override
            public FitnessCentar create(FitnessCentar fc) {
                FitnessCentar noviCentar = this.fitnessCentarRepository.save(fc);
                return noviCentar;
            }

            @Override
            public List<FitnessCentar> listaCentara() {
                return this.fitnessCentarRepository.findAll();
            }

            @Override
            public FitnessCentar findOne(Long id) {return this.fitnessCentarRepository.getOne(id);}

            @Override
            public FitnessCentar update(FitnessCentar centar) throws Exception {
                FitnessCentar centarUpdate = this.fitnessCentarRepository.getOne(centar.getId());

                if(centarUpdate == null) {
                    throw new Exception("Centar ne postoji!");
                }

                centarUpdate.setNaziv(centar.getNaziv());
                centarUpdate.setBrTelefonaCentrale(centar.getBrTelefonaCentrale());
                centarUpdate.setAdresa(centar.getAdresa());
                centarUpdate.setEmail(centar.getEmail());

                return this.fitnessCentarRepository.save(centarUpdate);}

                @Override
                public void delete(Long id) {this.fitnessCentarRepository.deleteById(id);}

}

