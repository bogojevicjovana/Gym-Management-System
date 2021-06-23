package com.web.projekat2021.Service;

import com.web.projekat2021.Model.Sala;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SalaService {

    List<Sala> listaSala(Long id);


    Sala create(Sala novaSala);
}
