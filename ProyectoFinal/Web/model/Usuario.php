<?php
require_once './model/EmptyModel.php';

class Usuario extends EmptyModel {

    protected $table = 'usuario';
    protected $primaryKey = 'email';
    protected $fields = ['contrasenia', 'idioma_seleccionado'];  // Agregamos las propiedades de 'usuario'

    public function __construct() {
        parent::__construct($this->table, $this->primaryKey, $this->fields);
    }

}