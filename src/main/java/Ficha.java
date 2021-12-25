public abstract class Ficha implements Movible {
    public int fila;
    public int columna;
    public boolean oculta;

    public Ficha(int fila, int columna, boolean oculta){
        this.oculta = estaOcultaFicha(fila, columna);
    }

    public Ficha(int fila, int columna){
        this.oculta = estaOcultaFicha(fila, columna);
    }

    private boolean estaOcultaFicha(int fila, int columna){
        if (((fila + columna) % 2 == 0) || fila < 0 || columna < 0){
            return true;
        }
        return false;
    }

    public void setPosicion(int fila, int columna){
        if (estaOcultaFicha(fila, columna)){
            this.oculta = true;
        }
        this.fila = fila;
        this.columna = columna;
    }

    protected int novaColumna(Movible.Direccion direccion){
        if (direccion.equals(Movible.Direccion.DERECHA)){
            return  this.columna + 2;
        } else if (direccion.equals(Movible.Direccion.IZQUIERDA)){
            return  this.columna - 2;
        }
        System.out.println("Movimiento no permitodo. Solo Derecha - Izquierda");
        return this.columna;
    }

    public abstract int novaFila();


    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isOculta() {
        return oculta;
    }

    public void setOculta(boolean oculta) {
        this.oculta = oculta;
    }


}
