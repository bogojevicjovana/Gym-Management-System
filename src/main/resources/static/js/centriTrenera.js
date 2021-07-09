$(document).ready(function (){

    var id = localStorage.getItem('id');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treneri/centri/" + id,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
                var row = "<tr>";
                row += "<td>" + data.naziv + "</td>";
                row += "<td>" + data.brTelefonaCentrale + "</td>";
                row += "<td>" + data.adresa + "</td>";
                row += "<td>" + data.email + "</td>";

                let btn1 = "<button class='btnRaspored' id = " + data.id + ">Raspored</button>";
                row += "<td>" + btn1 + "</td>";

                $('#fitness_centar').append(row);

        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});
