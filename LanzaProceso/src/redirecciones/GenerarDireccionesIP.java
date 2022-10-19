package redirecciones;

public class GenerarDireccionesIP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int octeto1 = (int) (Math.random()*255);
		int octeto2 = (int) (Math.random()*255);
		int octeto3 = (int) (Math.random()*255);
		
		System.out.println(octeto1 + "." + octeto2 + "." + octeto3);
	}

}
