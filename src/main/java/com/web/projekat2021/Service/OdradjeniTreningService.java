package com.web.projekat2021.Service;

import com.web.projekat2021.Model.OdradjeniTrening;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface OdradjeniTreningService {

    OdradjeniTrening findOne(Long id);

    OdradjeniTrening create(OdradjeniTrening novi);
}
