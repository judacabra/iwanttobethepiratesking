$(document).ready(function() {
    const crewsTable = document.getElementById('crewsTable');
    const tbody = crewsTable.getElementsByTagName('tbody')[0];

    const apiService = new ApiService();
    
    apiService.getCrews().then(response => {
        let crews = response.crewResponse.getListCrew; 

        crews.forEach(crew => {
            const tr = document.createElement('tr');

            const id = document.createElement('td');
            const name = document.createElement('td');
            const description = document.createElement('td');
            const status = document.createElement('td');
            const number = document.createElement('td');
            const romanName = document.createElement('td');
            const editBtn = document.createElement('td');

            const iEdit = document.createElement('i');
            const iDelete = document.createElement('i');

            iEdit.title = 'Editar';
            iEdit.classList.add('fas', 'fa-edit', 'me-3');
            iEdit.onclick = () => editCrew(crew.id);

            iDelete.title = 'Eliminar';
            iDelete.classList.add('fas', 'fa-trash-alt');
            iDelete.onclick = () => deleteCrew(crew.id);

            id.textContent = crew.id;
            name.textContent = crew.name;
            description.textContent = crew.description;
            status.textContent = crew.status;
            number.textContent = crew.number;
            romanName.textContent = crew.romanName;

            status.classList.add('text-center');
            number.classList.add('text-center');
            romanName.classList.add('text-center');
            editBtn.classList.add('text-center');

            editBtn.append(iEdit);
            editBtn.append(iDelete);

            tr.append(id);
            tr.append(name);
            tr.append(description);
            tr.append(status);
            tr.append(number);
            tr.append(romanName);
            tr.append(editBtn);

            tbody.append(tr);
        });
    }).catch(error => {
        console.error("Error al obtener personajes desde la base de datos:", error);
    });
});

function editCrew(id_crew) { 
    const data = {mode: 'Modificar', id: id_crew};

    $.get("./php/forms/crew.php", data, function(data) {
        $("#container").html(data);
    });
}

function deleteCrew(id_crew) { 
    if (confirm('Seguro que desea eliminar la tripulación?')) {
        const apiService = new ApiService();

        apiService.deleteCrew(id_crew)
        .then(response => {
            getCrewsView();
            alert(response)
        })
        .catch(error => {
            console.error('Error al crear una tripulación:', error);
        });
    }
}

function getCrewsView() { 
    $.get("./html-pages/crew.html", function(data) {
        $("#container").html(data);
    });
}

