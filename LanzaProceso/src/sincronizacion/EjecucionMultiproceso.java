package sincronizacion;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class EjecucionMultiproceso {

	public final static String CARPETA = "C:\\ficheros\\ips\\";

	public static void main(String[] args) {
		generaIPs();
		String nombreFichero = "Clase";
		String[] clases = { "A", "B", "C" };
		for (int i = 0; i < clases.length; i++) {
			ProcessBuilder pb = new ProcessBuilder("java", "-classpath",
					"C:\\Users\\Usuario\\git\\repository3\\LanzaProceso\\bin", "sincronizacion.Proceso3", clases[i]);
			pb.redirectInput(new File(CARPETA + "ficheroIPs.txt"));
//			pb.redirectOutput(new File(CARPETA + nombreFichero + clases[i] + ".txt"));
			pb.redirectOutput(Redirect.INHERIT);
			pb.redirectError(Redirect.INHERIT);
			try {
				Process p = pb.start();
//				System.out.println("IPS CLASE: " + clases[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

//	private static void clasificaIPs() {
//		ProcessBuilder pb = new ProcessBuilder("java", "-classpath",
//				"C:\\Users\\Usuario\\git\\repository3\\LanzaProceso\\bin", "sincronizacion.Proceso3");
//	}

	public static void generaIPs() {

		ProcessBuilder pb = new ProcessBuilder("java", "-classpath",
				"C:\\Users\\Usuario\\git\\repository3\\LanzaProceso\\bin", "sincronizacion.Proceso1");

		pb.redirectOutput(new File(CARPETA + "ficheroIPs.txt"));
		pb.redirectError(Redirect.INHERIT);

		try {
			Process p = pb.start();
			p.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
