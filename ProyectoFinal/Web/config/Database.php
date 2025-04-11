<?php
class Database {
    private static $instance = null;
    private $pdo;

    private function __construct() {

        $host = 'tareapp-1.crwyy0o20y2n.eu-north-1.rds.amazonaws.com';
        $dbName = 'tareapp_bbdd';
        $user = 'admin_tareapp';
        $password = 'RSgJW84VtG3BHMq';

        try {

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

    public static function getInstance() {

        if (self::$instance === null) {

            self::$instance = new self();
            
        }

        return self::$instance;
    }

    public function getConnection() {
        return $this->pdo;
    }
}
