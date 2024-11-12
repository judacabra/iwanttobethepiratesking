$(document).ready(function() {
    const idValue = document.getElementById('id').value;
    const action = document.getElementById('action');
    const idUser = getCookie('id_user');
    const crewForm = document.getElementById('crewForm');
    
    // Tripulación - Crew
    const name = document.getElementById('name');
    const romanName = document.getElementById('romanName');
    const description = document.getElementById('description');
    const status = document.getElementById('status');
    const number = document.getElementById('number');
    const divship = document.getElementById('ship');
    const myship = document.getElementById('myship');
    const divflag = document.getElementById('flag');
    const myflag = document.getElementById('myflag');
    const flagSelected = document.getElementById('flagSelected');
    const shipSelected = document.getElementById('shipSelected');

    // Tripulantes - Characters
    const charactersTable = document.getElementById('charactersTable');
    const tbody = charactersTable.getElementsByTagName('tbody')[0];
    const selectBd = document.getElementById('character_bd');
    const selectApi = document.getElementById('character_api');
    const from = document.getElementById('from');
    const btnOpenModal = document.getElementById('btn-add-character');
    const addBtn = document.getElementById('add');

    // Contador de tripulantes por crew
    number.value = tbody.getElementsByTagName('tr').length;

    const apiService = new ApiService();

    if (action.value == 'Modificar') {
        btnOpenModal.classList.remove('d-none');

        apiService.getCrewById(idValue).then(response => {
            const crew = response.crewResponse.crew; 

            name.value = crew.name;       
            romanName.value = crew.romanName;
            description.value = crew.description;
            status.value = crew.status;
            number.value = crew.number;

            divship.style.backgroundImage = `url(${crew.ship})`;
            divship.style.backgroundSize = 'cover';
            shipSelected.value = myship.value;

            divflag.style.backgroundImage = `url(${crew.flag})`;
            divflag.style.backgroundSize = 'cover';
            flagSelected.value = myflag.value;
        }).catch(error => {
            console.error("Error al obtener la tripulacion desde la base de datos:", error);
        });
    } else {
        btnOpenModal.classList.add('d-none');
    }

    myship.addEventListener('change', function(){
        let shipImg = `${myship.value}`;

        divship.style.backgroundImage = `url(${shipImg})`;
        divship.style.backgroundSize = 'cover';

        shipSelected.value = myship.value;
    });

    myflag.addEventListener('change', function(){
        let flagImg = `${myflag.value}`;

        divflag.style.backgroundImage = `url(${flagImg})`;
        divflag.style.backgroundSize = 'cover';

        flagSelected.value = myflag.value;
    });

    crewForm.addEventListener('submit', function(event){
        event.preventDefault();  
        
        const crewData = {
            id: idValue,
            name: crewForm.name.value,
            romanName: crewForm.romanName.value,
            description: crewForm.description.value,
            status: crewForm.status.value,
            number: parseInt(crewForm.number.value),
            flag: crewForm.flagSelected.value,
            ship: crewForm.shipSelected.value,
            createdBy: parseInt(idUser),
            createdDate: new Date().toISOString(),
        };
    
        if (action.value == 'Crear') {
            apiService.insertCrew(crewData)
            .then(response => {
                console.log(response);
                alert('Tripulacion insertada exitosamente.');

                getCrewsView();
            })
            .catch(error => {
                console.error('Error al crear una tripulación:', error);
            });
        }

        if (action.value == 'Modificar') {
            apiService.updateCrew(crewData)
            .then(response => {
                console.log(response);
                alert('Tripulacion modificada exitosamente.');

                getCrewsView();
            })
            .catch(error => {
                console.error('Error al crear una tripulación:', error);
            });
        }
    });

    apiService.getCharactersByCrew(idValue).then(response => {
        let charactersCrew = response.characterResponse.getListCharacter; 

        charactersCrew.forEach(characterCrew => {
            const tr = document.createElement('tr');

            const id = document.createElement('td');
            const name = document.createElement('td');
            const age = document.createElement('td');
            const job = document.createElement('td');

            id.textContent = characterCrew.id;
            name.textContent = characterCrew.name;
            age.textContent = characterCrew.age;
            job.textContent = characterCrew.job;

            age.classList.add('text-center');

            tr.append(id);
            tr.append(name);
            tr.append(age);
            tr.append(job);

            tbody.append(tr);
        });
    }).catch(error => {
        console.error("Error al obtener personajes desde la base de datos:", error);
    });
    
    apiService.getCharactersFromBD().then(response => {
        let characters = response.characterResponse.getListCharacter; 

        characters.forEach(character => {
            const option = document.createElement('option');
            option.value = character.id;
            option.text = character.name;

            selectBd.append(option);
        });
    }).catch(error => {
        console.error("Error al obtener personajes desde la base de datos:", error);
    });

    apiService.getCharactersFromAPI().then(response => {
        let characters = response;

        characters.forEach(character => {
            const option = document.createElement('option');
            option.value = character.id;
            option.text = character.name;

            selectApi.append(option);
        });
    }).catch(error => {
        console.error("Error al obtener personajes desde la API de one piece:", error);
    });

    from.addEventListener('change', function(){
        const divSelectBd = document.querySelector('.div-character_bd');
        const divSelectApi = document.querySelector('.div-character_api');

        const age = document.getElementById('age');
        const job = document.getElementById('job');

        selectBd.value = '';
        selectApi.value = '';
        age.value = ''; 
        job.value = ''; 

        if (from.value == 1) {
            divSelectBd.classList.remove('d-none');
            divSelectApi.classList.add('d-none');
        } else {
            divSelectBd.classList.add('d-none');
            divSelectApi.classList.remove('d-none');
        }         
    })

    selectBd.addEventListener('change', function(){
        getCharacterById(apiService, 'bd', selectBd.value);        
    });

    selectApi.addEventListener('change', function(){
        getCharacterById(apiService, 'api', selectApi.value);        
    });

    addBtn.addEventListener('click', function(event){
        event.preventDefault();  
        const form = document.getElementById('add-character');

        validarCharacter(form);
    });
});

function validarCharacter(form) {
    const apiService = new ApiService();

    let idSelector;
    if (form.from == 1) {
        idSelector = 'character_bd';
    } else {
        idSelector = 'character_api';
    }

    const selectElement = document.getElementById(idSelector);
    const selectedOption = selectElement.options[selectElement.selectedIndex];
    
    const name = selectedOption.textContent;
    const age = form.age.value;
    const job = form.job.value;
    const id_crew = form.id_crew.value;

    const characterData = {
        name : name,
        age : age,
        job : job,
        crew: { id: parseInt(id_crew) },
        createdBy: parseInt(getCookie('id_user')),
        createdDate: new Date().toISOString(),
    };

    apiService.insertCharacter(characterData)
        .then(response => {
            editCrew(id_crew);
        })
        .catch(error => {
            console.error('Error al crear una tripulación:', error);
        });
}

function getCharacterById(apiService, from, id) {
    const age = document.getElementById('age');
    const job = document.getElementById('job');

    if (from == 'bd') {
        apiService.getCharacterByIdFromBD(id).then(response => {    
            age.value = response.characterResponse.getListCharacter.age;
            job.value = response.characterResponse.getListCharacter.job;
        }).catch(error => {
            console.error("Error al obtener la info del personaje desde la base de datos:", error);
        });
    }

    if (from == 'api') {
        apiService.getCharacterByIdFromAPI(id).then(response => {
            age.value = response.age;
            job.value = response.job;
        }).catch(error => {
            console.error("Error al obtener la info del personaje desde la API de one piece:", error);
        });
    }    
}

function getCrewsView() { 
    $.get("./html-pages/crew.html", function(data) {
        $("#container").html(data);
    });
}