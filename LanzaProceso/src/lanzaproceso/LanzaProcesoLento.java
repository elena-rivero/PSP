package lanzaproceso;

import java.util.Arrays;
import java.io.File;
import java.io.IOException;

public class LanzaProcesoLento {

	public static void main(String[] args) {

		String[] proceso = { "java", "lanzaproceso.ProcesoLento" };
		// Le pasamos los argumentos al ProcessBuilder
		ProcessBuilder pb = new ProcessBuilder(proceso);
		pb.directory(new File(".\\bin"));

		/*
		 * Con esta llamada hacemos que el proceso herede la entrada y salida estándares
		 * del proceso padre
		 */
		pb.inheritIO();

		try {
			// Arrancamos el proceso
			Process p = pb.start();
			
			while(p.isAlive()) {
				System.out.println("El proceso está ejecutándose");
				Thread.sleep(3000);
			}

			System.out.println("Destruimos el proceso.");
			p.destroy();
			
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
