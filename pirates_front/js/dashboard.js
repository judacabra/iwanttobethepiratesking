$(document).ready(function() {
    const id_crew = getCookie("id_crew");
    const id_profile = getCookie("id_profile");
    
    if (id_profile != 1 ) { /*Admin*/
        $("#users").remove();
        $("#crew").text('Mi tripulación');

        $('#crew').on('click', function(){ editCrew(id_crew); });
    } else {  /*Client*/
        $('#users').on('click', function(){ getUsersView(); });        
        $('#crew').on('click', function(){ getCrewsView(); });
    }

    $('#profile').on('click', function(){ getProfileView(); });
});

function getUsersView() { 
    $.get("./html-pages/users.html", function(data) {
        $("#container").html(data);
    });
}

function getCrewsView() { 
    $.get("./html-pages/crew.html", function(data) {
        $("#container").html(data);
    });
}

function getProfileView(id_profile) {
    const data = {id: id_profile};

    $.get("./php/forms/profile.php", data, function(data) {
        $("#container").html(data);
    });
}

function createCrew() { 
    let data = {mode: 'Crear'};

    $.get("./php/forms/crew.php", data, function(data) {
        $("#container").html(data);
    });
}

function editCrew(id_crew) { 
    const data = {mode: 'Modificar', id: id_crew};

    $.get("./php/forms/crew.php", data, function(data) {
        $("#container").html(data);
    });
}

function logout() {
    if (confirm('¿Seguro que quieres cerrar la sesión?')) {
        window.location.href = 'php/functions/logout.php';
    }
}

function getCookie(name) {
    let cookieArr = document.cookie.split(";");
    
    for (const element of cookieArr) {
        let cookie = element.trim(); 
        
        if (cookie.startsWith(name + "=")) {
            return cookie.substring(name.length + 1);
        }
    }
    
    return null;
}
