//El bucle WHILE no está parando cuando se supone que tiene que parar. * SOLUCIONADO, && en vez de || *
//Cuando se pone una X o una O en una casilla ocupada se tiene que avisar al jugador y hacer que repita la tirada de manera infinita hasta que coloque la ficha en una casilla vacía
public class Main {
    //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
    public static void main(String[] args) {
        TUI tui = new TUI();
        Joc joc = new Joc();

        //menu inicial
        tui.mostrarMenu();

        //si se empieza una nueva partida
        if (tui.partida) {
            joc.novaPartida();
            int contador = 0;
            while (!joc.jugadaGuanyadora() && contador <= 9) {
                    tui.mostrarTaulell(joc.getTablero(), joc.getJugador());
                    int[] posicions = tui.recollirJugada();
                    boolean valida = joc.jugar(posicions[0], posicions[1]);
                    if(valida) contador++;
            }

            //FIN DE LA PARTIDA
            if (joc.jugadaGuanyadora()) {
                tui.mostrarTaulell(joc.getTablero(), joc.getJugador());
                tui.ganador(joc.getJugador());
            }
        }

        }
    }

