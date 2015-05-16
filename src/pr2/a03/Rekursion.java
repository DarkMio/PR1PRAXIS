package pr2.a03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class Rekursion {

    public static void main(String[] args) {
        int[] array = createArray("./data/pr2_a03_numbers.txt");
        print(array);
        final int width = 1200;
        final int height = 900;
        ViewPort vp = new ViewPort("Binary Search", width, height);
        System.out.println(indexOf(vp, array, 757798, width, height));
        System.out.println(indexOfRecursive(vp, array, 757798, width, height));
    }

    public static int[] createArray(Scanner in) {
        ArrayList<Integer> list = new ArrayList<>();

        while (in.hasNextInt()){
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

    public static void print(ViewPort vp, int[] array, double l, double r, int c, int w, int h, boolean superheight){
        l = w*(l+1)/array.length;
        r = w*(r-1)/array.length;
        if (superheight) {
            c = 5 + h*(c+1)/array.length;
        }
        vp.line((int) l, c, (int) r, c, 20*c, 5*c, 3*c);
    }

    public static int indexOf(ViewPort vp, int[] array, int num, int width, int height) {
        for(int i = 0; i < array.length; i++) {
            print(vp, array, 0, i, i, width, height, true);
            if (array[i] == num) {
                return i;
            }
            if (array[i] > num) {
                return -1;
            }
        }
        return -1;
    }

    public static int indexOfRecursive(ViewPort vp, int[] a, int z, int w, int h) {
        if (a[0] > z || a[a.length-1] < z) return -1;
        return indexOfRecursive(vp, a, z, 0, a.length - 1, 1, w, h);
    }

    public static int indexOfRecursive(ViewPort vp, int[] a, int z, int l, int r, int c, int w, int h){
        print(vp, a, l, r, c, w, h, false);
        if (l == r && a[l] == z) {
            return l;
        } else if (r - l < 2) {
            return -1;
        }
        int g = (l+r) / 2;
        if (a[g] == z) return g;
        if (a[g] > z) return indexOfRecursive(vp, a, z, l, g - 1, c+1, w, h);
        return indexOfRecursive(vp, a, z, g + 1, r, c+1, w, h);
    }
}
