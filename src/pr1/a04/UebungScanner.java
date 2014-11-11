package pr1.a04;


import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;


public class UebungScanner {

    public static String doubleNumbers =
            "3.2 44.0 12.3 24.3 0.243 68.234 12.4 55.555 38.12";
    public static String intNumbers = "9 12 42 3 5 24 13 77 98";
    public static String mixedNumbers =
            "9.0 12 42.342 3 5 24.12 13.66 77 98";


    public static void main(String[] args) {
        // Proper number handling:
        Locale.setDefault(Locale.US);

        scannerAusprobieren();
    }


    public static void scannerAusprobieren() {
        PrintWriter out = new PrintWriter(System.out, true);
        DirtyFileReader dfr = new DirtyFileReader("./testfiles/zahlen01.txt");
        Scanner in = new Scanner(dfr);

        // Vorübung a)
        out.println("-- scannerRead(intNumbers) --");
        execScanner(intNumbers, out);
        out.println("\n-- scannerRead(doubleNumbers) --");
        execScanner(doubleNumbers, out);
        out.println("\n-- scannerRead(mixedNumbers) --");
        execScanner(mixedNumbers, out);
        // Vorübung b)
        out.println("\n-- scannerRead(dfr) --");
        scannerRead(in, out);
    }


    public static void execScanner(String string, PrintWriter out) {
        Scanner in = new Scanner(string);
        scannerRead(in, out);
    }


    public static void scannerRead(Scanner in, PrintWriter out) {
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                int i = in.nextInt();
                out.println("Integer: " + i);
                continue;
            }
            if (in.hasNextDouble()) {
                double d = in.nextDouble();
                out.println("Float:   " + d);
            }
        }
    }
}
