/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;
import obligatorio1.Ficha;
import java.util.Random;

public class Mural {
    private Diseñador diseñador;
    private String nombre;
    private char formato;
    private final Ficha[][] muralOriginal; //no se va a poder modificar
    private Ficha[][] mural; //para generar el mural
    private Ficha ficha1;
    private Ficha ficha2;
      
    //Constructor
    public Mural(Diseñador unDiseñador, String unNombre, char unFormato, Ficha [][] unMural, Ficha unaFicha1, Ficha unaFicha2) {
        this.diseñador = unDiseñador;
        this.nombre = unNombre;
        this.formato = unFormato;
        this.muralOriginal = unMural;
        this.ficha1 = unaFicha1;
        this.ficha2 = unaFicha2;
        this.mural = new Ficha[10][12]; //instancia de mural compuesto con fichas (inicialmente la matriz esta vacia)
        //Llamamos al metodo que lo llena
        crearMuralInicial (ficha1, ficha2, formato, mural);
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
    
    /* Hay que ver si hacemos esto con el mural original
    public char getFormatoOriginal() {
        return formatoOriginal;
    }

    public void setFormatoOriginal(char formatoOriginal) {
        this.formatoOriginal = formatoOriginal;
    }
    */

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
    
     //Creador de mural inicial (despues sacamos el void para que retorne la matriz?)
    public static void crearMuralInicial (Ficha ficha1, Ficha ficha2, char formato, Ficha[][] mural){
        if (formato == 'D'){
            cargarDamero (ficha1, ficha2, mural);
        }
        if (formato == 'R'){
            cargarRandom (ficha1, ficha2, mural);
        }
        if (formato == 'F'){
            cargarFilas (ficha1, ficha2, mural);
        }
        if (formato == 'B'){
            cargarBordeExt (ficha1, ficha2, mural);
        }
        if (formato == 'M'){
            cargarManual (ficha1, ficha2, mural);
        }
    }
    
    
    //Metodos individuales que cargan la matriz por patrones. Estos son los que deberian devolver el mural.
    public static void cargarDamero (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        for (int i = 0; i < mural.length; i++){
            for (int j = 0; j < mural[i].length; j++){
                if ((i+j)%2 == 0){
                    mural[i][j]= ficha1;
                } else {
                    mural[i][j]=ficha2;
                }
            }
        }
    }
    
    public static void cargarRandom (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        for (int i =0; i< mural.length; i++){
            for (int j=0; j< mural[i].length; j++){
                Random rand = new Random();
                int num = rand.nextInt(2);
                if (num==0){
                    mural[i][j]=ficha1;
                }else {
                    mural[i][j]=ficha2;
                }
            }
        }
    }
    
    public static void cargarFilas (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        for (int i = 0; i < mural.length; i+=2){
            for (int j = 0; j < mural[j].length; j++){
                mural[i][j]=ficha1;
            }
        } 
        for (int i = 1; i < mural.length; i+=2){
            for (int j = 0; j < mural[j].length; j++){
                mural[i][j]=ficha2;
            }
        }
    }
    
    public static void cargarBordeExt (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        for (int j=0; j<mural[0].length; j++){
            mural[0][j]=ficha1;
            mural[(mural.length-1)][j]=ficha1;
        }
        for (int i=1; i<mural.length-1;i++){
            for (int j=0; j<mural[i].length;j++){
                if (j==0 || j==mural[i].length-1){
                    mural[i][j]=ficha1;
                }else {
                    mural[i][j]=ficha2;
                }
            }
        }
    }
    
    public static void cargarManual (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        //aca hay que ver como hacemos para pedir las posiciones, si se encarga la interfaz o si se encarga este metodo.
    }
}
