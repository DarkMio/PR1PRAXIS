package pr1.a02;

import java.io.PrintWriter;

public class SomeFunctions {

	public static void main(String[] args){
		printRange(2, 6);
	}
	
	public static double kreisUmfang(double radius){
		return 2 * Math.PI * radius;
	}
	
	public static double rechteckUmfang(double a, double b){
		return 2*a+2*b;
	}
	
	public static double rechteckFlaeche(double a, double b){
		return a*b;
	}
	
	public static void printRange(double a, double b){
		PrintWriter out = new PrintWriter(System.out, true);
		for(double carenum = a; carenum <= b; carenum++){
			double kUmfang = kreisUmfang(carenum);
			double rUmfang = rechteckUmfang(carenum, b);
			double rFlaeche = rechteckFlaeche(carenum, b);
			out.println("For a " + carenum + " and b = " + b);
			out.println("\tKreisumfang von a = " + carenum + ": " + kUmfang);
			out.println("\tRechtecksumfang von a=" + carenum + " und b=" + b + ": " + rUmfang);
			out.println("\tRechtecksfläche von a=" + carenum + " und b=" + b + ": " + rFlaeche);
		}
	}
}
