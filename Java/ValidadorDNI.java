import java.util.Scanner;

public class ValidadorDNI {

	public static boolean validarDNI(String DNI) {
		
		char[] letrasDNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };
		
		if (DNI.charAt(8) == letrasDNI[Integer.parseInt(DNI.substring(0, 8)) % 23])
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String dni;

		System.out.print("DNI: ");
		dni = sc.nextLine();
		
		if (dni.length() != 9) {
			System.out.println("Formato DNI incorrecto.");
		} else {
			if (validarDNI(dni))
				System.out.println("DNI correcto.");
			else
				System.out.println("DNI incorrecto");
		}
		
		sc.close();
	}
}
