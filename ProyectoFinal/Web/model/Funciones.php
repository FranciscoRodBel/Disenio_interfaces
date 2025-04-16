<?php

    class Funciones {

        public static function verificarAutenticacion() {

            $headers = getallheaders();

            if (!isset($headers['Authorization']) || $headers['Authorization'] !== 'Bearer sk_live_p3J8K9zFqR2L7vD1mCqT0eB9xW6sYnZ4aF8uRtMqT7gXbN2hL') {

                header('HTTP/1.1 401 Unauthorized');
                echo json_encode(['error' => 'No autorizado']);
                exit();
            }
        }
    }