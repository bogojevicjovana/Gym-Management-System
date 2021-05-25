package com.web.projekat2021.Model;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("clan")
public class Clan extends Korisnik{

    //vise clanova se moze prijaviti za jedan trening
    @ManyToMany
    @JoinTable(name = "prijavljeni_treninzi",
            joinColumns = @JoinColumn(name = "korisnik_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "trening_id", referencedColumnName = "id"))
    private Set<Trening> prijavljeniTreninzi = new HashSet<>();

    @OneToMany(mappedBy = "clan")
    private Set<OdradjeniTrening> odraljeniTreninziClana = new HashSet<>();

    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String kontaktTelefon, String datumRodjenja, String email, Boolean aktivan, Set<Trening> prijavljeniTreninzi, Set<OdradjeniTrening> odraljeniTreninziClana) {
        super(korisnickoIme, lozinka, ime, prezime, uloga, kontaktTelefon, datumRodjenja, email, aktivan);
        this.prijavljeniTreninzi = prijavljeniTreninzi;
        this.odraljeniTreninziClana = odraljeniTreninziClana;
    }

    public Clan(){}

    public Clan(String korisnickoIme, String lozinka, String ime, String prezime, String uloga, String kontaktTelefon, String datumRodjenja, String email, Boolean aktivan) {
        super(korisnickoIme, lozinka, ime, prezime, uloga, kontaktTelefon, datumRodjenja, email, aktivan);
    }
}
