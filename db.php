<?php
    $mysql = new mysqli(
        "localhost",
        "root",
        "",
        "onlymiauu"
    );

    if($mysql->connect_error){
        die("Fallo la conexión a la BBDD" . $mysql->connect_error);
    }/*else{ -- lo eliminamos porque ya no lo vamos a necesitar, pero lo dejamos comentado mientras
        echo "Conexion a BBDD exitosa";
    }*/