/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

import java.util.ArrayList;
import java.util.Collections;

public class Sistema {
    
    private ArrayList<Diseñador>listaDiseñadores;
    private ArrayList<Ficha> listaFichas;
    public ArrayList<Mural> listaMurales;
    
    //Constructor
    public Sistema(){
        this.listaDiseñadores = new ArrayList<Diseñador>();
        this.listaFichas = new ArrayList<Ficha>();
        this.listaMurales = new ArrayList<Mural>();
    }
    
    //Cargamos datos iniciales
    public void cargarDatosIniciales() {
        Diseñador dClara = new Diseñador("CLARA", "R1234", "CLARA@GMAIL.COM");
        Diseñador dManu = new Diseñador("MANU", "D5678", "MANU@GMAIL.COM");
        
        agregarDiseñador(dClara);
        agregarDiseñador(dManu);
        
       Ficha sol = new Ficha("SOL", "\\|/-*-/|\\", "..|...\\|/.--*--./|\\...|..", "M");
       Ficha cuadrado = new Ficha("CUADRADO","+-+|.|+-+","+---+|...||...||...|+---+", "N");
       Ficha corazon = new Ficha("CORAZON","*.****.*.","**.************.***...*..","R");
       Ficha copa = new Ficha("COPA","\\./.|./_\\","\\.../.\\./...|....|.../_\\.","C");
       Ficha arbol = new Ficha("ARBOL",".^.^^^.|.","..^...^^^.^^^^^..|.../.\\.","V");
       Ficha gato = new Ficha("GATO","^.^o.o=^=","/\\_/\\(o.o).>^<../|\\../.\\.","A");
       Ficha diamante = new Ficha("DIAMANTE",".*.*.*.*.","..*...*.*.*...*.*.*...*..","G");
       Ficha vacia = new Ficha("VACIA",".........",".........................","B");

       agregarFicha(sol);
       agregarFicha(cuadrado);
       agregarFicha(corazon);
       agregarFicha(copa);
       agregarFicha(arbol);
       agregarFicha(gato);
       agregarFicha(diamante);
       agregarFicha(vacia);
    }
    
    
    //Getters & Setters
    public ArrayList<Diseñador> getListaDiseñadores() {
        return listaDiseñadores;
    }

    public void setListaDiseñadores(ArrayList<Diseñador> listaDiseñador) {
        this.listaDiseñadores = listaDiseñador;
    }
    
    //agrega un Diseñador a la lista Diseñador
    public void agregarDiseñador(Diseñador unDiseñador){
        this.listaDiseñadores.add(unDiseñador);
    }
    
    //valida si ya existe un diseñador con ese nombre
    public boolean existeDiseñador(String unNombre){
        boolean yaExiste = false;
        for (int i = 0; i < this.listaDiseñadores.size() && !yaExiste; i++) {
            if(this.listaDiseñadores.get(i).getNombre().equals(unNombre)){
                yaExiste = true;
            }
        }
        return yaExiste;
    }
    
    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(ArrayList<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }
    
    //agrega una ficha en la lista de fichas
    public void agregarFicha (Ficha unaFicha){
        this.listaFichas.add(unaFicha);
    }
    
    //valida si ya existe una ficha con ese nombre
    public boolean existeFicha(String unNombre){
        boolean yaExiste = false;
        for (int i = 0; i < this.listaFichas.size() && !yaExiste; i++) {
            if(this.listaFichas.get(i).getNombre().equals(unNombre)){
                yaExiste = true;
            }
        }
        return yaExiste;
    }

    public ArrayList<Mural> getListaMurales() {
        return listaMurales;
    }
    
    public Mural seleccionarMural (int indice){
        return listaMurales.get(indice);
    }

    public void setListaMurales(ArrayList<Mural> listaMurales) {
        this.listaMurales = listaMurales;
    }
  
    //valida si existe ya un mural con ese nombre
    public boolean existeMural(String unNombre){
        boolean yaExiste = false;
        for (int i = 0; i < this.listaMurales.size(); i++) {
            if(this.listaMurales.get(i).getNombre().equals(unNombre)){
                yaExiste = true;
            } 
        }
        return yaExiste;
    }
    
    public void agregarMural (Mural mural){
        this.listaMurales.add(mural);
    }
    
    //tendremos que incluir @override?
    public ArrayList<Diseñador> ordenarDiseñadores() {
        ArrayList<Diseñador> diseñadoresOrdenados = new ArrayList<Diseñador>(this.getListaDiseñadores());
        Collections.sort(diseñadoresOrdenados);
        return diseñadoresOrdenados;
    }
    
    public ArrayList<Mural> compararMurales (Mural mural, int fila, int columna, int cantFilas, int cantColumnas){
        ArrayList<Mural> similitudesEncontradas = new ArrayList<>();
        boolean similitudOk = false;
        Ficha[][] matriz = mural.getMural();
        //limites de cuadrantes viables para comparar
        int limiteFila = matriz.length - cantFilas + 1;
        int limiteCol = matriz[0].length - cantColumnas + 1;
        
        //Se buscan los murales candidatos de la lista.
        for (int i = 0; i <  listaMurales.size(); i++) { 
            Ficha[][] candidato = listaMurales.get(i).getMural();
            //Se recorre el candidato de acuerdo a los limites para no recorrer todo al pedo
            for (int j = 0; j < limiteFila; j++) {
                for (int k = 0; k < limiteCol; k++) {
                    if (matriz[fila-1][columna-1]==candidato[j][k]){
                        boolean flag = true;
                        //Aca se tiene que empezar a comparar el cuadrante con el dado por parametro
                        //a la primera que no coincida se descarta
                    }
                    
                }
            
            }
        }
        
        return similitudesEncontradas;
    } 

}
