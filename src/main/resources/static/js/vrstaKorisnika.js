$(document).ready(function () {
    var ClanDiv = $(".clan");
    var TrenerDiv = $(".trener");
    var AdminDiv = $(".admin");

    ClanDiv.hide();
    ClanDiv.hide();
    AdminDiv.hide();


    var ulogaUlogovanogKorisnika = localStorage.getItem('uloga');
    alert(ulogaUlogovanogKorisnika);
    if (ulogaUlogovanogKorisnika === 'Clan') {
         CLanDiv.show();
    } else {
         if (ulogaUlogovanogKorisnika === 'Trener') {
             TrenerDiv.show();
         } else
             AdminDiv.show();
    }
    });