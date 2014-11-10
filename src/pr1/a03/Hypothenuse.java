//																	Zier, 824320

package pr1.a03;

import java.io.PrintWriter;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

public class Hypothenuse {
	
	public static void main(String[] args){
		DirtyFileWriter dfw = new DirtyFileWriter("03b_hypothenuse.txt");
		// PrintWriter in file
		PrintWriter fout = new PrintWriter(dfw, false);
		// PrintWriter in console
		PrintWriter out = new PrintWriter(System.out, true);
		testHypothenuse(10, 3, out);
		testHypothenuse(10, 3, fout);
		dfw.close();
	}
	
	public static double hypothenuse(double k1, double k2){
		return Math.sqrt(Math.pow(k1, 2) + Math.pow(k2, 2));
	}
	
	public static void printHypothenuse(
			double k1,
			double k2,
			int width,
			int precision,
			PrintWriter out
			){
		out.printf("%" + width + "." + precision + "f", // construct: "%9.4f"
				hypothenuse(k1, k2));
	}
	
	public static void testHypothenuse(int width, int precision, PrintWriter out){
		// k1 = Katethe 1 - Rows
		for(int k1 = 0; k1 <= 10; k1++){
			// k2 = Katethe 2 - Columns
			for(int k2 = 0; k2 <= 10; k2++){
				if(k1 == 0 && k2 == 0){
					for(int i = 1; i <= width; i++){
						out.print(" ");
					}
				} else {
					printHypothenuse(k1, k2, width, precision, out);
				}
				// a nice breaker as table
				if(k2 == 0){out.print(" |");}
			}
			out.println();
			
			// after printing the first line (+ linebreak), we give a line as table
			if(k1 == 0){
				for(int breaker = (width*11)+3; breaker > 0; breaker--){
					out.print("-");
					}
				out.println();
			}
		}
	}
}
