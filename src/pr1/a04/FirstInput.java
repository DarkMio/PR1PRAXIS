//																	Zier, 824320
// Fragen: Unbedingt alle Dateien darstellen?
package pr1.a04;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class FirstInput {

    public static void main(String[] args) {
        String filename = "./testfiles/zahlen01.txt";

        DirtyFileReader dfr = new DirtyFileReader("03c_randMix.txt");
        Scanner fin = new Scanner(dfr);
        DirtyFileReader csoDfr = new DirtyFileReader(filename);
        Scanner in = new Scanner(csoDfr);
        PrintWriter out = new PrintWriter(System.out, true);

        // Proper number handling:
        Locale.setDefault(Locale.US);

        out.println(countSumOf(in));
        out.println(countSumOf(filename));

        printNumbersFrom(fin, 8, 4, out);
        fin.close();

        copyNumberFile("03c_randMix.txt", "04b2_copyNumber.txt");
    }

    public static int countSumOf(Scanner in) {
        double d = 0;
        while(in.hasNext()) { d += in.nextDouble(); }
        if(d % 1 != 0) {
            System.out.println("WARNING: Converted double to int with fractional digits.");
        }
        return (int) d;
    }

    public static int countSumOf(String string) {
        DirtyFileReader dfr = new DirtyFileReader(string);
        Scanner in = new Scanner(dfr);
        return countSumOf(in);
    }

    public static void printNumbersFrom(Scanner in, int width, int precision, PrintWriter out) {
        for(int cnt = 1; in.hasNext(); cnt ++) {
            if(in.hasNextInt()){
                out.printf("%" + width + "d ", in.nextInt());
            } else {
                out.printf("%" + width + "." + precision + "f ", in.nextDouble());
            }

            if(cnt % 10 == 0) { out.println(); }
        }
    }

    public static void copyNumberFile(String filenameIn, String filenameOut) {
        DirtyFileReader dfr = new DirtyFileReader(filenameIn);
        Scanner in = new Scanner(dfr);
        DirtyFileWriter dfw = new DirtyFileWriter(filenameOut);
        PrintWriter fout = new PrintWriter(dfw, false);

        printNumbersFrom(in, 15, 7, fout);
        in.close();
    }
}
