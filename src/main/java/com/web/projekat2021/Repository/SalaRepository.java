package com.web.projekat2021.Repository;

import com.web.projekat2021.Model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    List<Sala> findByFitnesscentar(Long id);
}
