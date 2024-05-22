import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Joc {

//CREACIÓN DE TABLERO Y JUGADOR
    private char[][] tablero;
    private int jugador = 2;
    boolean partidaGuardada = false;

    public int getJugador(){return jugador;}
    public char[][] getTablero() {
        return tablero;
    }

//Se inicializa una nueva partida con el tablero en blanco
    public void  novaPartida(){

        this.tablero = new char[3][3];
        for (int i=0; i< 3; i++){
            for (int j=0; j<3; j++){
                this.tablero[i][j] = ' ';
            }
        }

    }

    public void guardarPartida() {

        //Obtener formato de fecha y hora actual
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String horaActual = formatoFecha.format(new Date());

        //Si no existe se crea la carpeta savedgames
        File carpetaSavedGames = new File("/home/ibrahim.haik.el.haouzi.mrabet/Escriptori/savedgames");
        if (!carpetaSavedGames.exists()) {
            carpetaSavedGames.mkdir();
        }

        //Crear el archivo con el formato correcto fecha y hora
        File archivoPartida = new File("/home/ibrahim.haik.el.haouzi.mrabet/Escriptori/savedgames/" + horaActual + ".txt");

        //Guardar estado de la partida en el archivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoPartida))) {
            writer.write(Integer.toString(jugador));
            writer.newLine();

            for (int i=0; i< tablero.length; i++) {
                for (int j=0; j< tablero.length; j++) {
                    writer.write(tablero[i][j]);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar la partida: " + e.getMessage());
        }

    }

    public void cargarPartida(File archivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            // Leer el jugador actual desde el archivo
            this.jugador = Integer.parseInt(reader.readLine());

            novaPartida();
            // Leer el contenido del tablero desde el archivo
            String linea;
            int fila = 0;
            while ((linea = reader.readLine()) != null) {
                for (int columna = 0; columna < linea.length(); columna++) {
                    this.tablero[fila][columna] = linea.charAt(columna);
                }
                fila++;
            }
        } catch (IOException e) {
            System.err.println("Error al cargar la partida: " + e.getMessage());
        }
    }
//Se calculan las posibles jugadas ganadoras
    public boolean jugadaGuanyadora(){

    //JUGADA GANADORA JUGADOR 1 , X
        for (int i = 0; i < 3; i++) {

            //COMPROBAR RECTAS, JUGADAS BÁSICAS

            if (tablero[0][i] == 'X' && tablero[1][i] == 'X' && tablero[2][i] == 'X') {
                return true;
            }
            if (tablero[i][0] == 'X' && tablero[i][1] == 'X' && tablero[i][2] == 'X') {
                return true;
            }

        }
//COMPROBAR DIAGONALES
        if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X') {
            return true;
        }
        if (tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X') {
            return true;
        }

        //JUGADA GANADORA JUGADOR 2, O
        for (int i = 0; i < 3; i++) {

            //COMPROBAR RECTAS, JUGADAS BÁSICAS

            if (tablero[0][i] == 'O' && tablero[1][i] == 'O' && tablero[2][i] == 'O') {
                return true;
            }
            if (tablero[i][0] == 'O' && tablero[i][1] == 'O' && tablero[i][2] == 'O') {
                return true;
            }

        }
//COMPROBAR DIAGONALES
        if (tablero[0][0] == 'O' && tablero[1][1] == 'O' && tablero[2][2] == 'O') {
            return true;
        }
        if (tablero[0][2] == 'O' && tablero[1][1] == 'O' && tablero[2][0] == 'O') {
            return true;
        }

        return false;

    }


//Se le resta un -1 a fila y columna para hacerlo más amigable al usuario.
    //Si la casilla está ocupada devuelve false, si se sale del tablero devuelve false
    public boolean jugar(int fila, int columna) {

        int filaReal = fila - 1;
        int columnaReal = columna - 1;

        if (filaReal == -1 && columnaReal == -1) {
            guardarPartida();
            partidaGuardada = true;
            return false;
        } else {
            if (tablero[filaReal][columnaReal] != ' ') {
                return false;
            } else {
                tablero[filaReal][columnaReal] = (this.jugador == 1 ? 'X' : 'O');
                return true;
            }
        }
    }
//Si el jugador es 1 pasa a ser 2 y si es 2 pasa a 1
    public void Jugador(){
        if (jugador == 1){
            jugador = 2;
        }else {
            jugador = 1;
        }
    }

}







