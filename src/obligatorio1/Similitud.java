/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

public class Similitud {
    private Mural muralSimilar;
    private int filaInicial;
    private int columnaInicial;

    public Similitud(Mural muralSimilar, int filaInicial, int columnaInicial) {
        this.muralSimilar = muralSimilar;
        this.filaInicial = filaInicial;
        this.columnaInicial = columnaInicial;
    }

    public Mural getMuralSimilar() {
        return muralSimilar;
    }

    public int getFilaInicial() {
        return filaInicial;
    }

    public int getColumnaInicial() {
        return columnaInicial;
    }
}
