package tarea5unidad2;

public class rectangle {

	String area (double base, double high) {
		double area = base * high;
		return String.format("\n AREA \nBase: " + base + "\nAltura: " + high + "\nArea: " + area);
	}
	
	String area (int base, int high) {
		int area = base * high;
		return String.format("\n AREA ENTERA\nBase: " + base + "\nAltura: " + high + "\nArea: " + area);
	}
	
	String perimeter (double base, double high) {
		double perimeter = (2 * base) + (2 * high);
		return String.format("\n PERIMETRO DOUBLE \nBase: " + base + "\nAltura: " + high + "\nPerimetro: " + perimeter);
	}
	
	String perimeter (int base, int high) {
		int perimeter = (2 * base) + (2 * high);
		return String.format("\n PERIMETRO ENTERO \nBase: " + base + "\nAltura: " + high + "\nPerimetro: " + perimeter);
	}
	
	public static void getRectangleInfo(){
		rectangle rectangle = new rectangle();
		
		System.out.println("\nRECTANGULO");
		System.out.println(rectangle.area(10, 33));
		System.out.println(rectangle.area(8.56, 20.32));
		
		System.out.println(rectangle.perimeter(10, 33));
		System.out.println(rectangle.perimeter(8.56, 20.32));
	}
}