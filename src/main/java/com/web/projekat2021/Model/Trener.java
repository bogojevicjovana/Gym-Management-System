package com.web.projekat2021.Model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("trener")
public class Trener extends Korisnik {
}
