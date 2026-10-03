/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;
import java.util.Random;

public class Mural {
    private Diseñador diseñador;
    private String nombre;
    private char formato;
    //revisar en el uml y agregar el muralOriginal
    //mural original lo puse porque en caso de R o M no se puede volver a generar igual
    private Ficha[][] muralOriginal; //no se va a poder modificar    
    private Ficha[][] mural; //para generar el mural                 
    //evaluar si dejamos ficha 1 y 2 o ponemos un arraylist, porque pueden generarse mas fichas editando el mural
    private Ficha ficha1;
    private Ficha ficha2;
      
    //Constructor
    public Mural(Diseñador unDiseñador, String unNombre, char unFormato, Ficha unaFicha1, Ficha unaFicha2) {
        this.diseñador = unDiseñador;
        this.nombre = unNombre;
        this.formato = unFormato;
        //Aca hay que revisar, porque tecnicamente todavia no existe el mural, y estamos cargando el original
        this.muralOriginal = new Ficha[10][12];
        this.ficha1 = unaFicha1;
        this.ficha2 = unaFicha2;
        this.mural = new Ficha[10][12]; //instancia de mural compuesto con fichas (inicialmente la matriz esta vacia)
        //Llamamos al metodo que lo llena
        crearMuralInicial ();
        //metodo para imprimir el mural
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
       
    //hay que ver si necesitamos un setter de formato
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
    public void crearMuralInicial (){
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
        //decidir donde se pone el metodo cargarManual
        /*if (formato == 'M'){
            cargarManual (ficha1, ficha2, mural);
        }*/        
        //Cargar mural inicial?    
    }
    
    
    //Metodos individuales que cargan la matriz por patrones. Estos son los que deberian devolver el mural.
    //Deberiamos ver si estos metodos son los que guardan la matriz original si no existe
    private static void cargarDamero (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
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
    
    private static void cargarRandom (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        Random rand = new Random();
        for (int i =0; i< mural.length; i++){
            for (int j=0; j< mural[i].length; j++){
                int num = rand.nextInt(2);
                if (num==0){
                    mural[i][j]=ficha1;
                }else {
                    mural[i][j]=ficha2;
                }
            }
        }
    }
    
    //Capaz que se puede hacer con una sola recorrida y no dos
    private static void cargarFilas (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        for (int i = 0; i < mural.length; i++){
            for (int j = 0; j < mural[i].length; j++){
                if(i%2==0){
                    mural[i][j]=ficha1;
                }else {
                    mural[i][j]=ficha2;
                }
            }
        } 
        /*for (int i = 1; i < mural.length; i+=2){
            for (int j = 0; j < mural[i].length; j++){
                mural[i][j]=ficha2;
            }
        }*/
    }
    
    private static void cargarBordeExt (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        //carga la primera y la ultima fila
        for (int j=0; j<mural[0].length; j++){
            mural[0][j]=ficha1;
            mural[(mural.length-1)][j]=ficha1;
        }
        //carga la primer y ultima columna con ficha1 y el resto con ficha2
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
    
    public void cargarManual (int fila, int columna, Ficha ficha){
        //manejo de error si la posicion ya fue ingresada
        //se pone -1 porque la matriz es a partir de 1??
        if (mural[fila-1][columna-1]==null){
            mural[fila-1][columna-1]=ficha;
        }
        //aca hay que ver como hacemos para pedir las posiciones, se encarga la interfaz.
    }
    
    //METODOS PARA MODIFICAR UN MURAL
    
    //Para este hay que tener cuidado por si la fila y colunma no son validas
    public static void modificarPosicion (int fila, int columna, Ficha fichaNueva, Ficha[][] mural){
        mural[fila-1][columna-1]= fichaNueva;
    }
    
    public static void reemplazarFicha (Ficha fichaVieja, Ficha fichaNueva, Ficha[][] mural){
        for (int i=0; i<mural.length;i++){
            for (int j=0; j<mural[i].length;j++){
                if (mural[i][j]==fichaVieja){
                    mural[i][j]=fichaNueva;
                }
            }
        }
    }
    
    public void restaurarMural (Ficha [][] mural){
        //logica para restaurar el mural desde la matriz original
        //this.mural = this.muralOriginal.clone(); 
        for (int i = 0; i < mural.length; i++) {
            for (int j = 0; j < mural[0].length; j++) {
                mural [i][j] = muralOriginal [i][j];
            }           
        }
    }
    
    public void guardarMuralOriginal() {
        for (int i = 0; i < mural.length; i++) {
            for (int j = 0; j < mural[0].length; j++) {
                muralOriginal[i][j] = mural[i][j];
            }
        }
    }
}
