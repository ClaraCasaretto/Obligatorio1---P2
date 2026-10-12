/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package obligatorio1;

import java.util.ArrayList;

public class Diseñador implements Comparable {
    
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
    
    public void agregarMural (Mural mural){
        this.listaDeMurales.add(mural);
    }

    public ArrayList<Ficha> getListaDeFichas() {
        return listaDeFichas;
    }

    public void setListaDeFichas(ArrayList<Ficha> listaDeFichas) {
        this.listaDeFichas = listaDeFichas;
    }
    
    public int cantidadDeMurales() {
        return listaDeMurales.size();
    }
    
    public int cantidadDeFichasDiferentes() {
        ArrayList<Ficha> fichasDiferentes = new ArrayList<Ficha>();
        for (int i = 0; i < listaDeMurales.size(); i++) {
            Ficha[][] matriz = listaDeMurales.get(i).getMural();
            for (int fila = 0; fila < matriz.length; fila++) {
                for (int columna = 0; columna < matriz[fila].length; columna++) {
                    Ficha ficha = matriz[fila][columna];
                    if (ficha != null && !fichasDiferentes.contains(ficha)) {
                        fichasDiferentes.add(ficha);
                    }
                }
            }
        }
        return fichasDiferentes.size();
    }
    
    public int cantidadDeColoresDiferentes() {
        ArrayList<String> coloresDiferentes = new ArrayList<String>();
        for (int i = 0; i < listaDeMurales.size(); i++) {
            Ficha[][] matriz = listaDeMurales.get(i).getMural();
            for (int fila = 0; fila < matriz.length; fila++) {
                for (int columna = 0; columna < matriz[fila].length; columna++) {
                    Ficha ficha = matriz[fila][columna];
                    if (ficha != null && !coloresDiferentes.contains(ficha.getColor())) {
                        coloresDiferentes.add(ficha.getColor());
                    }
                }
            }
        }
        return coloresDiferentes.size();
    }
    
     //Comparar los nombre para ordenarlos alfabéticamente
    @Override
    public int compareTo(Object o) {
        return this.getNombre().compareTo(((Diseñador) o).getNombre());
    }
}
