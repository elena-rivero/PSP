package lanzaproceso;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedireccionRuntime {

	public static void main(String[] args) {
//		ProcessBuilder pb = new ProcessBuilder("java", "lanzaproceso.Actividad1");
//		pb.directory(new File(".\\bin"));
		
//		pb.redirectInput(new File("C:\\ficheros\\argumentos.txt"));
//		pb.redirectOutput(Redirect.INHERIT);
//		String[] comando = {"cmd", "/C", "cd"};
		Runtime r = Runtime.getRuntime();
		
		try {
//			Process p = pb.start();
			Process p = r.exec(args);
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			FileWriter fw = new FileWriter(new File("C:\\ficheros\\salida.txt"));
			BufferedWriter bw = new BufferedWriter(fw);
			
			int retorno = p.waitFor();
			System.out.println(retorno);
			
			String line = br.readLine();
			while (line != null) {
				bw.write(line);
				bw.newLine();
				line = br.readLine();
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
