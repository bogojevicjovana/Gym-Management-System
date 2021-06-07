function formToJSON(id, naziv, opis, tipTreninga, trajanje){
    return JSON.stringify({
        "id": id,
        "naziv": naziv,
        "opis": opis,
        "trajanje": trajanje,
        "tipTreninga": tipTreninga,
    })
}

function formToJSONnaziv(naziv) {
    return JSON.stringify(
        {
            "naziv": naziv

        }
    );
}

function formToJSON3(tipTreninga) {
    return JSON.stringify(
        {
            "tipTreninga": tipTreninga

        }
    );
}

function formToJSON4(opisTr) {
    return JSON.stringify(
        {
            "opis": opisTr

        }
    );
}

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/treninzi/",
        dataType: "json",
        success: function (data) {
            console.log("SUCCESS : ", data);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                $('#treninzi').append(row);
            }
        },
        error: function (data) {
            alert("Greska");
            console.log("ERROR : ", data);
        }
    });
});

//pretraga
$(document).on('click', '#btnSearchNaziv', function () {

    var searchParam = $("#searchPoNazivu").val();
    var myJSON = formToJSONnaziv(searchParam)

    $('#tableSearch').empty();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/treninzi/pretragaPoNazivu",
        dataType: "json",
        contentType: "application/json",
        data: myJSON,
        success: function (data) {
            console.log("SUCCESS: ", data);
            $('#searchPoNazivu').append(searchParam);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                $('#tableSearch').append(row);
            }

        },
        error: function (data) {
            console.log("ERROR: ", data);

        }
    });

});

$(document).on('click', '#btnSearchTip', function () {

    var searchParam = $("#searchPoTipu").val();
    var myJSON = formToJSON3(searchParam)

    $('#tableSearch').empty();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/treninzi/pretragaPoTipu",
        dataType: "json",
        contentType: "application/json",
        data: myJSON,
        success: function (data) {
            console.log("SUCCESS: ", data);
            $('#searchPoTipu').append(searchParam);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                $('#tableSearch').append(row);
            }

        },
        error: function (data) {
            console.log("ERROR: ", data);

        }
    });

});

$(document).on('click', '#btnSearchOpis', function () {

    var searchParam = $("#searchPoOpis").val();
    var myJSON = formToJSON4(searchParam)

    $('#tableSearch').empty();
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/api/treninzi/pretragaPoOpis",
        dataType: "json",
        contentType: "application/json",
        data: myJSON,
        success: function (data) {
            console.log("SUCCESS: ", data);
            $('#searchPoOpis').append(searchParam);
            for (i = 0; i < data.length; i++) {
                var row = "<tr>";
                row += "<td>" + data[i]['id'] + "</td>";
                row += "<td>" + data[i]['naziv'] + "</td>";
                row += "<td>" + data[i]['opis'] + "</td>";
                row += "<td>" + data[i]['tipTreninga'] + "</td>";
                row += "<td>" + data[i]['trajanje'] + "</td>";
                $('#tableSearch').append(row);
            }

        },
        error: function (data) {
            console.log("ERROR: ", data);

        }
    });

});
