$(document).ready(function () {
    var ClanDiv = $(".clan");
    var TrenerDiv = $(".trener");
    var AdminDiv = $(".admin");

    var ulogaUlogovanogKorisnika = localStorage.getItem('uloga');
    alert(ulogaUlogovanogKorisnika);

    if(ulogaUlogovanogKorisnika == 'Admin') {
        AdminDiv.show();
        ClanDiv.hide();
        TrenerDiv.hide();
    } else if (ulogaUlogovanogKorisnika == 'Clan') {
        ClanDiv.show();
        AdminDiv.hide();
        TrenerDiv.hide();
    } else {
        TrenerDiv.show();
        ClanDiv.hide();
        AdminDiv.hide();
    }

});