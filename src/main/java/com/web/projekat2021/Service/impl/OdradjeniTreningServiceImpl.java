package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.OdradjeniTrening;
import com.web.projekat2021.Repository.OdradjeniTreningRepository;
import com.web.projekat2021.Service.OdradjeniTreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OdradjeniTreningServiceImpl implements OdradjeniTreningService {

    private final OdradjeniTreningRepository odradjeniTreningRepository;

    @Autowired
    public OdradjeniTreningServiceImpl(OdradjeniTreningRepository odradjeniTreningRepository) {this.odradjeniTreningRepository = odradjeniTreningRepository;}

    @Override
    public OdradjeniTrening findOne(Long id) {
        return this.odradjeniTreningRepository.getOne(id);
    }
}
