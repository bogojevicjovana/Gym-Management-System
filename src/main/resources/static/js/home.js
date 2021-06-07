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
        type: "GET",
        url: "http://localhost:8080/api/treneri/dobavi-trenere",
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);

            for(let trener of data) {
                let row = "<tr>";
                row += "<td>" + trener.id + "</td>";
                row += "<td>" + trener.ime + "</td>";
                row += "<td>" + trener.prezime + "</td>";
                row += "<td>" + trener.korisnickoIme + "</td>";
                row += "<td>" + trener.lozinka + "</td>";
                row += "<td>" + trener.kontaktTelefon + "</td>";
                row += "<td>" + trener.uloga + "</td>";
                row += "<td>" + trener.datumRodjenja + "</td>";
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.aktivan + "</td>";

                let btn = "<button class='btnOdobriTrenera' data-id=" + trener.id + ">Odobri registraciju</button>";
                row += "<td>" + btn + "</td>";
                row += "</tr>";

                $('#treneri').append(row);

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
                window.location.href = "home.html";
            },
            error: function () {
                alert("Greška");
            }
        });
});