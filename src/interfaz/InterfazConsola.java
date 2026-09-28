/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package interfaz;

import obligatorio1.Sistema;
import java.util.Scanner;
import obligatorio1.*;

public class InterfazConsola {
    
    //iniciar sistema con el menu
    
    private Sistema sistema;
    private Scanner sc;

    public InterfazConsola() {
        sistema = new Sistema();
        sc = new Scanner(System.in);
        iniciarPrograma();
    }
    
    private void iniciarPrograma() {
        String opcion = "";

        do {
            //opciones del menu cuando el usuario presiona 
            mostrarMenu();
            opcion = sc.nextLine();
             switch (opcion) {
                case "0":
                    //Terminar
                    break;
                    
                case "1":
                    //Info de autores
                    this.informacionAutores();
                    break;

                case "2":
                    //Registrar diseñador
                    this.agregarDiseñador();
                    break;

                case "3":
                    //Registrar ficha
                    break;

                case "4":
                    //Creación de mural.
                    break;

                case "5":
                    //Modificar mural
                    break;

                case "6":
                    //Visualizar mural
                    break;

                case "7":
                    //Listado de diseñadores
                    break;

                case "8":
                    //Comparar similitud de murales
                    break;

                case "9":
                    //Visualizar todas las fichas
                    break;
                    
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (!opcion.equals("0"));

    }

    private void mostrarMenu() {    
        System.out.println("====================================================");
        System.out.println("============ DISEÑADOR DE MURALES ASCII ============");
        System.out.println("======================= MENÚ =======================");
        System.out.println("0 - Terminar");
        System.out.println("1 - Información de autores");
        System.out.println("2 - Registrar diseñador");
        System.out.println("3 - Registrar ficha");
        System.out.println("4 - Crear mural");
        System.out.println("5 - Modificar mural");
        System.out.println("6 - Visualizar mural");
        System.out.println("7 - Listar diseñadores");
        System.out.println("8 - Comparar murales");
        System.out.println("9 - Visualizar fichas");
        System.out.println("====================================================");
    }
    
    private void informacionAutores() {
        System.out.println("====================================================");
        System.out.println("Información de autores del obligatorio:");
        System.out.println("Manuel Negrin - N°: 379313");
        System.out.println("Clara Casaretto - N°: 250991");
        System.out.println("====================================================");
    }
    
    private void agregarDiseñador(){
        String nombre="";
        String direccion="";
        String mail="";
        
        System.out.println("====================================================");
        System.out.println("============ REGISTRAR NUEVO DISEÑADOR ============");
        System.out.println("========== Ingrese nombre del diseñador: ==========");
        nombre = sc.nextLine().toUpperCase();
        
        //valida que no exista otro diseñador igual
        while (sistema.existeDiseñador(nombre)) {
            System.out.println("============= ¡Ya existe ese diseñador! ============");
            System.out.println("============== Ingrese otro nombre: ================");            
            nombre = sc.nextLine().toUpperCase();
        }

        System.out.println("================ Ingrese dirección: ================");
        direccion = sc.nextLine().toUpperCase();
        
        System.out.println("================== Ingrese mail: ==================");
        mail = sc.nextLine().toUpperCase();
        
        System.out.println("====================================================");        
        System.out.println("============== ¡Diseñador registrado! ==============");
        System.out.println("=============== Datos del Diseñador: ===============");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Mail: " + mail);
        System.out.println("====================================================");  
        
        Diseñador diseñador = new Diseñador(nombre, direccion, mail);
        sistema.actualizarListaDiseñadores(diseñador);
    }
    
    
}
