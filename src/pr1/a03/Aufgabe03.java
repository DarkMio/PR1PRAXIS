//																	Zier, 824320

package pr1.a03;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

import java.io.PrintWriter;

public class Aufgabe03 {

	public static void main(String[] args){
		writeIntNumberFile("pr1_03c_randInt.txt", 1000);
		writeMixedNumberFile("pr1_03c_randMix.txt", 1000, 7);
	}
	
	public static void writeIntNumberFile(String filename, int numberCount){
		buildRandom(filename, numberCount, 4);
	}
	
	public static void writeMixedNumberFile(String filename, int numberCount, int width){
		buildRandom(filename, numberCount, width);
	}

	public static void buildRandom(String filename, int numberCount, int width){
		DirtyFileWriter dfw = new DirtyFileWriter(filename);
		PrintWriter out = new PrintWriter(dfw, false);
		if(numberCount % 2 == 1) { numberCount ++; }

		for(int i = 1; i <= numberCount; i++){
			double randDouble = 100.5 * Math.random();
			if (Math.random() < 0.5) {
				out.printf("%" + width + "d ", (int) randDouble);
			} else {
				out.printf("%" + width + "." + (width - 4) + "f ", randDouble);
			}
			if(i % 10 == 0) { out.println(); }
		}
		dfw.close();
	}
}
