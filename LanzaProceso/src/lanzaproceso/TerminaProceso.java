package lanzaproceso;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TerminaProceso {

	public static int MAX_TIEMPO = 5000;
	
	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("java", "lanzaproceso.ProcesoLento");
		pb.directory(new File(".\\bin"));
		
//		ProcessBuilder pb = new ProcessBuilder(args);
		pb.inheritIO();
//		pb.redirectErrorStream(true);
		try {
			Process p = pb.start();
			if(!p.waitFor(MAX_TIEMPO, TimeUnit.MILLISECONDS)) {
				p.destroy();
				System.out.printf("ATENCIÓN: El proceso no ha terminado en %d ms\n", MAX_TIEMPO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
