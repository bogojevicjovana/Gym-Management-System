package com.web.projekat2021.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OdradjeniTrening implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Float ocena;

    @ManyToOne
    private Clan clan;

    @ManyToOne
    private Trening trening;

}
