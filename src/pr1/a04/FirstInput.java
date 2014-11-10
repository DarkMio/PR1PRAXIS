package pr1.a04;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class FirstInput {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // Proper number handling
        //scannerAusprobieren();
        String doubleNumbers = "3.2 44.0 12.3 24.3 0.243 68.234 12.4 55.555 38.12";
        String intNumbers = "9 12 42 3 5 24 13 77 98";
        DirtyFileReader dfr = new DirtyFileReader("03c_randMix.txt");
        Scanner in = new Scanner(doubleNumbers);
        Scanner fin = new Scanner(dfr);
        PrintWriter out = new PrintWriter(System.out, true);
        System.out.println(countSumOf(in));
        System.out.println(countSumOf(doubleNumbers));
        printNumbersFrom(fin, 8, 4, out);
        fin.close();

        copyNumberFile(15, 7, "03c_randMix.txt", "04b2_copyNumber.txt");
    }

    public static void scannerAusprobieren() {
        PrintWriter out = new PrintWriter(System.out, true);
        DirtyFileReader dfr = new DirtyFileReader("./testfiles/zahlen01.txt");
        Scanner in = new Scanner(dfr);

        String intNumbers = "9 12 42 3 5 24 13 77 98";
        String doubleNumbers = "3.2 44.0 12.3 24.3 0.243 68.234 12.4 55.555 38.12";
        String mixedNumbers = "9.0 12 42.342 3 5 24.12 13.66 77 98";
        out.println("-- scannerRead(intNumbers) --");
        provideScanner(intNumbers, out);
        out.println("\n-- scannerRead(doubleNumbers) --");
        provideScanner(doubleNumbers, out);
        out.println("\n-- scannerRead(mixedNumbers) --");
        provideScanner(mixedNumbers, out);
        out.println("\n-- scannerRead(dfr) --");
        scannerRead(in, out);
    }

    public static void provideScanner(String string, PrintWriter out) {
        Scanner in = new Scanner(string);
        scannerRead(in, out);
    }

    public static void scannerRead(Scanner in, PrintWriter out) {
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int i = in.nextInt();
                out.println("Integer:  " + i);
                continue;
            }
            if (in.hasNextDouble()) {
                double d = in.nextDouble();
                out.println("Float:    " + d);
                continue;
            }
            String token = in.next();
            out.println("[ " + token + "]");
        }
    }

    public static int countSumOf(Scanner in) {
        double d = 0;
        while(in.hasNext()) {
            d += in.nextDouble();
        }
        if(d % 1 != 0) {
            System.out.println("WARNING: Converted double with fractional digits.");
        }
        return (int) d;
    }

    public static int countSumOf(String string) {
        Scanner in = new Scanner(string);
        return countSumOf(in);
    }

    public static void printNumbersFrom(Scanner in, int width, int precision, PrintWriter out) {
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
    }
    public static void copyNumberFile(int width, int precision, String filenameIn, String filenameOut) {
        DirtyFileReader dfr = new DirtyFileReader(filenameIn);
        Scanner in = new Scanner(dfr);
        DirtyFileWriter dfw = new DirtyFileWriter(filenameOut);
        PrintWriter fout = new PrintWriter(dfw, false);

        printNumbersFrom(in, 15, 7, fout);
        in.close();
    }
}
