<?php

session_destroy();

setcookie("id_profile", "", time() - 3600, "/");
setcookie("id_crew", "", time() - 3600, "/");
setcookie("id_user", "", time() - 3600, "/");

header('Location: ../../index.html');
die();

?>

