public class Joc {


    private char[][] tablero;
    private int jugador = 0;

    public int getJugador(){return jugador;}
    public char[][] getTablero() {
        return tablero;
    }


    public void  novaPartida(){
        this.jugador = 1;
        this.tablero = new char[3][3];
        for (int i=0; i< 3; i++){
            for (int j=0; j<3; j++){
                this.tablero[i][j] = ' ';
            }
        }

    }

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



    public boolean jugar(int fila, int columna) {
        if(tablero[fila][columna] != ' ') return false;
        else if(fila < 0 || fila >= this.tablero.length) return false;
        else if(columna < 0 || columna > this.tablero.length) return false;
        else{
            tablero[fila][columna] = (this.jugador == 1 ? 'X' : 'O');
            this.jugador = (this.jugador == 1 ? 2 : 1);
            return true;
        }
    }
}





