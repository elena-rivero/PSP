package sincronizacion;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

public class MultiprocesosIPs {

	public final static String CARPETA = "C:\\ficheros\\ips\\";
	public final static String SALIDA = "Clase";

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		List<Process> procesos = new ArrayList<Process>();
		for (int i = 0; i < 5; i++) {
			ProcessBuilder pb = new ProcessBuilder("java", "-classpath",
					"C:\\Users\\Usuario\\git\\repository3\\LanzaProceso\\bin", "sincronizacion.Proceso1");

//			pb.redirectOutput(new File(CARPETA+"ficheroIPs.txt"));
			pb.redirectOutput(Redirect.appendTo(new File(CARPETA + "ficheroIPs" + i + ".txt")));
			pb.redirectError(Redirect.INHERIT);

			try {
				Process p = pb.start();
				procesos.add(p);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int contTerminado = 0;
		while (contTerminado < 5) {
			contTerminado = 0;
			for (int i = 0; i < procesos.size(); i++) {
				Process proc = procesos.get(i);
				if (!proc.isAlive()) {
					contTerminado++;
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			String[] clases = { "A", "B", "C" };
			for (int j = 0; j < clases.length; j++) {
				ProcessBuilder pb = new ProcessBuilder("java", "-classpath",
						"C:\\Users\\Usuario\\git\\repository3\\LanzaProceso\\bin", "sincronizacion.Proceso3",
						clases[j]);
				pb.redirectInput(new File(CARPETA + "ficheroIPs" + i + ".txt"));
				pb.redirectOutput(Redirect.appendTo(new File(CARPETA + SALIDA + clases[j] + ".txt")));
				pb.redirectError(Redirect.INHERIT);

				try {
					pb.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		long fin = System.currentTimeMillis();
		System.out.println(fin-inicio);
	}

}
