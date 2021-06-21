$(document).ready(function () {
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/api/fc/dobavi-centre",    // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (data) {
            console.log("SUCCESS : ", data);                         // ispisujemo u konzoli povratnu vrednost

            for(let fitness_centar of data) {                               // prolazimo kroz listu svih trenera
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + fitness_centar.id + "</td>";                // ubacujemo podatke jednog trenera u polja
                row += "<td>" + fitness_centar.naziv + "</td>";
                row += "<td>" + fitness_centar.adresa + "</td>";
                row += "<td>" + fitness_centar.brTelefonaCentrale + "</td>";
                row += "<td>" + fitness_centar.email + "</td>";


                $('#fitness_centar').append(row);                                   // ubacujemo kreirani red u tabelu čiji je id = treneri

            }
        },
                    error: function (data) {                                // ova f-ja se izvršava posle neuspešnog zahteva
                    console.log("ERROR: ", data);
        }

    });
});
