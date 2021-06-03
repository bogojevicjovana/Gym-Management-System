//Sort
function sort() {
    var filter = document.getElementsByName("filterS");

    if (filter[0].checked) {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/treninzi/sort/naziv/",
            dataType: "json",
            success: function (data) {
                $('#treninzi').empty();
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
            }

        });
    } else {
        if (filter[1].checked) {
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/api/treninzi/sort/opis/",
                dataType: "json",
                success: function (data) {
                    $('#treninzi').empty();
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
                }

            });
        } else {
            if (filter[2].checked) {
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/api/treninzi/sort/tiptreninga/",
                    dataType: "json",
                    success: function (data) {
                        $('#treninzi').empty();
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
                    }

                });
            }
        }
    }
}