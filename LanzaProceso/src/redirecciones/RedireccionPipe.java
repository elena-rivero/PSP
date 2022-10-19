package redirecciones;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

public class RedireccionPipe {

	public static void main(String[] args) {
		List<ProcessBuilder> lpb = new ArrayList<ProcessBuilder>();

		ProcessBuilder pb1 = new ProcessBuilder("cmd", "/C", "tasklist");
		ProcessBuilder pb2 = new ProcessBuilder("java", "-classpath", "C:\\Users\\Usuario\\git\\repository3\\LanzaProceso\\bin",
				"redirecciones.LeerComandoDir");

		pb1.redirectError(Redirect.INHERIT);
		pb2.redirectError(Redirect.INHERIT);
		pb2.redirectOutput(Redirect.INHERIT);
		lpb.add(pb1);
		lpb.add(pb2);
		pb2.redirectOutput(Redirect.INHERIT);
		
		try {
			ProcessBuilder.startPipeline(lpb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
