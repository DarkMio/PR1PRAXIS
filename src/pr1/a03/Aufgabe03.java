//																	Zier, 824320
// Fragen an Schimkat: Random bei mixedIntNumberFile? Numbercount erhöhen (geradzahlig)?

package pr1.a03;

import java.io.PrintWriter;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

public class Aufgabe03 {

	public static void main(String[] args){
		writeIntNumberFile("03c_randInt.txt", 1000);
		writeMixedNumberFile("03c_randMix.txt", 1000, 7);
	}
	
	public static void writeIntNumberFile(String filename, int numberCount){
		buildRandom(filename, numberCount, 3);
	}
	
	public static void writeMixedNumberFile(String filename, int numberCount, int width){
		buildRandom(filename, numberCount, width);
	}
	
	public static void buildRandom(String filename, int numberCount, int width){
		DirtyFileWriter dfw = new DirtyFileWriter(filename);
		PrintWriter out = new PrintWriter(dfw, false);
		if(numberCount % 2 == 1) { numberCount ++; }

		for(int i = 1; i <= numberCount; i++){
			double randInt = 10.5 * Math.random();
			out.printf("%" + width + "." + (width-3) + "f ", randInt);
			if(i % 10 == 0) { out.println(); }
		}
		dfw.close();
	}
}
