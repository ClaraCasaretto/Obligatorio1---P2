/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

import java.util.ArrayList;

public class Diseñador {
    
    private String nombre;
    private String direccion;
    private String email;
    private ArrayList<Mural> listaDeMurales;
    private ArrayList<Ficha> listaDeFichas;
    
    
    //Constructor
    public Diseñador (String unNombre, String unaDireccion, String unEmail){
        this.nombre = unNombre;
        this.direccion = unaDireccion;
        this.email = unEmail;
        listaDeMurales = new ArrayList<Mural>();
        listaDeFichas = new ArrayList<Ficha>();
    }
    
    //getters & setters
   //ver cuales realmente neceistamos y cuales no 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Mural> getListaDeMurales() {
        return listaDeMurales;
    }

    public void setListaDeMurales(ArrayList<Mural> listaDeMurales) {
        this.listaDeMurales = listaDeMurales;
    }

    public ArrayList<Ficha> getListaDeFichas() {
        return listaDeFichas;
    }

    public void setListaDeFichas(ArrayList<Ficha> listaDeFichas) {
        this.listaDeFichas = listaDeFichas;
    }
    
    //agaregamos toString? si lo ponemos, ver como ponerlo
    /*
    @Override
    public String toString() {
        return "El diseñador: " + nombre
             + "\nDirección: " + direccion
             + "\nEmail: " + email;
    }
    */
}
