package tarea5unidad2;



/**
 *
 * @author ferch
 */
public class employee {
	
	String calculateSalary(double baseSalary){
		
		return String.format("\nSALARIO BASE\nSalario: " + baseSalary);
	}
	
	String calculateSalary(double baseSalary, double bonus){
		double total = baseSalary + bonus;
		return String.format("\nSALARIO BASE + BONUS \nSalario: " + baseSalary + "\nBonus: " + bonus + "\nTotal: " + total);
	}
	
	
	String calculateSalary(double baseSalary, double bonus, int extraHours){
		double total = baseSalary + bonus + (extraHours * 20);
		return String.format("\n SALARIO BASE + BONUS + HORAS EXTRA\nSalario: " + baseSalary + "\nBonus: " + bonus + "\nHoras Extra: "+ extraHours +"\nTotal: " + total);
	}
	
	public static void getEmployeeInfo(){
		employee employee = new employee();
		
		System.out.println("\n\nEMPEADOS");
		System.out.println(employee.calculateSalary(275));
		System.out.println(employee.calculateSalary(275,35));
		System.out.println(employee.calculateSalary(275,35,3));
	}

}
