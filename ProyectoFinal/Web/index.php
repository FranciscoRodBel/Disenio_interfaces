<?php

    require_once 'Router.php';

    $router = new Router();

    // Rutas principales
    $router->add('/', 'Paginas@inicio');
    $router->add('/inicio', 'Paginas@inicio');
    
    $router->add('/leerUsuarios', 'UsuarioController@read');
    $router->add('/leerUsuario', 'UsuarioController@readUsuario');
    $router->add('/crearUsuario', 'UsuarioController@create');
    $router->add('/actualizarUsuario', 'UsuarioController@update');
    $router->add('/borrarUsuario', 'UsuarioController@delete');
    
    /*
    $router->add('/admin', 'UsuarioController@acceso');
    $router->add('/admin/iniciosesion', 'UsuarioController@login');
    $router->add('/admin/cerrarsesion', 'UsuarioController@logout');
    $router->add('/admin/actualizarUsuario', 'UsuarioController@update');
    $router->add('/admin/inicio', 'UsuarioController@inicio');
    $router->add('/admin/recogerusuario', 'UsuarioController@recogerUsuario');
    $router->add('/admin/administradores', 'UsuarioController@administradores');
    $router->add('/admin/administradores/mostrarAdmins', 'UsuarioController@read');
    $router->add('/admin/administradores/crearAdmin', 'UsuarioController@create');
    $router->add('/admin/administradores/borrarAdmin', 'UsuarioController@delete');

    $router->add('/admin/inicio/crearNoticia', 'NoticiasController@create');
    $router->add('/admin/inicio/mostrarNoticias', 'NoticiasController@read');
    $router->add('/admin/inicio/recogerNoticia', 'NoticiasController@readPub');
    $router->add('/admin/inicio/actualizarNoticia', 'NoticiasController@update');
    $router->add('/admin/inicio/eliminarNoticia', 'NoticiasController@delete');
    */
    // Procesar la solicitud
    $router->dispatch($_SERVER['REQUEST_URI']);
