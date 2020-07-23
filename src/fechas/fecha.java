package fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class fecha {
	
	int day;
	int month;
	int year;
	
	public void cutDate(String date){
		String tokens = "[-/]";
		String[] cutdate = date.split(tokens);
		int aux = Integer.parseInt(cutdate[0]); 
		day = aux;
		int aux2 = Integer.parseInt(cutdate[1]); 
		month = aux2;
		int aux3 = Integer.parseInt(cutdate[2]); 
		year = aux3;
		if (isValidDate() ){
			return ;
		}
		else{
			System.out.println("FORMATO DE FECHA NO VALIDO");
			System.exit(0);
		}
	}
	
	public boolean isValidDate() {
	    try {
	        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
	        dateformat.setLenient(false);
	        dateformat.parse(day + "/" + month+ "/" + year);
	        return true;
	    } catch (ParseException e) {
	    	return false;
	    }
	}
		
	public boolean isLeapYear(int year){
		if((year % 4 == 0) && ((year % 100 != 0) || (year% 400 == 0)))
			return true;
		else
			return false;
	}
	
	public int daysPerMonth(int year, int month){
		int[] mesesa =  {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; //365
		int[] mesesb = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }; //366
		
		if(isLeapYear(year)){
			return mesesb[month]; 
		}
		else{
			return mesesa[month];
		}	
	}
	
	public void sumDays(int addDays){
		
	   int currentDay= day;
	   int currentMonth = month;
	   int currentYear = year;	
	   
	   int numDias=daysPerMonth(year, month-1); //Resta uno para tener el indice corecto del arreglo
	   
	   if((currentDay+addDays)<numDias){ //Si el número de días a sumar no sobrepasa el limite de días del mes
		   	currentDay=(currentDay+addDays); //Se hace una suma en el número de día
		   	System.out.println("Nueva fecha: "+ currentDay+"/"+ currentMonth+"/"+ currentYear);
	   }
	   else{
		   currentDay = currentDay + addDays; //Suma el total de dias
		   while(currentDay > numDias){ //Mintras la suma sea mayor al limite de días del mes actual
			   currentDay = currentDay -numDias; //Se resta al total el limite de días del mes actual
			   if((currentMonth+1)>=13){ //Si el mes es mayor a 12 se hace un ajuste de mes y año
					currentMonth=1; //Comienza en enero nuevamente
					currentYear=currentYear+1; //Se pasa al siguiente año
			   }
			   else if((currentMonth+1)<13){ //Sino solo se pasa al siguiente mes
			             currentMonth=currentMonth+1;
			   }
			   numDias=daysPerMonth(year, currentMonth-1); //Se obtiene el nuevo limite de días del mes
		   }		  
		System.out.println("Nueva fecha: "+ currentDay+"/"+ currentMonth+"/"+ currentYear);
	}
	}
	
	public void subDays(int removeDays){
		
		   int currentDay= day;
		   int currentMonth = month;
		   int currentYear = year;	
		   
		   int numDias=daysPerMonth(year, month-1); //Resta uno para tener el indice corecto del arreglo
		   
		   if((currentDay+removeDays)>0){ //Si el número de días a sumar no es negativo
			   	currentDay=(currentDay+removeDays); //Se hace la resta al número de día
			   	System.out.println("Nueva fecha: "+ currentDay+"/"+ currentMonth+"/"+ currentYear);
		   }
		   else{ //Si el numero es negativo
			   currentDay = currentDay + removeDays; //Se obtiene el total de dias a restar en negativo
			   while(currentDay <= 0) //Hasta que el día actual sea un numero positivo
			   {
			   if (currentMonth-1 <= 0){ //Si el mes anterior es menor o igual a 0
				   currentMonth=12; //regresa a diciembre
				   currentYear=currentYear-1; //regresa un año
			   }
			   else //sino
				   currentMonth=currentMonth-1; //regresa solo un mes
			   
			   numDias=daysPerMonth(year, currentMonth-1); //actaliza limite de dias
			   
			   currentDay = currentDay + numDias; //al total a restar se suma el limite del nuvo mes
			   }
			   
			   System.out.println("Nueva fecha: "+ currentDay+"/"+ currentMonth+"/"+ currentYear);
		   }
		}
}
