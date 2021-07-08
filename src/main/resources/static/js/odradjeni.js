$(document).ready(function () {
    var id = localStorage.getItem('id');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/odradjeni/prikazOdradjenih/" + id,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";

                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";

                $('#odradjeniTreninziClana').append(row);
            }
        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});

$(document).ready(function () {
    var id = localStorage.getItem('id');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/odradjeni/prikazOdradjenihBezOcene/" + id,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";

                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";


                var btn1 = "<button class='btnOceni' id = " + data[i]['id'] + ">Oceni</button>";  // ubacujemo button u poslednje polje reda
                row += "<td>" + btn1 + "</td>";

                $('#odradjeniTreninziClanaBezOcene').append(row);
            }
        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.btnOceni', function () {
    localStorage.setItem("idTreninga", this.id);
    window.location.href = "oceniTrening.html";
});

function formToJSON(ocena, idClana, idTreninga) {
    return JSON.stringify(
        {
            "ocena": ocena,
            "idClana": idClana,
            "idTreninga" : idTreninga
        }
    );
}

$(document).on("submit", "form", function(event){
    event.preventDefault();

    var idTreninga = localStorage.getItem("idTreninga");
    var ocena = $("#ocena").val();
    var idClana = localStorage.getItem('id');

    var JSONValue = formToJSON(ocena, idClana, idTreninga);

    $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/odradjeni/update",
            dataType: "json",
            contentType: "application/json",
            data: JSONValue,
            success: function (data) {
                console.log(data);
                window.location.href = "odradjeni.html";
            },
            error: function (data) {
                console.log(data);
                alert("Greska prilikom ocenjivanja treninga!");
            }
    });
});

$(document).ready(function () {
    var id = localStorage.getItem('id');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/odradjeni/prikazOdradjenihSaOcenom/" + id,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";

                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                row += "<td>" + data[i]['ocena'] + "</td>";

                $('#odradjeniTreninziClanaSaOcenom').append(row);
            }
        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});