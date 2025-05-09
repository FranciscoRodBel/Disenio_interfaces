<?php
require_once './model/QueryExecutor.php';

class ConsultaController {
    private $CLAVE_SECRETA = 'p3J8K9zFqR2L7vD1mCqT0eB9xW6sYnZ4aF8uRtMqT7gXbN2hL'; // misma clave que en la app

    public function ejecutar() {
        $input = json_decode(file_get_contents("php://input"), true);

        // Validar clave secreta
        if (!isset($input['clave_secreta']) || $input['clave_secreta'] !== $this->CLAVE_SECRETA) {

            http_response_code(403); // Prohibido
            echo json_encode(['error' => 'Acceso no autorizado']);
            exit();
        }

        // Validación de parámetros
        if (!isset($input['sql']) || !isset($input['modo'])) {

            http_response_code(400);
            echo json_encode(['error' => 'Faltan parámetros']);
            exit();
        }

        $sql = $input['sql'];
        $modo = $input['modo'];
        $params = $input['params'] ?? [];

        $executor = new QueryExecutor();
        $resultado = $executor->ejecutarConsulta($sql, $params, $modo);

        header('Content-Type: application/json');
        echo json_encode($resultado);
        exit();
    }
}
