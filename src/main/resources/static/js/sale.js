$(document).ready(function (){

    var idCentra = localStorage.getItem('idCentra');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/sale/" + idCentra,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['kapacitet'] + "</td>";
                row += "<td>" + data[i]['oznaka'] + "</td>";

                var btn1 = "<button class='btnIzmeniSalu' id = " + data[i]['id'] + ">Izmeni</button>";
                var btn2 = "<button class='btnObrisiSalu' id = " + data[i]['id'] + ">Obrisi</button>";

                row += "<td>" + btn1 + "</td>";
                row += "<td>" + btn2 + "</td>";

                $('#sale').append(row);
            }
        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on("submit", "form", function (event) {
    event.preventDefault();

    var centarId = localStorage.getItem('idCentra');

    var kapacitet = $("#kapacitet").val();
    var oznaka = $("#oznaka").val();

    var novaSalaJSON = formToJSON(kapacitet, oznaka);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/sale/dodaj-salu-za-centar/" + centarId,
        dataType: "json",
        contentType: "application/json",
        data: novaSalaJSON,
        success: function (data) {
            alert("Uspesno dodata nova sala za centar!");
            window.location.href = "saleCentar.html";
        },
    });
});

function formToJSON(kapacitet, oznaka) {
    return JSON.stringify({
        "kapacitet": kapacitet,
        "oznaka": oznaka
   });
}

$(document).on('click', '.btnIzmeniSalu', function () {
    localStorage.setItem('idZaIzmenuSale', this.id);
    window.location.href = "updateSala.html";
});

$(document).on('click', '.btnObrisiSalu', function () {
    $.ajax({
        type: "DELETE",
        url: "http://localhost:8080/api/sale/" + this.id,
        dataType: "json",
        success: function () {
            console.log("SUCCESS");
            window.location.href = "sale.html";
        },
        error: function () {
            alert("Greska prilikom brisanja sale");
        }
    })
});