$(document).on("submit", "form", function (event) {
    event.preventDefault();

    var id = localStorage.getItem('idZaIzmenu');
    var naziv = $("#naziv").val();
    var brTelefonaCentrale = $("#brTelefonaCentrale").val();
    var adresa = $("#adresa").val();
    var email = $("#email").val();
    var noviCentarJSON = formToJSON(id, naziv, brTelefonaCentrale, adresa, email);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fc/update",
        contentType: "application/json",
        dataType: "json",
        data: noviCentarJSON,
        success: function(data) {
            console.log("SUCCESS : ", data);
            alert("Uspesno izvrsene izmene!");
            window.location.href = "sale.html";
        },
        error: function (data) {
            console.log("ERROR : ", data);
            alert("Greska prilikom izmene");
        }

    });
});

function formToJSON(id, naziv, brTelefonaCentrale, adresa, email) {
    return JSON.stringify({
        "id": id,
        "naziv": naziv,
        "brTelefonaCentrale": brTelefonaCentrale,
        "adresa": adresa,
        "email": email,
    });
}
