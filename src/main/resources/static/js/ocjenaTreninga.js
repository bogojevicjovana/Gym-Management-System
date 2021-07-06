function formToJSON(ocena, idClana, idTreningaOdradjenog) {
    return JSON.stringify(
        {
            "ocena": ocena,
            "idClana": idClana
        }
    );
}

$(document).on("submit", "form", function(event){
    var idTreningaOdradjenog = localStorage.getItem('idZaOcenuTreninga');

    var ocena = $("#ocena").val();
    var idClana = localStorage.getItem('id');

    var JSONValue = formToJSON(ocena, idClana);

    $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/odradjeni/oceni" + idTreningaOdradjenog,
            dataType: "json",
            contentType: "application/json",
            data: JSONValue,
            success: function (data) {
                console.log(data);
                window.location.href = "home.html";
            },
            error: function (data) {
                console.log(data);
                alert("Greska prilikom ocenjivanja treninga!");
            }
    });
});
