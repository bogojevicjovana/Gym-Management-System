$(document).on('click', '.btnOdobriTrenera', function () {

    var id = localStorage.getItem('idTreneraZaOdobravanje');
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var uloga = $("#uloga").val();
    var kontaktTelefon = $("#kontaktTelefon").val();
    var datumRodjenja = $("#datumRodjenja").val();
    var email = $("#email").val();
    var atkivan = $("aktivan").val();

    var noviTrenerJSON = formToJSON(korisnickoIme, lozinka, ime, prezime, uloga, kontaktTelefon, datumRodjenja, email, aktivan);

    $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/treneri/odobri-trenera",
            contentType: "application/json",
            dataType: "json",
            data: noviTrenerJSON,
            success: function(data) {
                console.log("SUCCESS : ", data);
                alert("Uspeh");
                window.location.href = "index.html";
            },
            error: function (data) {
                console.log("ERROR : ", data);
                alert("Greska");
            }
        });
});

function formToJSON(korisnickoIme1, lozinka1, ime1, prezime1, uloga1, kontakt1, datumrodjenja1, email1, aktivan1) {
    return JSON.stringify({
        "korisnickoIme": korisnickoIme1,
        "lozinka": lozinka1,
        "ime": ime1,
        "prezime": prezime1,
        "uloga": uloga1,
        "kontaktTelefon": kontakt1,
        "datumRodjenja": datumrodjenja1,
        "email": email1,
        "aktivan": aktivan1
   });
}