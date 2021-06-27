$(document).on("submit", "form", function (event) {
    event.preventDefault();

    var id = localStorage.getItem('idZaIzmenuSale');
    var kapacitet = $("#kapacitet").val();
    var oznaka = $("#oznaka").val();
    var updateSalaJSON = formToJSON(id, kapacitet, oznaka);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/sale/update",
        contentType: "application/json",
        dataType: "json",
        data: updateSalaJSON,
        success: function(data) {
            console.log("SUCCESS : ", data);
            alert("Uspesno izvrsene izmene!");
            window.location.href = "saleCentar.html";
        },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greska prilikom izmene");
        }

    });
});

function formToJSON(id, kapacitet, oznaka) {
    return JSON.stringify({
        "id": id,
        "kapacitet": kapacitet,
        "oznaka": oznaka
   });
}
