<?php

    require_once 'Router.php';

    $router = new Router();

    // Rutas principales
    $router->add('/', 'Paginas@inicio');
    $router->add('/inicio', 'Paginas@inicio');

    $router->add('/ejecutarConsulta', 'ConsultaController@ejecutar');

    // Procesar la solicitud
    $router->dispatch($_SERVER['REQUEST_URI']);
