
INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('ivan.ivanovic', 'sif', 'Ivan', 'Ivanovic', 'Admin', 00381644877545, '22.04.1998.', 'ivanivanovic@gmail.com', true, 'admin');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('ana.ivanovic', 'sifra123', 'Ana', 'Ivanovic', 'Clan', 00381644877222, '22.04.1994.', 'anaivanovic@gmail.com', true, 'clan');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('milica.milic', 'sifra13', 'Milica', 'Milic', 'Clan', 00381644547545, '22.05.2000.', 'milicamilic@gmail.com', true, 'clan');


INSERT INTO fitness_centar(naziv, adresa, br_telefona_centrale, email) VALUES ('FitGym', 'Mise Dimitrijevica 18, Novi Sad', 00381665855457, 'fitgym@gmail.com');

INSERT INTO fitness_centar(naziv, adresa, br_telefona_centrale, email) VALUES ('XGym', 'Danila Kisa 18, Novi Sad', 00381123855457, 'xgym@gmail.com');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip, fitnesscentar_id, prosecna_ocena)
VALUES ('sanja.ivkovic', 'sifra123', 'Sanja', 'Ivkovic', 'Trener', 00381644511145, '22.05.1990.', 'sanjai@gmail.com', true, 'trener', 1, 9.3);

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip, fitnesscentar_id, prosecna_ocena)
VALUES ('petar.petrovic', 'sifra12', 'Petar', 'Petrovic', 'Trener', 00381674177545, '22.04.1995.', 'petrovicpe@gmail.com', false, 'trener', NULL, 9.5);

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip, fitnesscentar_id, prosecna_ocena)
VALUES ('ivana.petkovic', 'sifr125', 'Ivana', 'Petkovic', 'Trener', 00381674124545, '22.04.1996.', 'petkovicivana@gmail.com', false, 'trener', NULL, 8.7);

INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (50, 'SALA a', 1);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (60, 'SALA b', 1);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (40, 'SALA c', 2);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (30, 'SALA d', 2);
INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (10, 'SALA d', 2);

INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id, otkazan) VALUES ('Fat Burn', 'Trening visokog intenziteta', 'Aerobik', '60min', 4, false);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id, otkazan) VALUES ('Fitness Mix', 'Zabavan i efikasan trening','Aerobik' ,'60min', 4, false);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id, otkazan) VALUES ('YogaTime', 'Jačanje i opuštanje mišica', 'Yoga', '70min', 4, false);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id, otkazan) VALUES ('CardioBurn', 'Intenzivno sagorijevanje kalorija', 'Cardio', '55min', 4, false);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id, otkazan) VALUES ('Force', 'Oblikovanje tijela bazičnim pokretima', 'Cardio', '55min', 4, false);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id, otkazan) VALUES ('Step', 'Kardio vežbe i vežbe snage', 'Cardio', '55min', 4, false);

INSERT INTO TERMIN(broj_prijavljenih_cl, cena, datum, vreme, fitness_centar_id, trening_id) VALUES
(12, '2500din', '13.07.2021.', '16:30', 1, 1);

INSERT INTO TERMIN(broj_prijavljenih_cl, cena, datum, vreme, fitness_centar_id, trening_id) VALUES
(10, '2000din', '15.07.2021', '17:00', 1, 1);

INSERT INTO TERMIN(broj_prijavljenih_cl, cena, datum, vreme, fitness_centar_id, trening_id) VALUES
(10, '2000din', '15.07.2021', '17:00', 1, 2);


INSERT INTO PRIJAVLJENI_TRENINZI(korisnik_id, trening_id) VALUES (2, 1);
INSERT INTO PRIJAVLJENI_TRENINZI(korisnik_id, trening_id) VALUES (2, 2);
INSERT INTO PRIJAVLJENI_TRENINZI(korisnik_id, trening_id) VALUES (3, 1);
INSERT INTO PRIJAVLJENI_TRENINZI(korisnik_id, trening_id) VALUES (3, 2);
INSERT INTO PRIJAVLJENI_TRENINZI(korisnik_id, trening_id) VALUES (3, 3);


INSERT INTO ODRADJENI_TRENING(ocena, clan_id, trening_id) VALUES (5, 2, 1);
INSERT INTO ODRADJENI_TRENING(ocena, clan_id, trening_id) VALUES (5, 2, 4);
INSERT INTO ODRADJENI_TRENING(ocena, clan_id, trening_id) VALUES (NULL, 3, 4);
INSERT INTO ODRADJENI_TRENING(ocena, clan_id, trening_id) VALUES (NULL, 3, 5);
INSERT INTO ODRADJENI_TRENING(ocena, clan_id, trening_id) VALUES (NULL, 3, 6);


INSERT INTO RASPORED_SALA_TERMIN(sala_id, termin_id) VALUES (1, 1);


INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('minja.ivkovic', 'sifra123', 'Minja', 'Ivkovic', 'Trener', 00381644511145, '22.05.1990.', 'minjai@gmail.com', true, 'trener');
