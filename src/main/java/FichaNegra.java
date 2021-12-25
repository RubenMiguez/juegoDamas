public class FichaNegra extends Ficha{
    public FichaNegra(int fila, int columna, boolean oculta) {
        super(fila, columna, oculta);
    }

    public FichaNegra(int fila, int columna) {
        super(fila, columna);
    }

    @Override
    public int novaFila() {
        return this.fila++;
    }

    @Override
    public boolean mover(Direccion direccionMovimiento) {
        setPosicion(novaFila(), novaColumna(direccionMovimiento));
        return false;
    }

    @Override
    public String toString() {
        return "N";
    }
}
