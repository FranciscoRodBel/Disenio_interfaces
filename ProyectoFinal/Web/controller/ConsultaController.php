<?php
require_once './model/EjecutaConsulta.php';

class ConsultaController {
    private $CLAVE_SECRETA = 'p3J8K9zFqR2L7vD1mCqT0eB9xW6sYnZ4aF8uRtMqT7gXbN2hL'; // misma clave que en la app

    public function ejecutar() {
        $input = json_decode(file_get_contents("php://input"), true);

        // Valida la clave secreta
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

        // Si todo ha llegado correctamente se recogen los datos y se envían a la función que hará la consulta
        $sql = $input['sql'];
        $modo = $input['modo'];
        $params = $input['params'] ?? [];

        $executor = new EjecutaConsulta();
        $resultado = $executor->ejecutarConsulta($sql, $params, $modo);

        header('Content-Type: application/json');
        echo json_encode($resultado); // La respuesta la devuelvo en un json
        exit();
    }
}
