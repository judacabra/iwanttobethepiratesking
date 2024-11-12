<?php

$username_bd = 'jcaicedo';
$password_bd = '1234';

$username_form = $_POST['username'];
$password_form = $_POST['password'];

$status = true;
if ($username_bd != $username_form || $password_bd != $password_form) {
    $status = false;
}

echo json_encode($status);

?>

