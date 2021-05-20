package com.web.projekat2021.Service.impl;

import com.web.projekat2021.Model.Clan;
import com.web.projekat2021.Model.Trener;
import com.web.projekat2021.Repository.TrenerRepository;
import com.web.projekat2021.Service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrenerServiceImpl implements TrenerService {

    @Autowired
    private TrenerRepository trenerRepository;

    @Override
    public Trener createTrener(Trener trener) throws Exception {

        trener.setAktivan(false);
        trener.setUloga("clan");
        Trener noviTrener = this.trenerRepository.save(trener);

        return noviTrener;
    }

}
