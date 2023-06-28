var header = document.getElementById("header");
var mobileMenu = document.getElementById("navbar-mobile");
var baricon = document.getElementById("bar-icon");
var closeicon = document.getElementById("closebar-icon");

var baricon2 = document.getElementById("bar-icon2");
var closeicon2 = document.getElementById("closebar-icon2");

var navbar = document.getElementById("navbar");
var alert = document.getElementById("alert");
var shoptitlebtn = document.getElementById("shoptitlebtn");
var dropdownToggles = document.querySelectorAll(".dropdown-toggle");
var dropdownContents = document.querySelectorAll(".dropdown-content");
var dropdownLinks = document.querySelectorAll(".dropdown-content a");

for (var i = 0; i < dropdownToggles.length; i++) {
    dropdownToggles[i].addEventListener("click", function (e) {
        var toggle = e.target;
        var content = toggle.nextElementSibling;
        if (content.style.display === "block") {
            content.style.display = "none";
        } else {
            content.style.display = "block";
        }
    });
}

for (var i = 0; i < dropdownLinks.length; i++) {
    dropdownLinks[i].addEventListener("click", function () {
        for (var j = 0; j < dropdownContents.length; j++) {
            dropdownContents[j].style.display = "none";
        }
    });
}

window.addEventListener("click", function (event) {
    for (var i = 0; i < dropdownContents.length; i++) {
        if (!event.target.matches(".dropdown-toggle") && !event.target.matches(".dropdown-content a")) {
            dropdownContents[i].style.display = "none";
        }
    }
});

function previewImage() {
    const imgUrl = document.getElementById("img-url").value;
    const preview = document.getElementById("preview");
    if (imgUrl) {
        preview.setAttribute("src", imgUrl);
    }
}

function openmenu() {
    mobileMenu.style.display = "block";
    baricon.style.display = "none";
    closeicon.style.display = "block";
}

function closemenu() {
    mobileMenu.style.display = "none";
    baricon.style.display = "block";
    closeicon.style.display = "none";
}

function opennavbar() {
    navbar.style.display = "flex";
    baricon.style.display = "none";
    closeicon.style.display = "block";
}

function closenavbar() {
    navbar.style.display = "none";
    baricon.style.display = "block";
    closeicon.style.display = "none";
}

function openfunctionnav() {
    shoptitlebtn.style.display = "flex";
    baricon2.style.display = "none";
    closeicon2.style.display = "block";
}

function closefunctionnav() {
    shoptitlebtn.style.display = "none";
    baricon2.style.display = "block";
    closeicon2.style.display = "none";
}



