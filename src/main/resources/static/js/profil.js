$(document).ready(function () {

    var idUlogKor = localStorage.getItem('id');


    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/korisnici/" + idUlogKor,
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            $('#id').append(data['id']);
            $('#korisnickoIme').append(data['korisnickoIme']);
            $('#lozinka').append(data['lozinka']);
            $('#ime').append(data['ime']);
            $('#prezime').append(data['prezime']);
            $('#kontaktTelefon').append(data['kontaktTelefon']);
            $('#email').append(data['email']);
            $('#datumRodjenja').append(data['datumRodjenja']);



            var korisniciDiv = $("#profil-korisnika");              // dobavi element čiji je id = oneEmployee
            korisniciDiv.show();                               // prikaži taj element
          },
          error: function (data) {
               console.log("ERROR : ", data);
          }
    });
});