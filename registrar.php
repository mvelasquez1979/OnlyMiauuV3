<?php
    if ($_SERVER['REQUEST_METHOD'] == 'POST'){

        require_once("db.php");

        $nombre = $_POST['nombre'];
        $username = $_POST['username'];
        $pwd = $_POST['pwd'];

        $query = "INSERT INTO usuarios (nombre, username, pwd) VALUES ('$nombre', '$username', '$pwd')";

        $result = $mysql->query($query);

        if ($result === TRUE){
            echo "El usuario se registró con exito";
        }else{
            echo "Error";
        }

        $mysql->close();
    }