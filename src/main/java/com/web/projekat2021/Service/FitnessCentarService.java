package com.web.projekat2021.Service;

import com.web.projekat2021.Model.FitnessCentar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FitnessCentarService {

    FitnessCentar create(FitnessCentar fc);

    List<FitnessCentar> listaCentara();

    FitnessCentar findOne(Long id);

    FitnessCentar update(FitnessCentar centar) throws Exception;

    void delete(Long id);
}
