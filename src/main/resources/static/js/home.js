function formToJSON(imetr, prezimetr, korisnicko, kontaktTel, datumRodj, emailad){
    return JSON.stringify({
        "ime": imetr,
        "prezime": prezimetr,
        "korisnickoIme": korisnicko,
        "kontaktTelefon": kontaktTel,
        "datumRodjenja": datumRodj,
        "email": emailad,
    })
}

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treneri//dobavi-trenere",
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['ime'] + "</td>";
                row += "<td>" + data[i]['prezime'] + "</td>";
                row += "<td>" + data[i]['korisnickoIme'] + "</td>";
                row += "<td>" + data[i]['kontaktTelefon'] + "</td>";
                row += "<td>" + data[i]['datumRodjenja'] + "</td>";
                row += "<td>" + data[i]['email'] + "</td>";
                $('#treneri').append(row);
            }
        },
    });
});
