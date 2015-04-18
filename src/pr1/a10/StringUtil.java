package pr1.a10;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;

import java.io.PrintWriter;
import java.util.Scanner;

public class StringUtil {

    static public void main (String[] args) {
        int cntFile = 0;
        double ratioFile = 0;
        PrintWriter out = new PrintWriter(System.out, true);
        String[] teststring = createTestStrings01();
        for(String s: teststring) {
            int cnt = getUpperCaseCount(s);
            out.println("I found " + cnt + " uppercases.");
            double ratio = getRatioWhitespace(s);
            out.println("The ratio of whitespace is " + ratio + ".");
        }

        DirtyFileReader dfw00 = new DirtyFileReader("05c_testperson.txt");
        Scanner in00 = new Scanner(dfw00);
        cntFile = getUpperCaseCount(in00);
        out.println("Testpersonen UpperCaseCount: " + cntFile);

        DirtyFileReader dfw01 = new DirtyFileReader("05c_testperson.txt");
        Scanner in01 = new Scanner(dfw01);
        ratioFile = getRatioWhitespace(in01);
        out.println("Testpersonen WhitespaceRation: " + ratioFile);

    }

    public static int getUpperCaseCount(String s) {
        int cnt = 0;
        for(char c: s.toCharArray()) {
            if(Character.isUpperCase(c)){
                cnt ++;
            }
        }
        return cnt;
    }

    public static int getWhitespaceCount(String s) {
        int cnt = 0;
        for(char c: s.toCharArray()) {
            if(Character.isWhitespace(c)){
                cnt ++;
            }
        }
        return cnt;
    }

    public static double getRatioWhitespace(String s) {
        int len = s.length();
        int cnt = getWhitespaceCount(s);
        double ratio = cnt * 100 / len;
        return ratio;
    }

    public static String[] createTestStrings01() {
        return new String[]{"One string goes here", "Another GOES here", "WhitespacesAhoy!", " "};
    }

    public static int getUpperCaseCount(Scanner in) {
        int cnt = 0;

        while (in.hasNext()) {
            cnt += getUpperCaseCount(in.next());
        }
        return cnt;
    }

    public static double getRatioWhitespace(Scanner in) {
        double wsCnt = 0;
        double charCnt = 0;
        while (in.hasNext()) {
            String line = in.nextLine();
            wsCnt += getWhitespaceCount(line) + 1;
            charCnt += line.length() + 1;
        }
        double ratio = wsCnt * 100 / charCnt;
        return ratio;
    }
}
