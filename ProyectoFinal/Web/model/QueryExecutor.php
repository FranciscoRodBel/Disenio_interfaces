<?php
require_once './config/Database.php';

class QueryExecutor {
    private $db;

    public function __construct() {
        $this->db = Database::getInstance()->getConnection();
    }

    public function ejecutarConsulta($sql, $params = [], $modo = 'consulta') {
        $stmt = $this->db->prepare($sql);

        if (!$stmt->execute($params)) {

            http_response_code(500);
            echo json_encode(['error' => 'Error al ejecutar la consulta']);
            exit();
        }

        switch ($modo) {

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
