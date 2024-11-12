function validarLogin(form) {
    const username = form.username.value.trim();
    const password = form.password.value.trim();

    if (username === '' || password === '') {
        alert('Por favor, ingrese tanto el nombre de usuario como la contraseña.');

        form.username.value = '';
        form.password.value = '';

        return false;
    }

    const data = {
        username: username,
        password: password,
    };

    let status;
    $.post("./php/functions/valida_usuario.php", data, function(result) {
        let response = JSON.parse(result);
        status = response;

        if (!status) {
            alert('Usuario y/o contraseña incorrectos.');

            form.username.value = '';
            form.password.value = '';
        } else {
            window.location.href = './php/functions/login.php';
        }

        return false;
    });   
}