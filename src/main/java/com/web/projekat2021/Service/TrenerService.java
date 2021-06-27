package com.web.projekat2021.Service;

import com.web.projekat2021.Model.Trener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrenerService {

    Trener create(Trener trener) throws Exception;

    List<Trener> listaTrenera();

    Trener findOne(Long id);

    Trener update(Trener trener) throws Exception;

    List<Trener> listaSvihTrenera();

    void delete(long id);

    Trener createTrener(Trener trener) throws Exception;

    void obrisi(Long id);
}
