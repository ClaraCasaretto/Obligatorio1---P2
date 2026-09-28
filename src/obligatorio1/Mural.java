/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

public class Mural {
    private Diseñador diseñador;
    private String nombre;
    private String formato;
    private Ficha[][] mural; //para generar el mural
    private Ficha[][] muralOriginal; //creo que se puede restaurar... guardar la matriz original
    private Ficha ficha1;
    private Ficha ficha2;
    
    //Constructor
    public Mural(Diseñador unDiseñador, String unNombre, String unFormato, Ficha unaFicha1, Ficha unaFicha2) {
        this.diseñador = unDiseñador;
        this.nombre = unNombre;
        this.formato = unFormato;
        this.ficha1 = unaFicha1;
        this.ficha2 = unaFicha2;
        /*
        Los murales estarán organizados como matrices rectangulares de 
        10 filas y 12 columnas donde en cada posición va una ficha
        */
        this.mural = new Ficha[10][12];
        this.muralOriginal = new Ficha[10][12];
    }
    
    //Setters & Getters

    public Diseñador getDiseñador() {
        return diseñador;
    }

    public void setDiseñador(Diseñador diseñador) {
        this.diseñador = diseñador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Ficha[][] getMural() {
        return mural;
    }

    public void setMural(Ficha[][] mural) {
        this.mural = mural;
    }

    public Ficha[][] getMuralOriginal() {
        return muralOriginal;
    }

    public void setMuralOriginal(Ficha[][] muralOriginal) {
        this.muralOriginal = muralOriginal;
    }

    public Ficha getFicha1() {
        return ficha1;
    }

    public void setFicha1(Ficha ficha1) {
        this.ficha1 = ficha1;
    }

    public Ficha getFicha2() {
        return ficha2;
    }

    public void setFicha2(Ficha ficha2) {
        this.ficha2 = ficha2;
    }
    
    
    //ver si necesitamos un toString
}
