//																	Zier, 824320

package pr1.a03;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;
import java.io.PrintWriter;

public class TestSchachbrett {

	public static void main(String[] args){
		printSchachbrett("03a_reverse.txt", true);
		printSchachbrett("03a_forward.txt", false);
	}
	
	public static void printSchachbrett(String filename, boolean isReverse){
		DirtyFileWriter dfw = new DirtyFileWriter(filename);
		PrintWriter out = new PrintWriter(dfw, false);
		
		if(isReverse){
			pr1.a02.Schachbrett.printSchachbrettReverse(out);
		} else {
			pr1.a02.Schachbrett.printSchachbrett(out);
		}
		
		dfw.close();
	}
}
