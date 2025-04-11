<?php
require_once './model/EmptyModel.php';

class Lista extends EmptyModel {

    protected $table = 'lista';
    protected $primaryKey = 'idLista';
    protected $fields = ['titulo', 'email'];  // Agregamos las propiedades de 'lista'

    public function __construct() {
        parent::__construct($this->table, $this->primaryKey, $this->fields);
    }

}