package pr2.a04;


import schimkat.berlin.lernhilfe2015ss.tree.QadTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class TreeFactory {

    public static void main(String[] args) {
        QadTree name = buildTree();
        name.showInGUI();

        QadTree tree = createTree("./data/lib-tree/tree-02.txt");
        tree.showInGUI();
    }

    public static QadTree createTree(String path) {
        String[] lines = readLines(path);
        return createTree(lines);
    }

    public static String[] readLines(String path) {
        try {
            return readLines(new Scanner(new File(path)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    public static String[] cutArray(String[] a) {
        if(a.length > 1) {
            String[] cut = new String[a.length - 1];
            System.arraycopy(a, 1, cut, 0, a.length - 1);
            return cut;
        } else {
            return a;
        }
    }

    public static String[] readLines(Scanner in) {
        Vector<String> list = new Vector<String>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            list.add(s);
        }

        String[] array = new String[list.size()];
        for(int i = 0; i < array.length; i++){
            array[i] = list.get(i);
        }
        return array;
    }

    public static QadTree createTree(String[] lines) {
        Scanner in;
        Vector<String> cache;
        String[] array;
        QadTree tree = new QadTree(lines[0]);
        lines = cutArray(lines);
        tree.setLogging(true);
        for(String s: lines) {
            in = new Scanner(s);
            cache = new Vector<String>();
            while(in.hasNext()) {
                cache.add(in.next());
            }
            String head = cache.get(0);
            cache.remove(0);
            array = new String[cache.size()];
            for(int i = 0; i < array.length; i++) {
                array[i] = cache.get(i);
            }
            System.out.println("Head: " + head);
            for(String str: array) {
                System.out.print(" " + str + " ");
            }
            tree.addChilds(head, array);
        }
        return tree;
    }

    public static QadTree buildTree() {
        QadTree tree = new QadTree("Life");
        tree.addChilds("Life", new String[]{"Eubacteria", "Eukaryotes", "Archaea"});
        tree.addChilds("Eubacteria", new String[]{
                "Aquificae", "Thermotogae", "Thermodesulfobacteria",
                "Chrysiogenetes"
        });
        tree.addChilds("Eukaryotes", new String[]{
                "Archaeplastida (Plantae)", "Unikonts",
                "Chromalveolates", "Excavates"
        });
        tree.addChilds("Archaea", new String[]{
                "Korarchaeota", "Crenarchaeota", "Euryarchaeota"
        });

        tree.addChilds("Archaeplastida (Plantae)", new String[]{
                "Glaucophytes", "Green plants", "Rhodophyta"
        });
        tree.addChilds("Unikonts", new String[]{
                "Opisthokonts", "Amoebozoa"
        });
        tree.addChilds("Opisthokonts", new String[]{
                "Animals", "Choanoflagellates", "Filastera",
                "Ichthyosporea", "Fungi", "Nuclearlidae"
        });

        return tree;
    }

}
