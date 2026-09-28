/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

//import java.util.ArrayList;

public class Diseñador {
    
    private String nombre;
    private String direccion;
    private String email;
    
    /*
    Seguramente necesitemos una lista (array) de murales para poder tener la lista de 
    murales que hizo este Diseñador
    */
    //private ArrayList<Mural> listaDeMurales;
    
    //Constructor
    public Diseñador (String unNombre, String unaDireccion, String unEmail){
        this.nombre = unNombre;
        this.direccion = unaDireccion;
        this.email = unEmail;
        //listaDeMurales = new ArrayList<Mural>();
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
