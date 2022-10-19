package redirecciones;

import java.util.Scanner;

public class LeerComandoDir {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String linea = "";
		String[] array = null;
		while(sc.hasNextLine()) {
			linea = sc.nextLine();
			System.out.println(linea);
			array = linea.split(" ");
			System.out.println(array[0]);
		}

		Math.random();
	
	}

}
