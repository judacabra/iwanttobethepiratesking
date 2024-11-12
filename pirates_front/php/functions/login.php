<?php

session_start();

$id_profile = 1;
$id_crew = 1;
$id_user = 1;

$_SESSION['id_profile'] = $id_profile;
$_SESSION['id_crew'] = $id_crew;
$_SESSION['id_user'] = $id_user;

setcookie("id_profile", $id_profile, time() + 3600, "/");
setcookie("id_crew", $id_crew, time() + 3600, "/");
setcookie("id_user", $id_user, time() + 3600, "/");

header('Location: ../../dashboard.php');
die();

?>

