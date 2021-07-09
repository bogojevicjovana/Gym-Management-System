$(document).on("submit", "form", function (event) {
     event.preventDefault();

    var naziv = $("#naziv").val();
    var adresa = $("#adresa").val();
    var brTelefonaCentrale = $("#brTelefonaCentrale").val();
    var email = $("#email").val();


    var noviCentarJSON = formToJSON(naziv, adresa, brTelefonaCentrale, email);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/fc/dodaj-fitness-centar",
        dataType: "json",
        contentType: "application/json",
        data: noviCentarJSON,
        success: function (data) {
            alert("Uspesno kreiran novi fitness centar");
            window.location.href = "sale.html";
        },
    });
});

function formToJSON(naziv1, adresa1, brTelefonaCentrale1, email1) {
    return JSON.stringify({
        "naziv": naziv1,
        "adresa": adresa1,
        "brTelefonaCentrale" : brTelefonaCentrale1,
        "email" : email1
   });
}