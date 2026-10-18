/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package interfaz;

import java.util.ArrayList;
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
                    this.modificarMural();
                    break;

                case "6":
                    //Visualizar mural
                    this.visualizarMural();
                    break;

                case "7":
                    //Listado de diseñadores
                    this.listarDiseñadores();
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
        sistema.agregarDiseñador(diseñador);
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
        sistema.agregarFicha(ficha);
    }
    
    public void crearMural(){
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
        if (sistema.getListaDiseñadores().isEmpty()) {
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
            for(int i= 0; i< sistema.getListaDiseñadores().size(); i++){
                System.out.println((i+1) + ")" + sistema.getListaDiseñadores().get(i).getNombre());
            }
            System.out.println("====================================================");
            System.out.println("============ Ingrese número del diseñador: ==========");
            boolean diseñadorValido = false;
            while (!diseñadorValido) {
                try {
                    opcionDiseñador = Integer.parseInt(sc.nextLine());
                    if (opcionDiseñador >= 1 
                            && opcionDiseñador <= sistema.getListaDiseñadores().size()) {
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
            diseñador = sistema.getListaDiseñadores().get(opcionDiseñador - 1);

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
                //Carga inicial con ficha VACIA
                //Revisar como consigue la ficha vacia porque ahora funciona por como esta precargado
                Ficha vacia = sistema.getListaFichas().get(sistema.getListaFichas().size()-1);
                mural.inicializarManual(vacia);
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
                    //Aca cambie porque no puede elegirse cualquier ficha, tiene que ser una de las 2 iniciales
                    boolean fichaValida = false;
                    while (!fichaValida) {
                        try {
                            opcionFicha = Integer.parseInt(sc.nextLine());
                            if (opcionFicha == 1 || opcionFicha == 2) {
                                fichaValida = true;
                                //Ahora la carga manual se da aca mismo
                                if (opcionFicha ==1){
                                    mural.cargarManual(fila, columna, ficha1);
                                }else {
                                    mural.cargarManual(fila, columna, ficha2);
                                }
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
            } else {
                mural.crearMuralInicial();
            }
            sistema.agregarMural(mural);
            mural.guardarMuralOriginal();
            diseñador.agregarMural(mural);
            System.out.println("====================================================");
            System.out.println("============= MURAL CREADO CORRECTAMENTE ===========");
            System.out.println("====================================================");
            visualizarMuralCreado(mural);
        }
    }
    
    public void modificarMural (){
        Mural mural = null;
        String opcion;
        ArrayList <Mural> listaMurales = sistema.getListaMurales();
        
        if (listaMurales.isEmpty()){
            System.out.println("====================================================");
            System.out.println("================= No existen murales ===============");
            System.out.println("====================================================");
            //Salimos de modificar mural
            return;
        }
        
        System.out.println("====================================================");
        System.out.println("=============== SELECCIONE UN MURAL ================");
        System.out.println("====================================================");
        for(int i= 0; i< sistema.getListaMurales().size(); i++){
            //estos dos en la misma linea?
            System.out.print((i+1) + ")" + listaMurales.get(i).getNombre());
            System.out.println(" by " + listaMurales.get(i).getDiseñador().getNombre());
        }
        //Seleccionamos el menu por indice
        int indice = Integer.parseInt(sc.nextLine());
        mural = sistema.seleccionarMural(indice-1);
        
        //Falta validacion del indice
        
        do {
            //Puse las opciones dentro del bucle para que se muestren de nuevo despues de ejectar una opción
            System.out.println("0 - Volver");
            System.out.println("1 - Modificar posición");
            System.out.println("2 - Modificar ficha");
            System.out.println("3 - Restaurar mural original");
            opcion = sc.nextLine();
            //Agregué visualizacion en todos los metodos como pide la letra
            switch (opcion) {
                case "0":
                    //Aca vuelve al menu anterior
                    break;

                case "1":
                    //Modificar posicion
                    modificarPosicion(mural);
                    visualizarMuralCreado(mural);
                    break;

                case "2":
                    //Modificar ficha
                    modificarFicha(mural);
                    visualizarMuralCreado(mural);
                    break;

                case "3":
                    //restaurar original
                    mural.restaurarMural();
                    visualizarMuralCreado(mural);
                    break;  
                    
                default:
                    //Si no ingresa una opcion valida despliega esto
                    System.out.println("====================================================");
                    System.out.println("======= Opción inválida. Ingrese nuevamente. =======");
                    System.out.println("====================================================");
                    break;
            }
        }while (!opcion.equals("0"));
    }
    
    public void modificarPosicion (Mural mural){
        int fila=0;
        int columna=0;
        Ficha fichaSelec = null;
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
        
        System.out.println("====================================================");
        System.out.println("=============== Seleccione la ficha: ===============");
        System.out.println("====================================================");
        for(int i= 0; i< sistema.getListaFichas().size(); i++){
            System.out.println((i+1) + ")" + sistema.getListaFichas().get(i).getNombre());
        }
        int nFicha=0;        
        boolean ficha1Valida = false;
        while (!ficha1Valida) {
            try {
                nFicha = Integer.parseInt(sc.nextLine());
                if (nFicha >= 1 && nFicha <= sistema.getListaFichas().size()) {
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
        fichaSelec = sistema.getListaFichas().get(nFicha - 1);
        //Ya con todos los datos se manda modificar la posicion
        mural.modificarPosicion (fila, columna, fichaSelec);
    }
    
    public void modificarFicha (Mural mural){
        Ficha fichaNueva = null;
        Ficha fichaVieja = null;
        
        //seleccionar que ficha va a cambiar
        System.out.println("====================================================");
        System.out.println("========== Seleccione la ficha a cambiar: ==========");
        System.out.println("====================================================");
        //buscamos las fichas usadas en el mural
        ArrayList <Ficha> fichasUsadas = mural.obtenerFichasUsadas();
        for(int i= 0; i< fichasUsadas.size(); i++){
            System.out.println((i+1) + ")" + fichasUsadas.get(i).getNombre());
        }
        //Hay que validar que la entrada sea valida
        int nFicha=0;
        boolean opcionFichaValida = false;
        while (!opcionFichaValida) {
            try {
                nFicha = Integer.parseInt(sc.nextLine());
                if (nFicha >= 1 && nFicha <= fichasUsadas.size()) {
                    opcionFichaValida = true;
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
        fichaVieja = fichasUsadas.get(nFicha - 1);
        
        //seleccion de la ficha nueva
        System.out.println("====================================================");
        System.out.println("=============== Seleccione la ficha: ===============");
        System.out.println("====================================================");
        for(int i= 0; i< sistema.getListaFichas().size(); i++){
            System.out.println((i+1) + ")" + sistema.getListaFichas().get(i).getNombre());
        }
        //Podemos repetir las variables de validacion sin problema no?
        nFicha=0;        
        opcionFichaValida = false;
        while (!opcionFichaValida) {
            try {
                nFicha = Integer.parseInt(sc.nextLine());
                if (nFicha >= 1 && nFicha <= sistema.getListaFichas().size()) {
                    opcionFichaValida = true;
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
        fichaNueva = sistema.getListaFichas().get(nFicha - 1);
        mural.reemplazarFicha(fichaVieja, fichaNueva);
    }
    
    private String obtenerColor(String color) {
        switch (color) {
            case "R":
                return "\033[31m"; // rojo
            case "A":
                return "\033[34m"; // azul
            case "B":
                return "\033[37m"; // blanco
            case "N":
                return "\033[30m"; // negro
            case "M":
                return "\033[33m"; // amarillo
            case "V":
                return "\033[32m"; // verde
            case "G":
                return "\033[35m"; // magenta
            case "C":
                return "\033[36m"; // celeste
            default:
                return "";
        }
    }
    
    
    public void visualizarMuralCreado(Mural mural) {
        System.out.println("====================================================");
        System.out.println("MURAL: " + mural.getNombre());
        System.out.println("DISEÑADOR: " + mural.getDiseñador().getNombre());
        System.out.println("====================================================");

        System.out.println("================ DISEÑO CHICO =====================");
        mostrarMural(mural, 3);

        System.out.println();
        System.out.println("================ DISEÑO GRANDE ====================");
        mostrarMural(mural, 5);

        System.out.println();
        System.out.println("Presione ENTER para continuar...");
        sc.nextLine();
    }
    
    //manu, dejarias esto aca? o lo mandamos a otra clase?
    private void mostrarMural(Mural mural, int tamañoDiseño) {
        Ficha[][] matriz = mural.getMural();
        for (int i = 0; i < matriz.length; i++) {
            // Recorremos las filas del diseño de cada ficha
            for (int filaDiseño = 0; filaDiseño < tamañoDiseño; filaDiseño++) {
                // Recorremos las fichas de una fila del mural
                for (int j = 0; j < matriz[i].length; j++) {
                    Ficha ficha = matriz[i][j];
                    String diseño;
                    if (tamañoDiseño == 3) {
                        diseño = ficha.getDiseñoChico();
                    } else {
                        diseño = ficha.getDiseñoGrande();
                    }
                    String codigoColor = obtenerColor(ficha.getColor());
                    // Recorremos las columnas del diseño de la ficha
                    for (int columnaDiseño = 0; columnaDiseño < tamañoDiseño; columnaDiseño++) {
                        int posicion = filaDiseño * tamañoDiseño + columnaDiseño;
                        char caracter = diseño.charAt(posicion);
                        if (caracter == '.') {
                            System.out.print("  ");
                        } else {
                            System.out.print(codigoColor + caracter + "\033[0m ");
                        }
                    }
                    // Separación entre fichas
                    System.out.print(" ");
                }
                System.out.println();
            }
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
            mostrarDiseño(ficha.getDiseñoChico(), 3, ficha.getColor());
            System.out.println("Diseño grande:");
            mostrarDiseño(ficha.getDiseñoGrande(), 5, ficha.getColor());
            System.out.println("====================================================");
        }
    }
    
    //manu, dejarias esto aca? o lo mandamos a otra clase?
    private void mostrarDiseño(String diseño, int columnas, String color) {
        String codigoColor = obtenerColor(color);
        for (int i = 0; i < diseño.length(); i++) {
            if (diseño.charAt(i) == '.') {
                System.out.print("  ");
            } else {
                System.out.print(codigoColor + diseño.charAt(i) + "\033[0m ");
            }
            if ((i + 1) % columnas == 0) {
                System.out.println();
            }
        }
    }
    
    public void visualizarMural(){
        Diseñador diseñador = null;
        Mural mural = null;
        int opcionDiseñador = 0;
        int opcionMural = 0;
        int tamañoDiseño = 0;
        
        if (sistema.getListaDiseñadores().isEmpty()) {
            System.out.println("====================================================");
            System.out.println("======== No hay diseñadores registrados ============");
            System.out.println("===== Debe registrar un diseñador primero ==========");
            System.out.println("====================================================");
        }else{
            System.out.println("====================================================");
            System.out.println("============ VISUALIZACIÓN DE UN MURAL =============");
            System.out.println("============== Seleccione un diseñador: ============");
            for(int i= 0; i< sistema.getListaDiseñadores().size(); i++){
                System.out.println((i+1) + ")" + sistema.getListaDiseñadores().get(i).getNombre());
            }
            System.out.println("====================================================");
            System.out.println("============ Ingrese número del diseñador: ==========");
            boolean diseñadorValido = false;
            while (!diseñadorValido) {
                try {
                    opcionDiseñador = Integer.parseInt(sc.nextLine());
                    if (opcionDiseñador >= 1 
                            && opcionDiseñador <= sistema.getListaDiseñadores().size()) {
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
            diseñador = sistema.getListaDiseñadores().get(opcionDiseñador - 1);
            //verificar que el diseñador tenga murales
            if (diseñador.getListaDeMurales().isEmpty()) {
                System.out.println("====================================================");
                System.out.println("==== Este diseñador no tiene murales registrados ===");
                System.out.println("====================================================");
            } else {
                System.out.println("====================================================");
                System.out.println("================= Murales creados: =================");
                for (int i = 0; i < diseñador.getListaDeMurales().size(); i++) {
                    System.out.println((i + 1) + ") " + diseñador.getListaDeMurales().get(i).getNombre());
                }
                System.out.println("====================================================");
                System.out.println("====== Ingrese número del mural a visualizar : =====");
                boolean muralValido = false;
                while(!muralValido){
                    try{
                        opcionMural = Integer.parseInt(sc.nextLine());
                        if (opcionMural >= 1 && opcionMural <= diseñador.getListaDeMurales().size()) {
                            muralValido = true;
                        } else {
                            System.out.println("====================================================");
                            System.out.println("======= Opción inválida. Ingrese nuevamente: =======");
                            System.out.println("====================================================");
                        }
                    }catch(NumberFormatException e){
                        System.out.println("====================================================");
                        System.out.println("========= Debe ingresar un número válido ===========");
                        System.out.println("====================================================");
                    }
                }
                mural = diseñador.getListaDeMurales().get(opcionMural - 1); 
                
                boolean tamañoValido = false;
                while (!tamañoValido) {
                    System.out.println("====================================================");
                    System.out.println("========== Seleccione el tamaño del mural ==========");
                    System.out.println("1)Diseño chico");
                    System.out.println("2)Diseño grande");
                    System.out.println("====================================================");
                    String entrada = sc.nextLine();
                    if (entrada.equals("1")) {
                        tamañoDiseño = 3;
                        tamañoValido = true;
                    } else if (entrada.equals("2")) {
                        tamañoDiseño = 5;
                        tamañoValido = true;
                    } else {
                        System.out.println("======= Opción inválida. Ingrese 1 o 2: ============");
                    }
                }
                /* ESTO NO FUNCIONA TODAVIA
                String entrada = "";
                while (!entrada.equals("S") || !entrada.equals("s")) {
                    System.out.println("====================================================");
                    if (tamañoDiseño == 3) {
                        System.out.println("================ DISEÑO CHICO =====================");
                    } else {
                        System.out.println("================ DISEÑO GRANDE ====================");
                    }
                    mostrarMural(mural, tamañoDiseño);
                    System.out.println();
                    System.out.println("Presione ENTER para cambiar de tamaño o S para salir.");
                }*/
            }
        }
    }
    
    //Listado diseñadores
    public void listarDiseñadores(){
        ArrayList<Diseñador> diseñadoresOrdenados = sistema.ordenarDiseñadores();
        for (int i = 0; i < diseñadoresOrdenados.size(); i++) {
            Diseñador diseñador = diseñadoresOrdenados.get(i);
            System.out.println("====================================================");
            System.out.println("Nombre: " + diseñador.getNombre());
            System.out.println("Dirección: " + diseñador.getDireccion());
            System.out.println("Email: " + diseñador.getEmail());
            System.out.println("Cantidad de murales: " + diseñador.cantidadDeMurales());
            System.out.println("Cantidad de fichas diferentes: " + diseñador.cantidadDeFichasDiferentes());
            System.out.println("Cantidad de colores diferentes: " + diseñador.cantidadDeColoresDiferentes());
            System.out.println("====================================================");
          }
    }
}
