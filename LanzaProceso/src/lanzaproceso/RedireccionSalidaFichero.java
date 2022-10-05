package lanzaproceso;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class RedireccionSalidaFichero {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("java", "-classpath", "D:\\Programación\\LanzaProceso\\bin", "lanzaproceso.Actividad1");
		
//		pb.directory(new File("C:\\ficheros"));
//		pb.redirectInput(new File("C:\\ficheros\\argumentos.txt"));
		pb.redirectInput(Redirect.INHERIT);
		pb.redirectOutput(new File("C:\\ficheros\\salida.txt"));
		
		try {
//			pb.directory(new File(".\\bin"));
			Process p = pb.start();
			p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
