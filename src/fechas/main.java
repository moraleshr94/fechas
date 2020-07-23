package fechas;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String fecha;
		int dias;
		fecha fes = new fecha();
		
		Scanner leer = new Scanner(System.in);
		System.out.println("Introduzca fecha con el formato DD-MM-AAAA: ");
		fecha = leer.next();
		fes.cutDate(fecha);
		
		System.out.println("Introduzca días a sumar o restar: ");
		dias = leer.nextInt();
		
		if(dias > 0)
		fes.sumDays(dias);
		else
			fes.subDays(dias);
	}
	
}
