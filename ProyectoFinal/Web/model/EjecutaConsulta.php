<?php
require_once './config/Database.php';

class EjecutaConsulta { // Clase que ejecutará las consultas de la app con la BBDD
    private $db; // Conexión a la base de datos

    public function __construct() {
        $this->db = Database::getInstance()->getConnection(); // Establece conexión con la BBDD
    }

    public function ejecutarConsulta($sql, $params = [], $modo = 'consulta') { // Recibe la consulta, el modo y los parametros
        
        $stmt = $this->db->prepare($sql); // Prepara la consulta

        if (!$stmt->execute($params)) { // Ejecuta la consulta

            http_response_code(500);
            echo json_encode(['error' => 'Error al ejecutar la consulta']);
            exit();
        }

        switch ($modo) { // Dependiendo del modo, devuelve los datos(consulta) o un verdadero o falso

            case 'consulta':
                return $stmt->fetchAll(PDO::FETCH_ASSOC);
            case 'insertar':
            case 'actualizar':
            case 'borrar':
                return ['filas_afectadas' => $stmt->rowCount()];
            default:
                return [];
        }
    }
}
