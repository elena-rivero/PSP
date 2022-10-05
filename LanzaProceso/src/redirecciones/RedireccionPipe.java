package redirecciones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RedireccionPipe {

	public static void main(String[] args) {
		List<ProcessBuilder> lpb = new ArrayList<ProcessBuilder>();

		ProcessBuilder pb1 = new ProcessBuilder("cmd", "/C", "dir");
		ProcessBuilder pb2 = new ProcessBuilder("java", "-classpath", "D:\\Programación\\LanzaProceso\\bin",
				"redirecciones.LeerComandoDir");

		lpb.add(pb1);
		lpb.add(pb2);
		try {
			ProcessBuilder.startPipeline(lpb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
