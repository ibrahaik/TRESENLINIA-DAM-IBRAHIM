//El bucle WHILE no está parando cuando se supone que tiene que parar. * SOLUCIONADO, && en vez de || *
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
            while(!joc.jugadaGuanyadora() && contador <= 9) {
                contador++;
                tui.jugadorActual();
                tui.mostrarTaulell(joc.getTablero());
                int[] posicions = tui.recollirJugada();
                joc.jugar(posicions[0], posicions[1]);
            }
            if (joc.jugadaGuanyadora()){
                tui.mostrarTaulell(joc.getTablero());
                tui.ganador();
            }
        }

    }
}
