$(document).on("submit", "form", function(event){
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
            localStorage.setItem('uloga', data['uloga']);
            window.location.href = "home.html";
        },
        error: function (data) {
            console.log(data);
            alert("Vas profil nije aktiviran ili ste uneli pogresne podatke!");
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



