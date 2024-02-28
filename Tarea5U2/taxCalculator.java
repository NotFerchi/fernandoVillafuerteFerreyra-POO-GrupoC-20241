/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea5unidad2;

/**
 *
 * @author ferch
 */
public class taxCalculator {
	
    String calculateTaxes(int income) {
        double taxes = income + 0.15;
        return String.format("\nINCOME\nIncome: " + income + "\nImpuestos: " + taxes);
    }

    String calculateTaxes(double sales, double taxPercentage) {
        double taxes = sales * (taxPercentage / 100);
        return String.format("\nVENTA + IMPUESTO PORCENTAJE - -\nVentas: " + sales +"\nImpuestos porcentaje: " + taxPercentage + "\nimpuestos: " + taxes);
    }

    String calculateTaxes(double dividends, double taxPercentage, double exemption) {
        double taxes = dividends * (taxPercentage / 100);
        if (taxes > exemption) {
        	
            return String.format("\nDIVIDENDOS + IMPUESTO PORCENTAJE\nDividendos: " + dividends +"\nImpuestos Porcentaje: " + taxPercentage +"\nExcepcion: " + exemption + "\nIMPUESTOS: " + taxes);
        } else {
            return "\nCALCULO IMPUESTOS\nNo impuestos";
        }
    }
    
    public static void getTaxCalculatorInfo(){
		taxCalculator taxCalculator = new taxCalculator();
		
		System.out.println("\n\nCALCULO IMPUESTOS");
		System.out.println(taxCalculator.calculateTaxes(175));
		System.out.println(taxCalculator.calculateTaxes(155, 230));
		System.out.println(taxCalculator.calculateTaxes(123, 155, 45));
    }
	
}