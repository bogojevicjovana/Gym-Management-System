package com.web.projekat2021.Repository;

import com.web.projekat2021.Model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {

    List<Trening> findByOrderByNaziv();

    List<Trening> findByOrderByOpis();

    List<Trening> findByOrderByTipTreninga();

    List<Trening> findByNazivIgnoreCaseContaining(String naziv);

    List<Trening> findByTipTreningaIgnoreCaseContaining(String naziv);

    List<Trening> findByOpisIgnoreCaseContaining(String opis);
}
