INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('ivan.ivanovic', 'sifra123', 'Ivan', 'Ivanovic', 'Admin', 00381644877545, '22.04.1998.', 'ivanivanovic@gmail.com', true, 'admin');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('ana.ivanovic', 'sifra123', 'Ana', 'Ivanovic', 'Clan', 00381644877222, '22.04.1994.', 'anaivanovic@gmail.com', true, 'clan');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip)
VALUES ('milica.milic', 'sifra13', 'Milica', 'Milic', 'Clan', 00381644547545, '22.05.2000.', 'milicamilic@gmail.com', true, 'clan');

INSERT INTO fitness_centar(naziv, adresa, br_telefona_centrale, email) VALUES ('FitGym', 'Mise Dimitrijevica 18, Novi Sad', 00381665855457, 'fitgym@gmail.com');

INSERT INTO fitness_centar(naziv, adresa, br_telefona_centrale, email) VALUES ('XGym', 'Danila Kisa 18, Novi Sad', 00381123855457, 'xgym@gmail.com');

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip, fitnesscentar_id)
VALUES ('petar.petrovic', 'sifra12', 'Petar', 'Petrovic', 'Trener', 00381674177545, '22.04.1995.', 'petrovicpe@gmail.com', true, 'trener', 1);

INSERT INTO KORISNIK(korisnicko_ime, lozinka, ime, prezime, uloga, kontakt_telefon, datum_rodjenja, email, aktivan, tip, fitnesscentar_id)
VALUES ('ivana.petkovic', 'sifr125', 'Ivana', 'Petkovic', 'Trener', 00381674124545, '22.04.1996.', 'petkovicivana@gmail.com', true, 'trener', 2);

INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('Power Pilates', 'akcenat na disanju i tehnici', 'Pilates', '60min', 1);
INSERT INTO TRENING(naziv, opis, tip_treninga, trajanje, trener_id) VALUES ('Fat Burn', 'trening visokog intenziteta', 'Aerobni', '80min', 2);

INSERT INTO SALA(kapacitet, oznaka, fitnesscentar_id) VALUES (50, 'sala 1', 1);

INSERT INTO prijavljeni_treninzi(korisnik_id, trening_id) VALUES (2, 1);

INSERT INTO odradjeni_treninzi(korisnik_id, trening_id) VALUES (3, 2);

