package sincronizacion;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class VariosProcesos {

	public static void main(String[] args) {
		String[] proceso1 = { "cmd", "/C", "cd", "C:\\ficheros" };
		String[] proceso2 = { "cmd", "/C", "md", "carpeta7" };
		String[] proceso3 = { "cmd", "/C", "cd", "carpeta1" };
		String[] proceso4 = { "cmd", "/C", "type", "hola", ">", "carpeta7\\ficheroBlanco2.txt" };
		String[] proceso5 = { "notepad", "carpeta7\\ficheroBlanco2.txt" };
		// Le pasamos los argumentos al ProcessBuilder
//		ProcessBuilder pb1 = new ProcessBuilder(proceso1);
//		ProcessBuilder pb2 = new ProcessBuilder(proceso2);
//		ProcessBuilder pb3 = new ProcessBuilder(proceso3);
		ProcessBuilder pb4 = new ProcessBuilder(proceso4);
		ProcessBuilder pb5 = new ProcessBuilder(proceso5);

		/*
		 * Con esta llamada hacemos que el proceso herede la entrada y salida estándares
		 * del proceso padre
		 */
//		pb1.inheritIO();
//		pb2.inheritIO();
//		pb3.inheritIO();
		pb4.inheritIO();
		pb5.inheritIO();

		try {
			// Arrancamos el proceso
//			Process p1 = pb1.start();
//			p1.waitFor();			
//			Process p2 = pb2.start();
//			p2.waitFor();
//			Process p3 = pb3.start();
//			p3.waitFor();
			Process p4 = pb4.start();
			p4.waitFor();
			Process p5 = pb5.start();
			p5.waitFor();
			

		} catch (IOException e) {
			System.err.println("Error durante ejecución del proceso");
			System.err.println("Información detallada");
			System.err.println("---------------------");
			e.printStackTrace();
			System.err.println("---------------------");
			// Indicamos que la ejecución termina con error 2
			System.exit(2);
		} catch (InterruptedException e) {
			System.err.println("Proceso interrumpido");
			// Indicamos que la ejecución termina con error 3
			System.exit(3);
		}
	}

}
