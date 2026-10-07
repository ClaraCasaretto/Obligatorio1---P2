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
        sistema.cargarDatosIniciales();
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
                    this.visualizarFichas();
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
        //Y si validamos con un try / catch?
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
    
    public void crearMural(){
        //si no inicializamos en null no nos funciona el metodo crearMural 
        Diseñador diseñador = null;
        int opcionDiseñador = 0;
        String nombre = "";
        char formato = ' ';
        Ficha ficha1 = null;
        Ficha ficha2 = null;
        int opcionFicha1 = 0;
        int opcionFicha2 = 0;
        int fila = 0;
        int columna = 0;
        int opcionFicha = 0;
        Ficha fichaElegida = null;
        
        
        //validar que haya diseñadores registrados
        if (sistema.getListaDiseñador().isEmpty()) {
            System.out.println("====================================================");
            System.out.println("======== No hay diseñadores registrados ============");
            System.out.println("===== Debe registrar un diseñador primero ==========");
            System.out.println("====================================================");
            //validar cantidad de fichas registradas
        }else if(sistema.getListaFichas().size() < 2){
            System.out.println("====================================================");
            System.out.println("========== No hay suficientes fichas ===============");
            System.out.println("===== Debe registrar al menos 2 fichas =============");
            System.out.println("====================================================");
        }
        else{
            System.out.println("====================================================");
            System.out.println("================ CREACIÓN DEL MURAL ================");
            System.out.println("============== Seleccione un diseñador: ============");
            for(int i= 0; i< sistema.getListaDiseñador().size(); i++){
                System.out.println((i+1) + ")" + sistema.getListaDiseñador().get(i).getNombre());
            }
            System.out.println("====================================================");
            System.out.println("============ Ingrese número del diseñador: ==========");
            boolean diseñadorValido = false;
            while (!diseñadorValido) {
                try {
                    opcionDiseñador = Integer.parseInt(sc.nextLine());
                    if (opcionDiseñador >= 1 
                            && opcionDiseñador <= sistema.getListaDiseñador().size()) {
                        diseñadorValido = true;
                    } else {
                        System.out.println("====================================================");
                        System.out.println("======= Opción inválida. Ingrese nuevamente: =======");
                        System.out.println("====================================================");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("====================================================");
                    System.out.println("========= Debe ingresar un número válido ===========");
                    System.out.println("====================================================");
                }
            }
            diseñador = sistema.getListaDiseñador().get(opcionDiseñador - 1);

            System.out.println("====================================================");
            System.out.println("============= Ingrese nombre del mural: ============");
            System.out.println("====================================================");
            nombre = sc.nextLine().toUpperCase();

            while(sistema.existeMural(nombre)){
                System.out.println("====================================================");
                System.out.println("============== ¡Ya existe ese mural! ===============");
                System.out.println("=============== Ingrese otro nombre: ===============");
                System.out.println("====================================================");
                nombre = sc.nextLine().toUpperCase();
            }

            System.out.println("====================================================");
            System.out.println("============ Seleccione tipo de formato: ===========");
            System.out.println("D - Damero");
            System.out.println("R - Random");
            System.out.println("F - Alternado por filas");
            System.out.println("B - Borde exterior");
            System.out.println("M - Manual");
            System.out.println("====================================================");
            
            boolean formatoValido = false;
            while (!formatoValido) {
                String entradaFormato = sc.nextLine().toUpperCase();
                if (entradaFormato.length() == 1) {
                    formato = entradaFormato.charAt(0);
                    if (formato == 'D' || formato == 'R' || formato == 'F' || 
                        formato == 'B' || formato == 'M') {
                        formatoValido = true;
                    } else {
                        System.out.println("====================================================");
                        System.out.println("=============== Formato inválido ===================");
                        System.out.println("============= Ingrese D, R, F, B o M: =============");
                        System.out.println("====================================================");
                    }
                } else {
                    System.out.println("====================================================");
                    System.out.println("=============== Formato inválido ===================");
                    System.out.println("============= Ingrese D, R, F, B o M: =============");
                    System.out.println("====================================================");
                }
            }

            System.out.println("========== Seleccione 2 fichas iniciales: ==========");
            for(int i= 0; i< sistema.getListaFichas().size(); i++){
                System.out.println((i+1) + ")" + sistema.getListaFichas().get(i).getNombre());
            }
            
            // Primera ficha
            System.out.println("====================================================");
            System.out.println("=========== Seleccione la primera ficha: ===========");
            System.out.println("====================================================");
                
            boolean ficha1Valida = false;
            while (!ficha1Valida) {
                try {
                    opcionFicha1 = Integer.parseInt(sc.nextLine());
                    if (opcionFicha1 >= 1 && opcionFicha1 <= sistema.getListaFichas().size()) {
                        ficha1Valida = true;
                    } else {
                        System.out.println("====================================================");
                        System.out.println("======= Opción inválida. Ingrese nuevamente: =======");
                        System.out.println("====================================================");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("====================================================");
                    System.out.println("========= Debe ingresar un número válido ===========");
                    System.out.println("====================================================");
                }
            }
            ficha1 = sistema.getListaFichas().get(opcionFicha1 - 1);
            
            // Segunda ficha
            System.out.println("====================================================");
            System.out.println("=========== Seleccione la segunda ficha: ===========");
            System.out.println("====================================================");

            boolean ficha2Valida = false;
            while (!ficha2Valida) {
                try {
                    opcionFicha2 = Integer.parseInt(sc.nextLine());
                    if (opcionFicha2 >= 1 && opcionFicha2 <= sistema.getListaFichas().size()
                        && opcionFicha2 != opcionFicha1) {
                        ficha2Valida = true;
                    } else {
                        System.out.println("====================================================");
                        if (opcionFicha2 == opcionFicha1) {
                            System.out.println("====== No puede seleccionar la misma ficha =======");
                        } else {
                            System.out.println("======= Opción inválida. Ingrese nuevamente: =======");
                        }
                        System.out.println("====================================================");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("====================================================");
                    System.out.println("========= Debe ingresar un número válido ===========");
                    System.out.println("====================================================");
                }
            }
            ficha2 = sistema.getListaFichas().get(opcionFicha2 - 1); 
            
            //me genera duda donde va esto:
            Mural mural = new Mural(diseñador, nombre, formato, ficha1, ficha2);
        
            //cargar mural manual
            if(formato == 'M'){
                char continuar = 'S';
                while (continuar == 'S') {
                    //Insertar fila
                    System.out.println("====================================================");
                    System.out.println("================= Ingrese la fila: =================");

                    boolean filaValida = false;
                    while (!filaValida) {
                        try {
                            fila = Integer.parseInt(sc.nextLine());
                            if (fila >= 1 && fila <= mural.getMural().length) {
                                filaValida = true;
                            } else {
                                System.out.println("====================================================");
                                System.out.println("===== Fila fuera de rango. Inserte otro número: ====");
                                System.out.println("====================================================");
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("====================================================");
                            System.out.println("========= Debe ingresar un número válido. ==========");
                            System.out.println("====================================================");
                        }
                    }

                    //Insertar columna
                    System.out.println("====================================================");
                    System.out.println("=============== Ingrese la columna: ================");

                    boolean columnaValida = false;
                    while(!columnaValida){
                        try {
                            columna = Integer.parseInt(sc.nextLine());
                            if(columna >= 1 && columna <= mural.getMural()[0].length){
                                columnaValida = true;
                            } else {
                                System.out.println("====================================================");
                                System.out.println("===== Columna fuera de rango. Inserte otro número: ====");
                                System.out.println("====================================================");
                            }
                        } catch(NumberFormatException e){
                            System.out.println("====================================================");
                            System.out.println("========= Debe ingresar un número válido ===========");
                            System.out.println("====================================================");
                        }
                    }

                    //Mostrar fichas
                    System.out.println("====================================================");
                    System.out.println("=============== Seleccione una ficha: =============");
                    System.out.println("====================================================");
                    for (int i = 0; i < sistema.getListaFichas().size(); i++) {
                        System.out.println((i + 1) + ") "
                                + sistema.getListaFichas().get(i).getNombre());
                    }

                    //Elegir ficha
                    boolean fichaValida = false;
                    while (!fichaValida) {
                        try {
                            opcionFicha = Integer.parseInt(sc.nextLine());
                            if (opcionFicha >= 1
                                    && opcionFicha <= sistema.getListaFichas().size()) {
                                fichaValida = true;
                            } else {
                                System.out.println("====================================================");
                                System.out.println("======= Opción inválida. Ingrese nuevamente. =======");
                                System.out.println("====================================================");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("====================================================");
                            System.out.println("========= Debe ingresar un número válido ===========");
                            System.out.println("====================================================");
                        }
                    }
                    fichaElegida = sistema.getListaFichas().get(opcionFicha - 1);

                    //Cargar ficha con matriz manual 
                    mural.cargarManual(fila, columna, fichaElegida);

                    //Continuar
                    System.out.println("====================================================");
                    System.out.println("========= ¿Desea agregar otra ficha? (S/N) =========");
                    System.out.println("====================================================");

                    boolean continuarValido = false;
                    while (!continuarValido) {
                        try {
                            String entrada = sc.nextLine().toUpperCase();
                            if (entrada.length() == 1) {
                                continuar = entrada.charAt(0);
                                if (continuar == 'S' || continuar == 'N') {
                                    continuarValido = true;
                                } else {
                                    System.out.println("====================================================");
                                    System.out.println("========= Debe ingresar S o N. Intente: ===========");
                                    System.out.println("====================================================");
                                }
                            } else {
                                System.out.println("====================================================");
                                System.out.println("========= Debe ingresar S o N. Intente: ===========");
                                System.out.println("====================================================");
                            }
                        } catch (Exception e) {
                            System.out.println("====================================================");
                            System.out.println("========= Debe ingresar S o N. Intente: ===========");
                            System.out.println("====================================================");
                        }
                    }
                }
            }
            sistema.getListaMurales().add(mural);
        }
    }
    
    
    public void visualizarFichas() {
        System.out.println("====================================================");
        System.out.println("================== LISTA DE FICHAS =================");
        System.out.println("====================================================");

        for (int i = 0; i < sistema.getListaFichas().size(); i++) {
            Ficha ficha = sistema.getListaFichas().get(i);

            System.out.println("Nombre: " + ficha.getNombre());
            System.out.println("Color: " + ficha.getColor());

            System.out.println("Diseño chico:");
            System.out.println(ficha.getDiseñoChico());

            System.out.println("Diseño grande:");
            System.out.println(ficha.getDiseñoGrande());

            System.out.println("----------------------------------------------------");
        }
    }
}
