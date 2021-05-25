package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.FitnessCentar;
import com.web.projekat2021.Repository.FitnessCentarRepository;
import com.web.projekat2021.Service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}

