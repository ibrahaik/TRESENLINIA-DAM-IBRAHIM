//El bucle WHILE no está parando cuando se supone que tiene que parar. * SOLUCIONADO, && en vez de || *
//Cuando se pone una X o una O en una casilla ocupada se tiene que avisar al jugador y hacer que repita la tirada de manera infinita hasta que coloque la ficha en una casilla vacía
//Cuando un jugador gana el mensaje de victoria se da para el jugador inverso
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //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
    public static void main(String[] args) {
        TUI tui = new TUI();
        Joc joc = new Joc();
        int contador = 0;
        //menu inicial
        tui.mostrarMenu();

        //si se empieza una nueva partida
        if (tui.partida) {
            joc.novaPartida();

            while (!joc.jugadaGuanyadora() && contador < 9 && !joc.partidaGuardada) {
                //Se comprueba el jugador actual
                    joc.Jugador();
                    //Se muestra el tablero y el jugador actual
                    tui.mostrarTaulell(joc.getTablero(), joc.getJugador());
                    //Se lee la posición en la que el jugador quiere jugar
                    int[] posicions = tui.recollirJugada();
                    //Si la jugada es válida el contador suma el turno
                    boolean valida = joc.jugar(posicions[0], posicions[1]);
                    if(valida) {
                        contador++;
                    }
            }

            //FIN DE LA PARTIDA
            if (joc.jugadaGuanyadora()) {
                tui.mostrarTaulell(joc.getTablero(), joc.getJugador());
                tui.ganador(joc.getJugador());
            }
            if (!joc.jugadaGuanyadora()) {
                tui.empate();
            }
        }

        if (tui.cpartida){
          File archivo = tui.seleccionarArchivoPartidaGuardada();
          if (archivo == null){
              tui.mostrarMenu();
          }else {
              joc.cargarPartida(archivo);
              while (!joc.jugadaGuanyadora() && contador < 9 && !joc.partidaGuardada) {
                  //Se comprueba el jugador actual
                  joc.Jugador();
                  //Se muestra el tablero y el jugador actual
                  tui.mostrarTaulell(joc.getTablero(), joc.getJugador());
                  //Se lee la posición en la que el jugador quiere jugar
                  int[] posicions = tui.recollirJugada();
                  //Si la jugada es válida el contador suma el turno
                  boolean valida = joc.jugar(posicions[0], posicions[1]);
                  if(valida) {
                      contador++;
                  }
              }
          }
        }

        }
    }
