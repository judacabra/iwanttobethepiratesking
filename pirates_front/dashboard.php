<!DOCTYPE html>
<html lang="es-CO">
<head>
    <!-- metas -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Aplicación web en la que los usuarios pueden crear su propia tripulación de piratas a partir de personajes de One Piece.">
    <meta name="keywords" content="HTML, CSS, JavaScript, Web Development">
    <meta name="author" content="Julián David Caicedo Bravo">

    <!-- css -->
    <link rel="stylesheet" href="./css/dashboard.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    <!-- favicon -->
    <link rel="shortcut icon" href="img/ico.png" type="image/x-icon">

    <!-- jquery -->
    <script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

    <!-- js -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="./js/api.js"></script>
    <script src="./js/dashboard.js"></script>

    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/6611f780c3.js" crossorigin="anonymous"></script>

    <title> Pirate's King </title>
</head>
<body>
    <nav class="d-flex align-items-center d-flex justify-content-center">
        <div id="logo">
            <img src="./img/ico.png" alt="logo-onepiece" class="w-25 ms-5" title="One Piece">
        </div>
        <div id="nav">       
            <ul class="w-100 d-flex justify-content-around align-items-center">
                <li class="d-flex justify-content-center" id="users-li">
                    <a class="w-100 d-flex justify-content-center align-items-center" id="users"> Usuarios </a>
                </li>
                <li class="d-flex justify-content-center" id="crew-li">
                    <a class="w-100 d-flex justify-content-center align-items-center" id="crew"> Tripulaciones </a>
                </li>
                <li class="d-flex justify-content-center" id="profile-li">
                    <a class="w-100 d-flex justify-content-center align-items-center" id="profile"> Mi perfil </a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container" id="container"></div>
    <footer class="d-flex justify-content-center align-items-center">
        <p class="d-flex justify-content-center align-items-center">
            Aplicación web en la que los usuarios pueden crear su propia tripulación de piratas a partir de personajes de One Piece. 
        </p>
    </footer>
</body>
</html>
