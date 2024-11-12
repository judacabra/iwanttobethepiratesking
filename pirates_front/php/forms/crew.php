<?php

$mode = !empty($_GET['mode']) ? $_GET['mode'] : null;
$id = !empty($_GET['id']) ? $_GET['id'] : null;

?>

<!DOCTYPE html>
<html lang="es-CO">
<head>    
    <script src="./js/crewForm.js"></script>

    <title> <?=$mode?> Tripulación </title>
</head>
<body>
    <h2 class="text-center mb-4"> <?=$mode?> Tripulación </h2>
    <div class="d-flex">
        <form class="w-50" id="crewForm">
            <div class="d-flex flex-column mx-2" id="form">
                <div class="row">
                    <div class="col-md-6 mb-2 w-75">
                        <label for="name" class="form-label"> Nombre de Tripulación </label>
                        <input type="text" name="name" id="name" class="form-control" required>
                    </div>
                    <div class="col-md-6 mb-2 w-25">
                        <label for="status" class="form-label"> Estado </label>
                        <select name="status" class="form-select" aria-label="Default select example" id="status">
                            <option disabled selected></option>
                            <option value="assets"> Activo </option>
                            <option value="unknown"> Desconocido </option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-2 w-75">
                        <label for="romanName" class="form-label"> Nombre romano </label>
                        <input type="text" name="romanName" id="romanName" class="form-control" required>
                    </div>
                    <div class="col-md-6 mb-2 w-25">
                        <label for="number" class="form-label"> <small> N.o de tripulantes </small> </label>
                        <input type="number" name="number" id="number" class="form-control text-center" min="0" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 mb-3 w-50">
                        <label for="description" class="form-label"> Descripción </label>
                        <textarea type="text" name="description" id="description" class="form-control" required></textarea>
                    </div>
                    <div class="col-md-4 mb-3 w-25">
                        <label for="flag" class="form-label"> Bandera </label>
                        <div id="flag" data-bs-toggle="modal" data-bs-target="#modal-flag"></div>
                        <input type="hidden" name="flagSelected" id="flagSelected">
                    </div>
                    <div class="col-md-4 mb-3 w-25">
                        <label for="ship" class="form-label"> Barco </label>
                        <div id="ship" data-bs-toggle="modal" data-bs-target="#modal-ship"></div>
                        <input type="hidden" name="shipSelected" id="shipSelected">
                    </div>
                </div>
            </div>
            <div class="d-flex justify-content-center">
                <input type="submit" class="btn btn-primary" id="action" value="<?=$mode?>">
                <input type="hidden" name="id" id="id" value="<?=$id?>">
            </div>
        </form>
        <div id="div-table" class="w-50 mx-2">
            <div class="col-md-6 ps-3 h-300 w-100 d-flex flex-column align-items-center">
                <label for="table" class="form-label w-100 d-flex justify-content-between"> 
                    Tripulantes 
                    <button class="btn btn-primary ms-3 d-none" id="btn-add-character" data-bs-toggle="modal" data-bs-target="#new-character"> 
                        Nuevo 
                        <i class="fas fa-plus ms-3"></i> 
                    </button>
                </label>
                <table class="table" id="charactersTable">
                    <thead>
                        <tr>
                            <th scope="col"> ID </th>
                            <th scope="col"> Nombre </th>
                            <th scope="col" class="text-center"> Edad </th>
                            <th scope="col"> Trabajo </th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- Modal New Character -->
    <div id="new-character" class="modal fade" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title fs-5" id="exampleModalLabel"> Nuevo personaje </h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="add-character">
                    <div class="mb-2">
                        <label for="from" class="form-label"> De donde quieres agregar tu nuevo tripulante?  </label>
                        <select name="from" class="form-select" id="from">
                            <option disabled selected> </option>
                            <option value="1"> Creado (Base de datos) </option>
                            <option value="2"> API </option>
                        </select>
                    </div>
                    <div class="mb-2 d-none div-character_bd">
                        <label for="name" class="form-label"> Nombre </label>
                        <select name="character_bd" class="form-select" id="character_bd">
                            <option disabled selected> </option>
                        </select>
                    </div>
                    <div class="mb-2 d-none div-character_api">
                        <label for="name" class="form-label"> Nombre </label>
                        <select name="character_api" class="form-select" id="character_api">
                            <option disabled selected> </option>
                        </select>
                    </div>
                    <div class="mb-2">
                        <label for="age" class="form-label"> Edad </label>
                        <input type="text" name="age" id="age" class="form-control" readonly required>
                    </div>
                    <div class="mb-2">
                        <label for="job" class="form-label"> Trabajo </label>
                        <input type="text" name="job" id="job" class="form-control" readonly required>
                    </div>
                    <div class="mb-2">
                        <input type="hidden" name="id_crew" id="id_crew" class="form-control" value="<?=$id?>" readonly required>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> Cancelar </button>
                <input type="submit" class="btn btn-primary" data-bs-dismiss="modal" id="add" value="Agregar">
            </div>
            </div>
        </div>
    </div>

    <!-- Modal New Flag Crew -->
    <div id="modal-flag" class="modal fade" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title fs-5" id="exampleModalLabel"> Escoger Bandera </h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="add-character">
                    <div class="mb-2">
                        <label for="myflag" class="form-label"> Bandera  </label>
                        <select name="myflag" class="form-select" id="myflag">
                            <option disabled selected> </option>
                            <option value="./img/flag1.png"> Bandera 1 </option>
                            <option value="./img/flag2.png"> Bandera 2 </option>
                            <option value="./img/flag3.png"> Bandera 3 </option>
                            <option value="./img/flag4.png"> Bandera 4 </option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> Cancelar </button>
                <input type="submit" class="btn btn-primary" data-bs-dismiss="modal" id="add" value="Agregar">
            </div>
            </div>
        </div>
    </div>

    <!-- Modal New Ship Crew -->
    <div id="modal-ship" class="modal fade" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
            <div class="modal-header">
                <h2 class="modal-title fs-5" id="exampleModalLabel"> Escoger Barco </h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="add-character">
                    <div class="mb-2">
                        <label for="myship" class="form-label"> Barco  </label>
                        <select name="myship" class="form-select" id="myship">
                            <option disabled selected> </option>
                            <option value="./img/ship1.png"> Barco 1 </option>
                            <option value="./img/ship2.png"> Barco 2 </option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> Cancelar </button>
                <input type="submit" class="btn btn-primary" data-bs-dismiss="modal" id="add" value="Agregar">
            </div>
            </div>
        </div>
    </div>
</body>
</html>
