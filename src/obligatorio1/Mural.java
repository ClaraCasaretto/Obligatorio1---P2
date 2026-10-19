    /*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;
import java.util.ArrayList;
import java.util.Random;

public class Mural {
    private Diseñador diseñador;
    private String nombre;
    private char formato;
    private Ficha[][] muralOriginal; //no se va a poder modificar    
    private Ficha[][] mural; //para generar el mural                 
    private Ficha ficha1;
    private Ficha ficha2;
      
    //Constructor
    public Mural(Diseñador unDiseñador, String unNombre, char unFormato, Ficha unaFicha1, Ficha unaFicha2) {
        this.diseñador = unDiseñador;
        this.nombre = unNombre;
        this.formato = unFormato;
        this.muralOriginal = new Ficha[10][12];
        this.ficha1 = unaFicha1;
        this.ficha2 = unaFicha2;
        this.mural = new Ficha[10][12]; //instancia de mural compuesto con fichas (inicialmente la matriz esta vacia)
    }

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
    
     //Creador de mural inicial, salvo metodo Manual
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
    }
    
    //Metodos individuales que cargan la matriz por patrones
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
    }
    
    private static void cargarBordeExt (Ficha ficha1, Ficha ficha2, Ficha[][] mural){
        //Carga la primera y la ultima fila
        for (int j=0; j<mural[0].length; j++){
            mural[0][j]=ficha1;
            mural[(mural.length-1)][j]=ficha1;
        }
        //Carga la primer y ultima columna con ficha1 y el resto con ficha2
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
    
    //Crea un mural con fichas vacias para la creacion Manual
    public void inicializarManual (Ficha ficha){
        for (int i = 0; i < mural.length; i++) {
            for (int j = 0; j < mural[i].length; j++) {
                mural[i][j] = ficha;
            }
        }
    }
    
    public void cargarManual (int fila, int columna, Ficha ficha){
        mural[fila-1][columna-1]=ficha;
    }
    
    //METODOS PARA MODIFICAR UN MURAL

    public void modificarPosicion (int fila, int columna, Ficha fichaNueva){
        mural[fila-1][columna-1]= fichaNueva;
    }
    
    public void reemplazarFicha (Ficha fichaVieja, Ficha fichaNueva){
        for (int i=0; i<mural.length;i++){
            for (int j=0; j<mural[i].length;j++){
                if (mural[i][j]==fichaVieja){
                    mural[i][j]=fichaNueva;
                }
            }
        }
    }
    
    public void restaurarMural (){
        //Logica para restaurar el mural desde la matriz original
        for (int i = 0; i < mural.length; i++) {
            for (int j = 0; j < mural[0].length; j++) {
                mural [i][j] = muralOriginal [i][j];
            }           
        }
    }
    
    //Guarda el mural original cuando se crea por primera vez
    public void guardarMuralOriginal() {
        for (int i = 0; i < mural.length; i++) {
            for (int j = 0; j < mural[0].length; j++) {
                muralOriginal[i][j] = mural[i][j];
            }
        }
    }
    
    public ArrayList <Ficha> obtenerFichasUsadas (){
        ArrayList <Ficha> fichasUsadas = new ArrayList<Ficha>();
        for (int i = 0; i < mural.length; i++) {
            for (int j = 0; j < mural[0].length; j++) {
                if (!fichasUsadas.contains(mural[i][j])){
                    fichasUsadas.add(mural[i][j]);
                }
            }
        }
        return fichasUsadas;
    }
}
