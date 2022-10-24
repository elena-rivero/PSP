package sincronizacion;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CuentaCaracteres {

	public static void main(String[] args) {
		try {
			// Tomo el primer argumento como carácter, para luego compararlo con los
			// caracteres que me encuentro en el texto
			String caracter = args[0];
			
			// En numCaracteres llevaré la cuenta del carácter que se ha introducido por argumentos
			int numCaracteres = 0;
			
			// En caracterLeido guardaré cada carácter leído del texto
			String caracterLeido;
			int caracterNumero;
			
			// Abro para su lectura el fichero texto_largo.txt
			FileReader fr = new FileReader("C:\\ficheros\\texto_largo.txt");
			
			// Mientras siga habiendo caracteres para leer
			caracterNumero = fr.read();
			while (caracterNumero != -1) {
				// Paso todos los caracteres a minúscula para facilitar la comparación
				caracterLeido = String.valueOf((char) caracterNumero).toLowerCase();
				if(caracterLeido.equals(caracter)) {
					numCaracteres++;
				}
				caracterNumero = fr.read();
			}
			
			System.out.println("El carácter " + caracter + " aparece " + numCaracteres + " veces.");

			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero especificado");
		} catch (IOException e) {
			System.out.println("Se ha producido un error durante la lectura del fichero");
			e.printStackTrace();
		}

	}

}
