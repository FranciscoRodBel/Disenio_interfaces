<?php
require_once './config/Database.php';

class EmptyModel {
    protected $db;
    protected $table;
    protected $primaryKey;

    public function __construct($table, $primaryKey = 'id') {
        $this->db = Database::getInstance()->getConnection();
        $this->table = $table;
        $this->primaryKey = $primaryKey;
    }

    public function query($sql, $params = []) {
        $stmt = $this->db->prepare($sql);
        $stmt->execute($params);
        return $stmt;
    }

    // Obtener todos los registros
    public function getAll() {

        $sql = "SELECT * FROM {$this->table}";
        return $this->query($sql)->fetchAll(PDO::FETCH_ASSOC);
    }

    // Obtener un registro por clave primaria
    public function getById($id) {
        
        $sql = "SELECT * FROM {$this->table} WHERE {$this->primaryKey} = ?";
        return $this->query($sql, [$id])->fetch(PDO::FETCH_ASSOC);
    }
        
    // Recoger el usuario de la bbdd
    public function getByUser($usuario) {

        $sql = "SELECT * FROM users WHERE usuario = ?";
        return $this->query($sql, [$usuario])->fetch(PDO::FETCH_ASSOC);
    }

    // Comprobar si el email está registrado
    public function isFieldRegister($field, $value, $id = null) {
    
        if ($id) {

            $sql = "SELECT 1 FROM {$this->table} WHERE {$field} = ? AND id != ? LIMIT 1";
            $resultado = $this->query($sql, [$value, $id]);

        } else {
            
            $sql = "SELECT 1 FROM {$this->table} WHERE {$field} = ? LIMIT 1";
            $resultado = $this->query($sql, [$value]);
        }
    
        return $resultado->rowCount() > 0;
    }

    // Crear un nuevo registro
    public function create($data) {

        $fields = implode(', ', array_keys($data));
        $placeholders = implode(', ', array_fill(0, count($data), '?'));
        $sql = "INSERT INTO {$this->table} ({$fields}) VALUES ({$placeholders})";
        $this->query($sql, array_values($data));

        return $this->db->lastInsertId();
    }

    // Actualizar un registro por clave primaria
    public function update($data, $id) {

        $setClause = implode(', ', array_map(fn($field) => "{$field} = ?", array_keys($data)));
        $sql = "UPDATE {$this->table} SET {$setClause} WHERE {$this->primaryKey} = ?";
        
        return $this->query($sql, array_merge(array_values($data), [$id]))->rowCount() > 0;
    }


    // Eliminar un registro por clave primaria
    public function delete($id) {

        $sql = "DELETE FROM {$this->table} WHERE {$this->primaryKey} = ?";
        $resultado = $this->query($sql, [$id]);
    
        // Si se ejecutó correctamente, la consulta devuelve el número de filas afectadas
        return $resultado; // Si se eliminaron filas, es true, si no, es false
    }    
}
?>