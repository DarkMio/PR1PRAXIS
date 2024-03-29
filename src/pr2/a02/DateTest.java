package pr2.a02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DateTest {

    public static void main(String[] args) {
        try {
            Scanner txt = new Scanner(new File("./data/pr2_a02_date.txt"));

            while (txt.hasNextLine()) {
                int day = txt.nextInt();
                int month = txt.nextInt();
                int year = txt.nextInt();
                try {
                    new Date(day, month, year);
                    System.out.format("Korrektes Datum: %02d.%02d.%02d%n", day, month, year);
                } catch (IllegalDateException e) {
                    System.err.format("Falsches  Datum: %02d.%02d.%02d: %s%n", day, month, year, e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}