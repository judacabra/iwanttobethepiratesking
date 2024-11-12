$(document).ready(function() {
    const usersTable = document.getElementById('usersTable');
    const tbody = usersTable.getElementsByTagName('tbody')[0];

    const apiService = new ApiService();
    
    apiService.getUsers().then(response => {
        let users = response.userResponse.getListUser; 

        users.forEach(character => {
            const tr = document.createElement('tr');

            const id = document.createElement('td');
            const name = document.createElement('td');
            const username = document.createElement('td');
            const profile = document.createElement('td');

            id.textContent = character.id;
            name.textContent = character.name;
            username.textContent = character.username;
            profile.textContent = character.profile.name;

            tr.append(id);
            tr.append(name);
            tr.append(username);
            tr.append(profile);

            tbody.append(tr);
        });
    }).catch(error => {
        console.error("Error al obtener personajes desde la base de datos:", error);
    });
});