package com.proyectogrupo8;

import java.util.Scanner;

/**
 *
 * @author willi
 */
public class FlujoJuego {

    private ColaJugadores colaJugadores;
    private PilaPremios pilaPremios;
    private PilaCastigos pilaCastigos;
    private Scanner scanner;

    /**
     * constructor encargado de inicializar las instancias de otras clases
     * tambien inicializa el metodo Scanner para el input del usuario
     * Carga las Pilas de premios y castigos con sus respectivos elementos
     */
    public FlujoJuego() {
        this.colaJugadores = new ColaJugadores();
        this.pilaPremios = new PilaPremios();
        this.pilaCastigos = new PilaCastigos();
        this.scanner = new Scanner(System.in);

        // Cargar premios y castigos al inicio del juego
        cargarPilas();
    }

    /**
     * Agrega a las pilas de premios y castigos sus respectivos elementos
     */
    public final void cargarPilas() {
        // Pila de Premios
        pilaPremios.apilar(new PremiosCastigos("+", 2, "Significa que suma dos posiciones."));
        pilaPremios.apilar(new PremiosCastigos("+", 8, "Significa que suma ocho posiciones."));
        pilaPremios.apilar(new PremiosCastigos("+", 0, "Significa que se queda en la posición actual."));

        // Pila de Castigos
        pilaCastigos.apilar(new PremiosCastigos("-", 3, "Significa que resta tres posiciones."));
        pilaCastigos.apilar(new PremiosCastigos("=", 1, "Significa que se debe ir a la posición 1."));
        pilaCastigos.apilar(new PremiosCastigos("-", 5, "Significa que resta cinco posiciones."));
    }

    /**
     * Metodo que le aplica el premio o castigo recibido al jugador
     * @param jugador objeto de tipo/clase Jugador que representa el jugador
     * @param premioCastigo objeto de tipo/clase PremiosCastigos que representa el premio o castigo
     */
    public void aplicarPremioOCastigo(Jugador jugador, PremiosCastigos premioCastigo) {

        int nuevaPosicion = jugador.getPosicion();

        switch (premioCastigo.getOperacion()) {
            case "+":
                // suma las posiciones
                nuevaPosicion += premioCastigo.getNumeroPosiciones();
                break;
            case "-":
                // resta las posiciones
                nuevaPosicion -= premioCastigo.getNumeroPosiciones();
                break;
            case "=":
                // se mueve directamente a la posicion indicada
                nuevaPosicion = premioCastigo.getNumeroPosiciones();
                break;
            default:
                System.out.println("Operacion no reconocida: " + premioCastigo.getOperacion());
                break;
        }
        jugador.setPosicion(nuevaPosicion);
    }

    /**
     * Ejecuta el turno del jugador, tirando los dados, analizando el resultado y aplicando el premio o castigo segun corresponda
     */
    public void ejecutarTurno() {
        // verificar si hay jugadores en la cola
        if (colaJugadores.estaVacia()) {
            System.out.println("No hay jugadores en la cola.");
            return;
        }

        // desencolar al primer jugador
        NodoCola nodoJugador = colaJugadores.desencolar();
        Jugador jugadorActual = nodoJugador.getJugador();

        // lanzar dados
        Dados dados = new Dados(0, 0);
        dados.tirar();
        int valor1 = dados.getValorDado1();
        int valor2 = dados.getValorDado2();
        int sumaDados = valor1 + valor2;

        System.out.println("\nTurno de: " + jugadorActual.getNombre());
        System.out.println("Resultado de los dados: " + valor1 + " y " + valor2 + " (Suma = " + sumaDados + ")");

        // verificar si es par o impar
        if (sumaDados % 2 == 0) {
            System.out.println("Obtuviste un número par, debes tomar un premio de la pila. ¡Mucha Suerte!");

            // desapilar un premio
            PremiosCastigos premio = pilaPremios.desapilar();
            if (premio != null) {
                System.out.println("Premio obtenido: " + premio);
                // aplicar operacion a la posicion del jugador
                aplicarPremioOCastigo(jugadorActual, premio);
            } 
            else {
                System.out.println("Ya no quedan mas premios...");
            }
        } 
        else {
            System.out.println("Obtuviste un número impar, debes tomar un castigo de la pila. Mejor suerte la próxima vez");

            // desapilar un castigo
            PremiosCastigos castigo = pilaCastigos.desapilar();
            if (castigo != null) {
                System.out.println("Castigo obtenido: " + castigo);
                // Aplicar operación a la posición del jugador
                aplicarPremioOCastigo(jugadorActual, castigo);
            } 
            else {
                System.out.println("Ya no quedan mas castigos...");
            }
        }
        System.out.println("Tu nueva posición es: " + jugadorActual.getPosicion());

        // re-encolar al jugador al final de la cola
        colaJugadores.encolar(jugadorActual);
    }

    /**
     * Menu inicial del juego el cual decide si se inicia la partida, se muestra la ayuda o se cierra el juego
     */
    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Iniciar juego");
            System.out.println("2. Ayuda");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    iniciarJuego();
                    break;
                case 2:
                    mostrarAyuda();
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo del juego. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    /**
     * Inicia la partida pidiendo la cantidad de jugadores asi como su nombre para agregarlos a la cola de listos/preparados
     */
    public void iniciarJuego() {
        System.out.print("Ingrese la cantidad de jugadores (mínimo 2 y máximo 4): ");
        int cantidadJugadores = scanner.nextInt();
        scanner.nextLine();

        if (cantidadJugadores < 2 || cantidadJugadores > 4) {
            System.out.println("Cantidad de jugadores inválida. Debe ser entre 2 y 4.");
            return;
        }

        for (int i = 0; i < cantidadJugadores; i++) {
            System.out.print("Ingrese el nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            // Se asigna id según el orden de ingreso y posición inicial 0.
            Jugador jugador = new Jugador(nombre, i + 1, 0);
            colaJugadores.encolar(jugador);
        }

        System.out.println("\nJugadores registrados:");
        colaJugadores.mostrarCola();

        // Una vez registrados los jugadores, se muestra el menú de partida.
        menuPartida();
    }

    /**
     * Muestra el menu disponible mientras la partida este en curso
     * Le permite al jugador ejecutar su turno, ver el estado de la cola, ver los premios y castigos restantes, abandonar el juego y terminar la partida
     */
    public void menuPartida() {
        boolean terminarJuego = false;
        while (!terminarJuego) {
            // Mostrar el jugador que tiene el turno actual (el que está al frente de la cola)
            if (!colaJugadores.estaVacia()) {
                Jugador jugadorTurno = colaJugadores.getFrente().getJugador();
                System.out.println("\nTurno actual: " + jugadorTurno.toString());
            } else {
                System.out.println("No hay jugadores en la cola.");
            }

            System.out.println("\n=== MENU DE PARTIDA ===");
            System.out.println("1. Ejecutar turno");
            System.out.println("2. Mostrar estado actual de la cola de jugadores");
            System.out.println("3. Mostrar pilas de premios y castigos");
            System.out.println("4. Abandonar el juego (un jugador puede salir si así lo desea)");
            System.out.println("5. Terminar juego");
            System.out.print("Seleccione una opción: ");

            int opcionPartida = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcionPartida) {
                case 1:
                    ejecutarTurno();
                    break;
                case 2:
                    System.out.println("\nJugadores en cola:");
                    colaJugadores.mostrarCola();
                    break;
                case 3:
                    System.out.println("\n=== Pila de Premios ===");
                    pilaPremios.mostrarPila();
                    System.out.println("\n=== Pila de Castigos ===");
                    pilaCastigos.mostrarPila();
                    break;
                case 4:
                    System.out.print("Ingrese el ID del jugador que desea abandonar el juego: ");
                    int idAbandono = scanner.nextInt();
                    scanner.nextLine();
                    if (colaJugadores.removerJugadorPorId(idAbandono)) {
                        System.out.println("El jugador con ID " + idAbandono + " ha abandonado el juego.");
                    } else {
                        System.out.println("No se encontró un jugador con ID " + idAbandono + " en la cola.");
                    }
                    break;
                case 5:
                    terminarJuego = true;
                    System.out.println("Terminando el juego. ¡Hasta la próxima!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    /**
     * Muestra la ayuda del juego asi como su version y desarrolladores
     */
    public void mostrarAyuda() {
        System.out.println("\n=== AYUDA ===");
        System.out.println("1. Iniciar juego: Comienza el proceso de registro de jugadores. Se solicitará la cantidad (entre 2 y 4) y el nombre de cada uno.");
        System.out.println("2. Ayuda: Muestra esta información.");
        System.out.println("3. Salir: Termina el programa.");
    }
}
