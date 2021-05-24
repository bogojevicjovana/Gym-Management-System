$(document).on("submit", "form", function(event){

    // da se izbegne izvrsavanja pravog submita forme
    event.preventDefault();

    var korisnickoIme = $("#korisnickoIme").val();
    var lozinka = $("#lozinka").val();
    var myJSON = formToJSON(korisnickoIme, lozinka);

    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/korisnici",
        dataType: "json",
        contentType: "application/json",
        data: myJSON,
        success: function (data) {

            console.log(data);
            alert(korisnickoIme + " logovan je na sistem");
            localStorage.setItem('id', data['id']);
            localStorage.setItem('korisnickoIme', data['korisnickoIme']);
            localStorage.setItem('lozinka', data['lozinka']);
            localStorage.setItem('ime', data['ime']);
            localStorage.setItem('prezime', data['prezime']);
            localStorage.setItem('uloga', data['uloga']);
            localStorage.setItem('kontaktTelefon', data['kontaktTelefon']);
            localStorage.setItem('datumRodjenja', data['datumRodjenja']);
            localStorage.setItem('email', data['email']);
            localStorage.setItem('aktivan', data['aktivan']);


            var ulogaUlogovanogKorisnika = localStorage.getItem('uloga');
            console.log("Ovo je postavljena uloga ulogovanog korisnika:" + ulogaUlogovanogKorisnika);
            alert("Uloga " + korisnickoIme + " je " + ulogaUlogovanogKorisnika );
            window.location.href = "home.html";
        },
        error: function (data) {
            console.log(data);
            alert("Greska");
        }
    });
});

function formToJSON(korisnickoIme, lozinka) {
    return JSON.stringify(
        {
            "korisnickoIme": korisnickoIme,
            "lozinka": lozinka
        }
    );
}



