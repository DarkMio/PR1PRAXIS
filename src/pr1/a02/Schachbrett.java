package pr1.a02;
 
import java.io.PrintWriter;
 
public class Schachbrett {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		printSchachbrett(out);
		printSchachbrettReverse(out);
		printSchachbrett();
		printSchachbrettReverse();
	}

	public static void printSchachbrett(){
		PrintWriter out = new PrintWriter(System.out, true);
		buildChecker('A', 'H', 8, out);
	}


	public static void printSchachbrettReverse(){
		PrintWriter out = new PrintWriter(System.out, true);
		buildChecker('H', 'A', 8, out);
	}

	public static void printSchachbrett(PrintWriter out){
		buildChecker('A', 'H', 8, out);
	}


	public static void printSchachbrettReverse(PrintWriter out){
		buildChecker('H', 'A', 8, out);
	}

	public static void buildChecker(char fromLetter, char toLetter, int columns, PrintWriter out){
		out.println("Checkerboard from " + fromLetter + " to " + toLetter + ":\n-------------------------");

		for(int delta = Math.abs(fromLetter - toLetter); delta >= 0; delta--){
			char curLetter;
			if(fromLetter > toLetter){
				curLetter = (char)((int)toLetter + delta);
				} else {
				curLetter = (char)((int)toLetter - delta);
			}

			for(int count = 1; count <= columns; count++){
				out.print("" + curLetter + count + " ");
			}
			out.print("\n");

		}
		out.println("\n");
	}
}