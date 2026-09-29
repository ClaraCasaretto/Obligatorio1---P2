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
                    this.registrarFicha();
                    break;

                case "4":
                    this.crearMural();
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
               
        System.out.println("============== ¡Diseñador registrado! ==============");
        System.out.println("=============== Datos del Diseñador: ===============");
        System.out.println("Nombre: " + nombre);
        System.out.println("Dirección: " + direccion);
        System.out.println("Mail: " + mail);
        System.out.println("====================================================");  
        
        Diseñador diseñador = new Diseñador(nombre, direccion, mail);
        sistema.actualizarListaDiseñadores(diseñador);
    }
    
    private void registrarFicha(){
        String nombre = "";
        String color;
        String diseñoChico = "";
        String diseñoGrande = "";

        
        System.out.println("====================================================");
        System.out.println("============== REGISTRAR NUEVA FICHA ===============");
        System.out.println("============ Ingrese nombre de la ficha: ============");
        nombre = sc.nextLine().toUpperCase();
        
        while(sistema.existeFicha(nombre)){
            System.out.println("============= ¡Ya existe esa ficha! ============");
            System.out.println("============= Ingrese otro nombre: ==============");            
            nombre = sc.nextLine().toUpperCase();
        }
        
        //validacion si es un color que se puede. Estos son los que se pueden: 
        //"R: rojo, "A": azul, "B": blanco, "N": negro, "M": amarillo, "V": verde,
        //"G": magenta, "C": celeste
        System.out.println("========== Ingrese el color de la ficha: ===========");
        System.out.println("R: Rojo | A: Azul | B: Blanco | N: Negro");
        System.out.println("M: Amarillo | V: Verde | G: Magenta | C: Celeste");
        System.out.println("====================================================");
        color = sc.nextLine().toUpperCase();
        
        while (!color.equals("R") && !color.equals("A") && !color.equals("B") && 
               !color.equals("N") && !color.equals("M") && !color.equals("V") && 
               !color.equals("G") && !color.equals("C")) {
            System.out.println("====================================================");
            System.out.println("================ Color inválido ====================");
            System.out.println("R: Rojo | A: Azul | B: Blanco | N: Negro");
            System.out.println("M: Amarillo | V: Verde | G: Magenta | C: Celeste");
            System.out.println("================ Ingrese otro color: ===============");
            color = sc.nextLine().toUpperCase();
        }
        
        //validar lo de diseño chico o grande
        System.out.println("====================================================");
        System.out.println("===== Ingrese el diseño chico (9 caracteres): =====");
        diseñoChico = sc.nextLine();
        while (diseñoChico.length() != 9) {
            System.out.println("====================================================");
            System.out.println("================= Diseño inválido ==================");
            System.out.println("== El diseño debe tener exactamente 9 caracteres. ==");
            System.out.println("=============== Ingrese nuevamente: ================");
            diseñoChico = sc.nextLine();
        }
        
        System.out.println("====================================================");
        System.out.println("==== Ingrese el diseño grande (25 caracteres): ====");
        diseñoGrande = sc.nextLine();
            while (diseñoGrande.length() != 25) {
                System.out.println("====================================================");
                System.out.println("================= Diseño inválido ==================");
                System.out.println("= El diseño debe tener exactamente 25 caracteres. =");
                System.out.println("=============== Ingrese nuevamente: ================");
                diseñoGrande = sc.nextLine();
            }
        
        System.out.println("====================================================");
        System.out.println("================ ¡Ficha registrada! ================");
        System.out.println("================ Datos de la ficha: ================");
        System.out.println("Nombre: " + nombre);
        System.out.println("Color: " + color);
        System.out.println("Diseño Chico: " + diseñoChico);
        System.out.println("Diseño Grande: " + diseñoGrande);
        System.out.println("====================================================");
        
        Ficha ficha = new Ficha(nombre, diseñoChico, diseñoGrande, color);
        sistema.actualizarListaFichas(ficha);
    }
    
    
    /*
    Se elige el diseñador, nombre del mural (único), y tipo de formato 
    ("D", "R", "F", "B" o "M"). Cada mural tiene inicialmente 2 fichas diferentes
    que se seleccionan. Las 2 fichas se distribuyen según indique el tipo de formato:
    */
    public void crearMural(){
        Diseñador diseñador;
        int opcionDiseñador;
        String nombre = "";
        char formato;
        
        System.out.println("====================================================");
        System.out.println("================ CREACIÓN DEL MURAL ================");
        System.out.println("============== Seleccione un diseñador: ============");
        for(int i= 0; i< sistema.getListaDiseñador().size(); i++){
            System.out.println((i+1) + ")" + sistema.getListaDiseñador().get(i).getNombre());
        }
        System.out.println("============ Ingrese número del diseñador: ==========");    
        opcionDiseñador = Integer.parseInt(sc.nextLine());
        while (opcionDiseñador < 1 || opcionDiseñador > sistema.getListaDiseñador().size()) {
            System.out.println("====================================================");
            System.out.println("======= Opción inválida. Ingrese nuevamente: =======");
            opcionDiseñador = Integer.parseInt(sc.nextLine());
        }
        diseñador = sistema.getListaDiseñador().get(opcionDiseñador - 1);

        System.out.println("====================================================");
        System.out.println("============= Ingrese nombre del mural: ============");
        nombre = sc.nextLine().toUpperCase();
        
        while(sistema.existeMural(nombre)){
            System.out.println("====================================================");
            System.out.println("============== ¡Ya existe ese mural! ===============");
            System.out.println("=============== Ingrese otro nombre: ===============");            
            nombre = sc.nextLine().toUpperCase();
        }
        
        System.out.println("====================================================");
        System.out.println("============ Seleccione tipo de formato: ===========");
        System.out.println("D - Damero");
        System.out.println("R - Random");
        System.out.println("F - Alternado por filas");
        System.out.println("B - Borde exterior");
        System.out.println("M - Manual");
        
        formato = sc.nextLine().toUpperCase().charAt(0);

        while(formato != 'D' && formato != 'R' && formato != 'F' && 
              formato != 'B' && formato != 'M'){
            System.out.println("====================================================");
            System.out.println("=============== Formato inválido ===================");
            System.out.println("============= Ingrese D, R, F, B o M: ==============");
            formato = sc.nextLine().toUpperCase().charAt(0);
        }
        
        System.out.println("========== Seleccione 2 fihcas iniciales: ==========");
    }
}
