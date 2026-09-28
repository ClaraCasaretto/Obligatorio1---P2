/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

public class Ficha {
    
    private String nombre;
    private String diseñoChico;
    private String diseñoGrande;
    private char color;
    
    //Constructor
    public Ficha(String nombre, String diseñoChico, String diseñoGrande, char color) {
        this.nombre = nombre;
        this.diseñoChico = diseñoChico;
        this.diseñoGrande = diseñoGrande;
        this.color = color;
    }

    //getters & setters
    //ver cuales realmente neceistamos y cuales no 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiseñoChico() {
        return diseñoChico;
    }

    public void setDiseñoChico(String diseñoChico) {
        this.diseñoChico = diseñoChico;
    }

    public String getDiseñoGrande() {
        return diseñoGrande;
    }

    public void setDiseñoGrande(String diseñoGrande) {
        this.diseñoGrande = diseñoGrande;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }
    
    /*agregar un toString??*/
    
    
}
