/*
* Manuel Negrin - N°: 379313
* Clara Casaretto - N°: 250991
*/
package interfaz;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Main {
	public static void main(String[] args) throws UnsupportedEncodingException {
            System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));
            new InterfazConsola();
	}
}
