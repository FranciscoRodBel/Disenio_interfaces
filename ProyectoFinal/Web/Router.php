<?php
    class Router {
        private $routes = [];

        /**
         * Agregar una ruta al enrutador.
         *
         * @param string $path Ruta (ejemplo: '/about').
         * @param string $controllerAction Controlador y método (ejemplo: 'HomeController@about').
         */
        public function add(string $path, string $controllerAction): void {
            $this->routes[$path] = $controllerAction;
        }

        /**
         * Procesar la solicitud y despachar la ruta correspondiente.
         *
         * @param string $requestUri URI solicitado (ejemplo: '/about').
         */
        public function dispatch(string $requestUri): void {

            $path = parse_url($requestUri, PHP_URL_PATH);

            $scriptName = dirname($_SERVER['SCRIPT_NAME']);
            $route = '/' . trim(str_replace($scriptName, '', $path), '/');
            $route = '/' . ltrim($route, '/');        

            if (isset($this->routes[$route])) {

                $controllerAction = $this->routes[$route];

                $this->executeAction($controllerAction);

            } else {

                $this->handleNotFound();
            }
        }

        /**
         * Ejecutar el método del controlador correspondiente.
         *
         * @param string $controllerAction Controlador y método (ejemplo: 'HomeController@index').
         */
        private function executeAction(string $controllerAction): void {

            list($controllerName, $methodName) = explode('@', $controllerAction);

            $controllerFile = __DIR__ . '/controller/' . $controllerName . '.php';

            if (file_exists($controllerFile)) {

                require_once $controllerFile;

                if (class_exists($controllerName)) {

                    $controller = new $controllerName();

                    if (method_exists($controller, $methodName)) {

                        $controller->$methodName();

                    } else {

                        $this->handleNotFound();
                    }

                } else {

                    $this->handleNotFound();
                }

            } else {

                $this->handleNotFound();
            }
        }

        /**
         * Manejar rutas no encontradas (404).
         */
        private function handleNotFound(): void {
        
            header("Location: /ProyectoFinal/Web/inicio");
            exit();
        }
    }

?>