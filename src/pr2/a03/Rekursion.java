package pr2.a03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Rekursion {

    public static void main(String[] args) {
        int[] array = createArray("./data/pr2_a03_numbers.txt");
        print(array);
        System.out.println(indexOf(array, 12));
    }

    public static int[] createArray(Scanner in) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (in.hasNextInt()){;
            list.add(in.nextInt());
        }
        int[] array = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            array[i] = list.get(i);
        }
        return array;
    }

    public static int[] createArray(String file){
        try {
            return createArray(new Scanner(new File(file)));
        } catch (FileNotFoundException e) {
            System.err.println("Oh, some error: " + e.getMessage());
        }
        return null;
    }

    public static void print(int[] array){
        for(int i: array){
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static int indexOf(int[] array, int num) {
        for(int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(int[] a, int z) {
        if (a[0] > z || a[a.length-1] < z) return false;
        return containsRek(a, z, 0, a.length - 1);
    }

    public static boolean containsRek(int[] a, int z, int l, int r){
        if (l == r) return a[l] == z;
        int g = (l+r) / 2;
        if (a[g] == z) return true;
        if (a[g] > z) return containsRek(a, z, l, g - 1);
        return containsRek(a, z, g + 1, r);
    }
}
