package lanzaproceso;

import java.util.Scanner;

public class Actividad1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca su edad:");
		String nombre = sc.nextLine();
		int edad = sc.nextInt();
		System.out.println("Hola " + nombre + ", tengo " + edad + " años.");
		sc.close();
	}

}
