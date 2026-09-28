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
    
    //agrega un Diseñador a la lista Diseñador
    public void actualizarListaDiseñadores(Diseñador unDiseñador){
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
    public void actualizarListaFichas(Ficha unaFicha){
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
    
    
}
