$(document).ready(function () {
    var id = localStorage.getItem('id');

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/prikazPrijavljenih/" + id,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";

                var btn = "<button class='btnOtkazi' id = " + data[i]['id'] + ">Otkazi prijavu</button>";

                row += "<td>" + btn + "</td>";

                $('#treninziClana').append(row);
            }
        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.btnOtkazi', function () {
    var treningId = this.id;
    var treningNaziv = this.naziv;
    var treningOpis = this.opis;
    var treningTip = this.tipTreninga;
    var treningTrajanje = this.trajanje;
    var treningOtk = this.otkazan;

    var treningToUpdate = formToJSON(treningId, treningOpis, treningTrajanje, treningTip, treningNaziv, treningOtk);

        $.ajax({
                type: "PUT",
                url: "http://localhost:8080/api/treninzi/" + treningId,
                dataType: "json",
                contentType: "application/json",
                data: treningToUpdate,
                success: function () {
                    console.log("SUCCESS");
                    window.location.href = "home.html";
                },
                error: function () {
                    alert("Greška");
                }
            });
        });

function formToJSON(idtreninga, opistr, trajanjetr, tiptr, nazivtr, treningOtk){
    return JSON.stringify({
        "id": idtreninga,
        "naziv": nazivtr,
        "trajanje": trajanjetr,
        "opis": opistr,
        "tipTreninga": tiptr,
        "otkazan": treningOtk
    })
}