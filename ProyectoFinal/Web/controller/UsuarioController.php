<?php
    require_once('./model/Usuario.php');

    class UsuarioController {

        private $usuarioModel;

        public function __construct() {
            $this->usuarioModel = new Usuario();
        }

        private function responseJson($resultado) {
            
            header('Content-Type: application/json');
            echo json_encode(compact('resultado'));
            exit();
        }  

        public function read() {

            $usuarios = $this->usuarioModel->getAll(); // Obtiene todos los administradores
        
            return $usuarios;
        } 
        
        public function create() {

            $input = json_decode(file_get_contents("php://input"), true);
            
            $resultado = $this->usuarioModel->create([
                'email' => $input['email'],
                'contrasenia' => $input['contrasenia'],
                'idioma_seleccionado' => $input['idioma_seleccionado']
            ]);
        
            $this->responseJson($resultado);
        }

        public function update() {
            
            $input = json_decode(file_get_contents('php://input'), true); // Leer los datos enviados en la petición
        
            $updateData = [
                'email' => $input['email'],
                'contrasenia' => $input['contrasenia'],
                'idioma_seleccionado' => $input['idioma_seleccionado']
            ];
            
            $resultado = $this->usuarioModel->update($updateData, $input['id']); // Realiza la actualización
        
            $this->responseJson($resultado);
        }                 
        
        public function delete() {

            $input = json_decode(file_get_contents('php://input'), true); // Leer los datos enviados en la petición
        
            $resultado = $this->usuarioModel->delete($input['id']); // Intentar eliminar el usuario
        
            $this->responseJson($resultado);
        }
    }
?>