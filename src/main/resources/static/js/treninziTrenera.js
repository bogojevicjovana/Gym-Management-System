$(document).ready(function (){

    var id = localStorage.getItem('id');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/dobavi/" + id,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (let trening of data) {
                var row = "<tr>";
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";
                row += "<td>" + trening.datum + "</td>";
                row += "<td>" + trening.vreme + "</td>";
                row += "<td>" + trening.cena + "</td>";

                let btn1 = "<button class='btnIzmeni' id = " + trening.id + ">Izmeni raspored</button>";
                row += "<td>" + btn1 + "</td>";

                $('#treninziTrenera').append(row);
            }
        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});