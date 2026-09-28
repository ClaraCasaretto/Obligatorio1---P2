/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

import java.util.ArrayList;

public class Sistema {
    
    private ArrayList<Diseñador>listaDiseñadores;
    private ArrayList<Ficha> listaFichas;
    
    //Constructor
    public Sistema(){
        this.listaDiseñadores = new ArrayList<Diseñador>();
        this.listaFichas = new ArrayList<Ficha>();
    }
    
    //Getters & Setters
    public ArrayList<Diseñador> getListaDiseñador() {
        return listaDiseñadores;
    }

    public void setListaDiseñador(ArrayList<Diseñador> listaDiseñador) {
        this.listaDiseñadores = listaDiseñador;
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(ArrayList<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }
    
    
    
    
}
