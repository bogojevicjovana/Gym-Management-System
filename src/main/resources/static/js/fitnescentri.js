
$(document).ready(function (){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/fc/dobavi-centre",
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (let centar of data) {
                var row = "<tr>";
                row += "<td>" + centar.naziv + "</td>";
                row += "<td>" + centar.brTelefonaCentrale + "</td>";
                row += "<td>" + centar.adresa + "</td>";
                row += "<td>" + centar.email + "</td>";

                let btn1 = "<button class='btnIzmeniCentar' id = " + centar.id + ">Izmeni</button>";
                let btn2 = "<button class='btnObrisiCentar' id =" + centar.id + ">Ukloni</button>";
                let btn3 = "<button class='btnSaleCentar' id = " + centar.id + ">Sale</button>";

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

$(document).on('click', '.btnObrisiCentar', function () {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/fc/" + this.id,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            window.location.href = "home.html";
        },
        error: function () {
            alert("Greska prilikom brisanja centra");
        }
    })
});

$(document).on('click', '.btnSaleCentar', function() {
    localStorage.setItem('idCentra', this.id);
    console.log("Uspeh");
    window.location.href = "saleCentar.html";
});