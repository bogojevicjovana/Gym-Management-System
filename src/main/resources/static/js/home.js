function formToJSON(idtr, imetr, prezimetr, korisnicko, kontaktTel, datumRodj, emailad, aktivann, ulogaa, lozz){
    return JSON.stringify({
        "id" : idtr,
        "ime": imetr,
        "prezime": prezimetr,
        "korisnickoIme": korisnicko,
        "kontaktTelefon": kontaktTel,
        "datumRodjenja": datumRodj,
        "email": emailad,
        "aktivan": aktivann,
        "uloga": ulogaa,
        "lozinka": lozz
    })
}

$(document).ready(function () {
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/treneri/dobavi-trenere",    // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (data) {
            console.log("SUCCESS : ", data);                         // ispisujemo u konzoli povratnu vrednost

            for(let trener of data) {                               // prolazimo kroz listu svih trenera
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.korisnickoIme + "</td>";
                row += "<td>" + trener.lozinka + "</td>";
                row += "<td>" + trener.kontaktTelefon + "</td>";
                row += "<td>" + trener.uloga + "</td>";
                row += "<td>" + trener.datumRodjenja + "</td>";
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.aktivan + "</td>";

                let btn = "<button class='btnOdobriTrenera' data-id=" + trener.id + ">Odobri registraciju</button>";  // ubacujemo button u poslednje polje reda
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treneri').append(row);                                   // ubacujemo kreirani red u tabelu čiji je id = treneri

            }
        },
                    error: function (data) {                                // ova f-ja se izvršava posle neuspešnog zahteva
                    console.log("ERROR: ", data);
        }

    });
});

$(document).on('click', '.btnOdobriTrenera', function () {
    let trenerId = this.dataset.id;
    let trenerIme = this.dataset.ime;
    let trenerKorisnickoIme = this.dataset.korisnickoIme;
    let trenerUloga = this.dataset.uloga;
    let trenerKontakt = this.dataset.kontaktTelefont;
    let trenerDatumR = this.dataset.datumRodjenja;
    let trenerAktivan = this.dataset.aktivan;
    let trenerLoz = this.dataset.lozinka;
    let trenerEm = this.dataset.email;
    let trenerPre = this.dataset.prezime;

    var trenerToUpdate = formToJSON(trenerId, trenerIme, trenerPre, trenerKorisnickoIme, trenerKontakt, trenerDatumR,
                                trenerEm, trenerAktivan, trenerUloga, trenerLoz);

    $.ajax({
            type: "PUT",
            url: "http://localhost:8080/api/treneri/" + trenerId,
            dataType: "json",
            contentType: "application/json",
            data: trenerToUpdate,
            success: function () {
                console.log("SUCCESS");
                window.location.href = "treneri.html";
            },
            error: function () {
                alert("Greška");
            }
        });
});

//lista svih trenera

$(document).ready(function () {
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/treneri/dobavi-sve-trenere",    // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (data) {
            console.log("SUCCESS : ", data);                         // ispisujemo u konzoli povratnu vrednost

            for(let trener of data) {                               // prolazimo kroz listu svih trenera
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.korisnickoIme + "</td>";
                row += "<td>" + trener.lozinka + "</td>";
                row += "<td>" + trener.kontaktTelefon + "</td>";
                row += "<td>" + trener.uloga + "</td>";
                row += "<td>" + trener.datumRodjenja + "</td>";
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.aktivan + "</td>";

                let btn = "<button class='btnIzbrisiTrenera' data-id=" + trener.id + ">Ukloni</button>";  // ubacujemo button u poslednje polje reda
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#svi_treneri').append(row);                                   // ubacujemo kreirani red u tabelu čiji je id = treneri

            }
        },
                    error: function (data) {                                // ova f-ja se izvršava posle neuspešnog zahteva
                    console.log("ERROR: ", data);
        }

    });
});

$(document).on('click', '.btnIzbrisiTrenera', function () {
    let trenerId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/treneri/" + trenerId,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            $('[data-id="' + trenerId + '"]').parent().parent().remove();
        },
        error: function () {
            alert("Greška prilikom brisanja trenera!");
        }
    });
});