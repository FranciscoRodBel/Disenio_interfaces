<?php
class Database {
    private static $instance = null;
    private $pdo;

    private function __construct() {

        // Configuración de la base de datos
        $host = 'tareaq-tareapp.db.tb-hosting.com';
        $dbName = 'tareaq_tareapp';
        $user = 'tareaq_tareappAdmin';
        $password = 'RSgJW84VtG3BHMq';

        try { // Conexión con la base de datos

            $this->pdo = new PDO(
                "mysql:host=$host;dbname=$dbName;charset=utf8",
                $user,
                $password
            );

            $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

        } catch (PDOException $e) {
            die("Error de conexión: " . $e->getMessage());
        }
    }

    public static function getInstance() { // Si ya hay una instacia devuelve la misma

        if (self::$instance === null) {

            self::$instance = new self();
            
        }

        return self::$instance;
    }

    public function getConnection() { // Devuelve la conexión de la BBDD
        return $this->pdo;
    }
}
