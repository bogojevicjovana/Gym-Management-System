
$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fc/dobavi-centre",
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['brTelefonaCentrale'] + "</td>";
                row += "<td>" + data[i]['adresa'] + "</td>";
                row += "<td>" + data[i]['email'] + "</td>";

                var btn1 = "<button class='btnIzmeniCentar' id = " + data[i]['id'] + ">Izmeni</button>";
                var btn2 = "<button class='btnIzbrisiCentar' id =" + data[i]['id'] + ">Ukloni</button>";
                var btn3 = "<button class='btnSaleCentar' id = " + data[i]['id'] + ">Sale</button>";

                row += "<td>" + btn1 + "</td>";
                row += "<td>" + btn2 + "</td>";
                row += "<td>" + btn3 + "</td>";


                $('#fitness_centar').append(row);
            }
        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.btnIzmeniCentar', function () {
    localStorage.setItem('idZaIzmenu', this.id);
    window.location.href = "updateCentar.html";
});

$(document).on('click', '.btnIzbrisiCentar', function() {
    let idZaBrisanje = this.dataset.id;

    $.ajax({
        type: "DELETE",
        utl : "http://localhost:8080/api/fc/" + idZaBrisanje,
        dataType: "json",
        success: function(){
            console.log("SUCCESS");
            $('[data-id="' + idZaBrisanje + '"]').parent().parent().remove();
        },
        error: function() {
            alert("Greska prilikom uklanjanja fitnes centra!");
        }
    });
});

$(document).on('click', '.btnSaleCentar', function() {
    localStorage.setItem('idCentra', this.id);
    console.log("Uspeh");
    window.location.href = "saleCentar.html";
});