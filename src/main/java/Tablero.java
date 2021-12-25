import java.util.ArrayList;

public class Tablero {
    private final int TAMANHO = 8;
    private final String BARRA = "\n-----------------------------------\n";
    private Ficha[] comidas;
    private Ficha[][] fichas = new Ficha[TAMANHO][TAMANHO];

    public Tablero() {
        iniciarTablero();
    }

    public Tablero(int filas, int columnas, Ficha[] fichas) {
        iniciarTablero();
    }

    public void iniciarTablero() {
        for (int fila = 0; fila < TAMANHO; fila++) {
            for (int columna = 0; columna < TAMANHO; columna++) {
                if (fila <= 2 && ((columna + fila) % 2 == 1)) {
                    fichas[fila][columna] = new FichaNegra(fila, columna);
                } else if (fila >= (TAMANHO - 2)  && ((columna + fila) % 2 == 1)) {
                    fichas[fila][columna] = new FichaBlanca(fila, columna);
                }
            }
        }
    }

    public Ficha getFicha(int fila, int columna) {
        return this.fichas[fila][columna];
    }

    public void setFicha(int fila, int columna) {
        if (fila >= 0 && fila <= TAMANHO
                && columna >= 0 && columna <= TAMANHO) {
            this.fichas[fila][columna].setPosicion(fila, columna);
        }
    }

    public void mover(int fila, int columna, Movible.Direccion direccion) {
        if (this.fichas[fila][columna] != null) {
            System.out.println("Posicion no valida");
        }
        int novaFila = this.fichas[fila][columna].novaFila();
        int novaColumna = this.fichas[fila][columna].novaColumna(direccion);
        if (this.fichas[novaFila][novaColumna] == null || estaDentrotablero(novaFila, novaColumna)) {
            this.fichas[fila][columna].setPosicion(novaFila, novaColumna);
        }
    }

    private boolean estaDentrotablero(int fila, int columna) {
        return (fila >= 0 && fila < TAMANHO && columna >= 0 && columna < TAMANHO);
    }

    @Override
    public String toString() {
        StringBuilder tablero = new StringBuilder();
        tablero.append(BARRA);
        for (int fila = 0; fila < TAMANHO; fila++) {
            for (int columna = 0; columna < TAMANHO; columna++) {
                tablero.append(" | ");
                if (fichas[fila][columna] != null) {
                    tablero.append(fichas[fila][columna].toString());
                } else {
                    tablero.append(" ");
                }
            }
            tablero.append(" | ");
            tablero.append(BARRA);
        }
        tablero.append("Fichas comidas: ");
        return tablero.toString();
    }
}