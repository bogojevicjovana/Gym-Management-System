function check1() {
    var checkBox = document.getElementById("inline1");
    var tekst = document.getElementById("naziv");

    if (checkBox.checked === true) {
        tekst.style.display = "inline";
    } else {
        tekst.style.display = "none";
    }
}

function check2() {
    var checkBox = document.getElementById("inline2");
    var tekst = document.getElementById("brTelefonaCentrale");

    if (checkBox.checked === true) {
        tekst.style.display = "inline";
    } else {
        tekst.style.display = "none";
    }
}

function check3() {
    var checkBox = document.getElementById("inline3");
    var tekst = document.getElementById("adresa");

    if (checkBox.checked === true) {
        tekst.style.display = "inline";
    } else {
        tekst.style.display = "none";
    }
}

function check4() {
    var checkBox = document.getElementById("inline4");
    var tekst = document.getElementById("email");

    if (checkBox.checked === true) {
        tekst.style.display = "inline";
    } else {
        tekst.style.display = "none";
    }
}