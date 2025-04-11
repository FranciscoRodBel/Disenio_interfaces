<?php
require_once './model/EmptyModel.php';

class Tarea extends EmptyModel {

    protected $table = 'tarea';
    protected $primaryKey = 'idTarea';
    protected $fields = ['completada', 'titulo', 'prioridad', 'fecha', 'descripcion', 'idLista'];  // Agregamos las propiedades de 'tarea'

    public function __construct() {
        parent::__construct($this->table, $this->primaryKey, $this->fields);
    }

}