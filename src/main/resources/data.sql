INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('ivan.ivanovic', 'sifra123', 'Ivan', 'Ivanovic', 'Admin', 00381644877545, '22.04.1998.', 'ivanivanovic@gmail.com', true, 'admin');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('ana.ivanovic', 'sifra123', 'Ana', 'Ivanovic', 'Clan', 00381644877222, '22.04.1994.', 'anaivanovic@gmail.com', true, 'clan');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('milica.milic', 'sifra13', 'Milica', 'Milic', 'Clan', 00381644547545, '22.05.2000.', 'milicamilic@gmail.com', true, 'clan');


INSERT INTO fitness_centar(naziv, adresa, br_telefona_centrale, email) VALUES ('FitGym', 'Mise Dimitrijevica 18, Novi Sad', 00381665855457, 'fitgym@gmail.com');

INSERT INTO fitness_centar(naziv, adresa, br_telefona_centrale, email) VALUES ('XGym', 'Danila Kisa 18, Novi Sad', 00381123855457, 'xgym@gmail.com');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip, fitnesscentar_id, prosecna_ocena)
VALUES ('petar.petrovic', 'sifra12', 'Petar', 'Petrovic', 'Trener', 00381674177545, '22.04.1995.', 'petrovicpe@gmail.com', false, 'trener', 1, 9.5);

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip, fitnesscentar_id, prosecna_ocena)
VALUES ('ivana.petkovic', 'sifr125', 'Ivana', 'Petkovic', 'Trener', 00381674124545, '22.04.1996.', 'petkovicivana@gmail.com', false, 'trener', 2, 8.7);

INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (50, 'SALA a', 1);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (60, 'SALA b', 1);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (40, 'SALA c', 2);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (30, 'SALA d', 2);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (10, 'SALA d', 2);

INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('Fat Burn', 'nema opisa', '60min', 'Aerobik', 4);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('Fitness Mix', 'nema opisa', '60min', 'Aerobik', 5);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('YogaTime', 'nema opisa', '70min', 'Yoga', 5);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('CardioBurn', 'nema opisa', '60min', 'Cardio', 5);



INSERT INTO TERMIN(broj_prijavljenih_cl, cena, datum, vreme, fitness_centar_id, trening_id) VALUES
(10, '2000din', '25.05.2021.', '16:30', 1, 1);

INSERT INTO TERMIN(broj_prijavljenih_cl, cena, datum, vreme, fitness_centar_id, trening_id) VALUES
(10, '2000din', '15.05.2021', '17:00', 2, 2);

INSERT INTO ODRADJENI_TRENING(ocena, clan_id, trening_id) VALUES (9.5, 2, 1);
INSERT INTO ODRADJENI_TRENING(ocena, clan_id, trening_id) VALUES (9, 2, 2);
INSERT INTO ODRADJENI_TRENING(clan_id, trening_id) VALUES (2, 2);


INSERT INTO PRIJAVLJENI_TRENINZI(korisnik_id, trening_id) VALUES (2, 1);

INSERT INTO RASPORED_SALA_TERMIN(sala_id, termin_id) VALUES (1, 1);

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('sanja.ivkovic', 'sifra123', 'Sanja', 'Ivkovic', 'Trener', 00381644511145, '22.05.1990.', 'sanjai@gmail.com', true, 'trener');