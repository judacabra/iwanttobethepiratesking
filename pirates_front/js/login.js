function validarLogin(event, form) {
    event.preventDefault();

    const username = form.username.value.trim();
    const password = form.password.value.trim();

    if (username === '' || password === '') {
        alert('Por favor, ingrese tanto el nombre de usuario como la contraseña.');

        form.username.value = '';
        form.password.value = '';

        return false;
    }

    const loginData = {
        username: username,
        password: password,
    };

    const apiService = new ApiService();

    apiService.login(loginData)
    .then(response => {
        if (response){
            $.post("./php/functions/valida_usuario.php", loginData, function() {
                window.location.href = './php/functions/login.php';
            });   
        } else {
            alert('Error: Nombre de usuario y/o contraseña invalidos.');

            form.username.value = '';
            form.password.value = '';
        }
    })
    .catch(error => {
        console.error('Error al iniciar sesion:', error);
    });

    
}