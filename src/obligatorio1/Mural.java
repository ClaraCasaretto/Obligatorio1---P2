/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

public class Mural {
    private Diseñador diseñador;
    private String nombre;
    private char formato;
    private char formatoOriginal; //no se va a poder modificar
    private Ficha[][] mural; //para generar el mural
    private Ficha ficha1;
    private Ficha ficha2;
    
    //Constructor
    public Mural(Diseñador unDiseñador, String unNombre, char unFormato, Ficha unaFicha1, Ficha unaFicha2) {
        this.diseñador = unDiseñador;
        this.nombre = unNombre;
        this.formato = unFormato;
        this.formatoOriginal = unFormato;
        this.ficha1 = unaFicha1;
        this.ficha2 = unaFicha2;
        this.mural = new Ficha[10][12]; //instancia de mural compuesto con fichas
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

    public char getFormato() {
        return formato;
    }

    public void setFormato(char formato) {
        this.formato = formato;
    }
    
    public char getFormatoOriginal() {
        return formatoOriginal;
    }

    public void setFormatoOriginal(char formatoOriginal) {
        this.formatoOriginal = formatoOriginal;
    }

    public Ficha[][] getMural() {
        return mural;
    }

    public void setMural(Ficha[][] mural) {
        this.mural = mural;
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
