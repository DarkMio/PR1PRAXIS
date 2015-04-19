//																	Zier, 824320
package pr1.a04;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class FirstInput {

    public static void main(String[] args) {
        // Proper number handling:
        Locale.setDefault(Locale.US);

        String csoFilename = "./testfiles/pr1_zahlen01.txt";
        Scanner randMixFin = provideScanner("pr1_03c_randInt.txt");
        Scanner randIntFin = provideScanner("pr1_03c_randInt.txt");
        Scanner csoIn = provideScanner(csoFilename);

        PrintWriter out = new PrintWriter(System.out, true);

        out.println("countSumOf ./testfiles/pr1_zahlen01.txt");
        out.println(countSumOf(csoIn));
        out.println(countSumOf(csoFilename));

        out.println("\nReading and printing pr1_03c_randMix.txt:");
        printNumbersFrom(randMixFin, 8, 4, out);
        randMixFin.close();

        out.println("\nReading and printing pr1_03c_randInt.txt:");
        printNumbersFrom(randIntFin, 4, 4, out);
        randIntFin.close();

        copyNumberFile("pr1_03c_randMix.txt", "pr1_04b2_copyNumber.txt");
    }

    public static Scanner provideScanner(String filename) {
        DirtyFileReader dfr = new DirtyFileReader(filename);
        return new Scanner(dfr);
    }

    public static int countSumOf(Scanner in) {
        double d = 0;
        while(in.hasNext()) {
            d += in.nextDouble();
        }
        in.close();
        return (int) d;
    }

    public static int countSumOf(String filename) {
        return countSumOf(provideScanner(filename));
    }

    public static void printNumbersFrom(Scanner in, int width, int precision, PrintWriter out) {
        // assuming input is accurate and always int or double
        for(int cnt = 1; in.hasNext(); cnt ++) {
            if(in.hasNextInt()){
                out.printf("%" + width + "d ", in.nextInt());
            } else {
                out.printf("%" + width + "." + precision + "f ", in.nextDouble());
            }

            if(cnt % 10 == 0) {
                out.println();
            }
        }
        in.close();
    }

    public static void copyNumberFile(String filenameIn, String filenameOut) {
        Scanner in = provideScanner(filenameIn);
        DirtyFileWriter dfw = new DirtyFileWriter(filenameOut);
        PrintWriter fout = new PrintWriter(dfw, false);

        printNumbersFrom(in, 15, 7, fout);
    }
}
