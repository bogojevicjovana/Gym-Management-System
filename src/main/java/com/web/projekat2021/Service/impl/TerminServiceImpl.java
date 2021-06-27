package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Repository.SalaRepository;
import com.web.projekat2021.Repository.TerminRepository;
import com.web.projekat2021.Service.TerminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminServiceImpl implements TerminService {

    private final TerminRepository terminRepository;

    @Autowired
    public TerminServiceImpl(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }
}
