import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class TUI {
    Scanner sc = new Scanner(System.in);

    boolean partida = false;
    boolean cpartida = false;
    boolean configuracion = false;
    int tamanoTablero;


    public void menuNpartida() {
        partida = true;
        System.out.println("Has seleccionado, ¡ Nueva partida !");
        System.out.println("------------------");
    }

    public void menuCpartida() {
        cpartida = true;
        System.out.println("Has seleccionado, ¡ Cargar partida !");
        System.out.println("------------------");


    }

    public void menuConfiguracion() {
        configuracion = true;
        System.out.println("Has seleccionado, Configuración. . .");
        System.out.println("------------------");
        System.out.println("Tamaño del tablero - Mínimo 3, Máximo 10");
        tamanoTablero = sc.nextInt();
        if (tamanoTablero <3 || tamanoTablero > 10) {
            System.out.println("Has salido del tamaño permitido, recuerda que el tamaño debe tener un mínimo de 3 y un máximo de 10");
            menuConfiguracion();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("/home/ibrahim.haik.el.haouzi.mrabet/Escriptori/config"))) {
            writer.write(Integer.toString(tamanoTablero));
        } catch (IOException e) {
            System.err.println("Error al escribir la configuración del tamaño del tablero: " + e.getMessage());
        }

        System.out.println("¿Quieres volver al menú? 1.Sí 2.No");
        int respuesta = sc.nextInt();
        if (respuesta == 1){
            mostrarMenu();
        } else if (respuesta == 2) {
            menuConfiguracion();
        }else {
            System.out.println("Respuesta inválida, por favor responde con 1 o 2");
            menuConfiguracion();
        }


    }


    public void menuSalir() {
        System.out.println("Has seleccionado, ¡ Salir del menú !");
        System.out.println("------------------");
    }

    public void mostrarMenu() {

        System.out.println("1. Nueva partida");
        System.out.println("2. Cargar partida");
        System.out.println("3. Configuración");
        System.out.println("4. Salir");

        int opcion = sc.nextInt();

        if (opcion == 1) {
            menuNpartida();
        } else if (opcion == 2) {
            menuCpartida();
        } else if (opcion == 3) {
            menuConfiguracion();
        } else if (opcion == 4) {
            menuSalir();
        } else {
            System.out.println("Elección inválida");
            System.out.println("------------------");
            System.out.println("1. Nueva partida");
            System.out.println("2. Cargar partida");
            System.out.println("3. Configuración");
            System.out.println("4. Salir");

        }

    }

    public File seleccionarArchivoPartidaGuardada () {

        File carpetaSavedGames = new File("/home/ibrahim.haik.el.haouzi.mrabet/Escriptori/savedgames");
        File[] archivos = carpetaSavedGames.listFiles((dir, name) -> name.endsWith(".txt"));

        if (archivos == null || archivos.length == 0) {
            System.out.println("No hay partidas guardadas.");
            return null;
        }

        System.out.println("Partidas guardadas disponibles:");
        for (int i = 0; i < archivos.length; i++) {
            System.out.println((i + 1) + ". " + archivos[i].getName());
        }

        System.out.println("Selecciona el número de la partida que deseas cargar:");
        Scanner sc = new Scanner(System.in);
        int seleccion = sc.nextInt() - 1;

        if (seleccion < 0 || seleccion >= archivos.length) {
            System.out.println("Selección inválida.");
            return null;
        }

        return archivos[seleccion];
    }

    public void ganador(int jugador) {
        System.out.println("¡ Tres en raya, GANADOR JUGADOR " + jugador + " !!");
    }
    public void empate() {
        System.out.println("¡ EMPATE !");
    }

    public void mostrarTaulell(char[][] tablero, int jugador) {

        System.out.println("Turno del jugador " + jugador);
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1 + "| ");
            for (int j = 0; j < 3; j++) {
                System.out.print((tablero[i][j] == ' ') ? " " : tablero[i][j]);
                System.out.print(" | ");

            }
            System.out.println();
        }
        System.out.println("-------------------");

    }


    boolean error = false;

    public int[] recollirJugada() {

        System.out.println("¿En qué casilla te quieres posicionar? [1 - 3]");
        System.out.println("Para guardar la partida, inserta [0 , 0]");


        int filas = sc.nextInt();
        int columnas = sc.nextInt();

        if (filas > 3 || filas < 1 || columnas > 3 || columnas < 1) {
            System.out.println("¡Has salido del tablero!");
            error = true;
        }

        return new int[]{filas, columnas};

    }
}



