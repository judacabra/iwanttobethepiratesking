<?php
    $profiles = array(
        array(
            'id' => 1, 
            'name' => 'Administrador',
        ),
        array(
            'id' => 2, 
            'name' => 'Cliente',
        ),
    );
?>
<!DOCTYPE html>
<html lang="es-CO">
<head>
    <script src="./js/profile.js"></script>

    <title> Perfil </title>
</head>
<body>
    <form class="d-flex flex-column align-items-center w-100">
        <div class="mb-3  w-50">
            <label for="name" class="form-label"> Nombre Completo </label>
            <input type="text" name="name" id="name" class="form-control" required placeholder="Ejemplo: Oscar Perez" value="<?= $user['name'] ?>">
        </div>
        <div class="mb-3  w-50">
            <label for="username" class="form-label"> Nombre de usuario </label>
            <input type="text" name="username" id="username" class="form-control" required placeholder="Ejemplo: OPerez" value="<?= $user['username'] ?>">
        </div>
        <div class="mb-4  w-50">
            <label for="username" class="form-label"> Perfil </label>
            <select class="form-select" id="profile" name="profile">
                <option disabled> Selecciona un perfil </option>
                <?php
                    $option = '';
                    foreach ($profiles as $profile => $key){
                        $option .= "<option value='".$key['id']."'>".$key['name']."</option>";
                    }
    
                    echo $option;
                ?>
            </select>
        </div>
        <div class="d-flex justify-content-center w-50">
            <input type="button" class="btn btn-danger" value="Cerrar Sesión" onclick="logout()">
            <input type="hidden" name="id" value="<?=$user['id']?>">
        </div>
    </form>
</body>
</html>
