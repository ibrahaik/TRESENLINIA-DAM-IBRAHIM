import java.util.Scanner;

public class TUI {
    Scanner sc = new Scanner(System.in);

    Joc joc = new Joc();
    char[][] tablero = joc.getTablero();
    int jugador = 2;

    boolean partida = false;
    boolean cpartida = false;
    boolean configuracion = false;

    public void menuNpartida(){
        partida = true;
        System.out.println("Has seleccionado, ¡ Nueva partida !");
        System.out.println("------------------");
    }

    public void menuCpartida(){
        cpartida = true;
        System.out.println("Has seleccionado, ¡ Cargar partida !");
        System.out.println("------------------");
        System.out.println("1. Nueva partida");
        System.out.println("2. Cargar partida");
        System.out.println("3. Configuración");
        System.out.println("4. Salir");
    }

    public void menuConfiguracion(){
        configuracion = true;
        System.out.println("Has seleccionado, Configuración. . .");
        System.out.println("------------------");
        System.out.println("Nivel de dificultad");
        System.out.println("Ajustar sonido");
    }

    public void menuSalir(){
        System.out.println("Has seleccionado, ¡ Salir del menú !");
        System.out.println("------------------");
        System.out.println("1. Nueva partida");
        System.out.println("2. Cargar partida");
        System.out.println("3. Configuración");
        System.out.println("4. Salir");

    }
    public void mostrarMenu(){

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

    //////
     public void jugadorActual() {
        if (jugador == 2){
            jugador = 1;
        }else {
            jugador = 2;
        }
}

    public int getJugador() {
        return jugador;
    }

    public void ganador() {
        System.out.println("¡ Tres en raya, GANADOR JUGADOR " + getJugador() + " !!");
    }

    public void mostrarTaulell(char[][] tablero){

        System.out.println("Turno del jugador " + getJugador());
        for (int i=0; i< 3; i++){
            System.out.print(i+1 + "| ");
            for (int j=0; j<3; j++){
                System.out.print((tablero[i][j] == ' ') ? " " : tablero[i][j]);
                System.out.print(" | ");

            }
            System.out.println();
        }
        System.out.println("-------------------");

    }


    boolean error = false;

    public int[] recollirJugada(boolean ocupada){

        System.out.println("¿En qué casilla te quieres posicionar? [1 - 3]");

        if (ocupada) {
            System.out.println("Casilla ocupada, vuelve a escoger");
        }
        int filas = sc.nextInt();
        int columnas = sc.nextInt();

        if (filas > 3 || filas < 1 || columnas > 3 || columnas < 1){
            System.out.println("¡Has salido del tablero!");
            error = true;
        }

            return new int[]{filas, columnas};

    }


    public void fiDePartida(){
        System.out.println("Método incompleto");
    }
    }


