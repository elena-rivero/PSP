package sincronizacion;

import java.util.Scanner;

public class Proceso3 {

	public static void main(String[] args) {
		String ipsClasificadas = ipsClasificadas(args[0]);
//		System.out.println(ipsClasificadas);
//		System.out.flush();
	}
	public static String ipsClasificadas(String clase) {
		Scanner sc = new Scanner(System.in);
		String ipsClasificadas="";
		while(sc.hasNextLine()) {
			try {
//				Thread.sleep(1000);
				String ip = sc.nextLine();
				int primerOcteto = Integer.parseInt(ip.split("\\.")[0]);
				if(primerOcteto<=127 && clase.equals("A")) {
					System.out.println(ip);
//					ipsClasificadas += ip + "\n";
				} else if(primerOcteto>127 && primerOcteto<=191 && clase.equals("B")) {
					System.out.println(ip);
//					ipsClasificadas += ip + "\n";
				} else if(primerOcteto>191 && primerOcteto<=223 && clase.equals("C")) {
					System.out.println(ip);
//					ipsClasificadas += ip + "\n";
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		sc.close();
		return ipsClasificadas;
	}
	
//	while(sc.hasNextLine()) {
//		String clase="";
//		String ip = sc.nextLine();
//		int primerOcteto = Integer.parseInt(ip.split("\\.")[0]);
//		if(primerOcteto<=127) {
//			clase="A";
//		} else if(primerOcteto<=191) {
//			clase="B";
//		} else {
//			clase="C";
//		}
//		System.out.println(ip + " " + clase);
//	}

}
