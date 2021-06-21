$(document).on("submit", "form", function (event) {           // kada je submitovana forma za kreiranje novog trenera
     event.preventDefault();

    var korisnickoIme = $("#korisnickoIme").val();
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var uloga = $("#uloga").val();
    var kontaktTelefon = $("#kontaktTelefon").val();
    var datumRodjenja = $("#datumRodjenja").val();
    var email = $("#email").val();
    var aktivan = false;

    var noviTrenerJSON = formToJSON(korisnickoIme, lozinka, ime, prezime, uloga, kontaktTelefon, datumRodjenja, email, aktivan);  // pozivamo pomoćnu metodu da kreira JSON

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/treneri/dodaj-trenera-admin",
        dataType: "json",                           //tip povratne vrijednosti
        contentType: "application/json",            //tip podatka koji saljemo
        data: noviTrenerJSON,                       //u body-ju salje se novi trener
        success: function (data) {                  // poslije uspjesnog zahtjeva izvrsava se ova funkcija
            alert(ime + " " + prezime + " je uspešno kreiran kao " + uloga);    //prikazuje se poruka o uspjehu
            window.location.href = "home.html";                                //redirektujemo na login.html
        },

        error: function (data) {                                                //ukoliko se desi neuspjesan zahtjev
                    alert("Korisnicko ime " + korisnicko + " vec postoji!");
                }
    });
});

function formToJSON(korisnickoIme1, lozinka1, ime1, prezime1, uloga1, kontakt1, datumrodjenja1, email1, aktivan1) {
    return JSON.stringify({
        "korisnickoIme": korisnickoIme1,
        "lozinka": lozinka1,
        "ime": ime1,
        "prezime": prezime1,
        "uloga": uloga1,
        "kontaktTelefon": kontakt1,
        "datumRodjenja": datumrodjenja1,
        "email": email1,
        "aktivan": aktivan1
   });
}