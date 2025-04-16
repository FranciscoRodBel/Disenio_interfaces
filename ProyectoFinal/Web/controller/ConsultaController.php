<?php
require_once './model/QueryExecutor.php';
require_once './model/Funciones.php';

class ConsultaController {
    public function ejecutar() {

        Funciones::verificarAutenticacion();

        $input = json_decode(file_get_contents("php://input"), true);

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
