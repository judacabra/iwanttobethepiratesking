$(document).ready(function() {
    const name = document.getElementById('name');
    const username = document.getElementById('username');
    const profile = document.getElementById('profile');

    const id_user = getCookie('id_user');

    const apiService = new ApiService();
    
    apiService.getUserById(id_user).then(response => {
        let user = response.userResponse.getUser; 

        name.value = user.name;
        username.value = user.username;
        profile.value = user.profile;
    }).catch(error => {
        console.error("Error al obtener personajes desde la base de datos:", error);
    });
});