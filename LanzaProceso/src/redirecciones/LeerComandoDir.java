package redirecciones;

import java.util.Scanner;

public class LeerComandoDir {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String linea = sc.nextLine();
		while(linea != null) {
			System.out.println("línea");
		}

		sc.close();
	}

}
