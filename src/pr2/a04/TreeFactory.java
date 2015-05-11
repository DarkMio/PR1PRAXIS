package pr2.a04;


import schimkat.berlin.lernhilfe2015ss.tree.QadTree;

import javax.swing.tree.TreeNode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TreeFactory {

    public static void main(String[] args) {
        QadTree example = buildTree();
        example.showInGUI();

        QadTree tree = createTree("./data/lib-tree/filetree.txt");
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

    public static boolean treeHasNode(QadTree tree, String s) {
        Iterator<TreeNode> it = tree.preorderIterator();
        while (it.hasNext()) {
            if (s.equals(it.next().toString())) {
                return true;
            }
        }
        return false;
    }

    public static String[] readLines(Scanner in) {
        ArrayList<String> list = new ArrayList<String>();

        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.isEmpty()) {
                continue;
            }
            list.add(s);
        }
        return fromListToArray(list);
    }

    public static String[] readLine(Scanner in) {
        ArrayList<String> list = new ArrayList<String>();

        while (in.hasNext()) {
            list.add(in.next());
        }
        return fromListToArray(list);
    }

    public static String[] fromListToArray(ArrayList<String> list) {
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
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

    public static QadTree createTree(String[] lines) {
        QadTree tree = new QadTree(lines[0]);
        tree.setLogging(true);

        for(int i = 1; i < lines.length; i++) {
            Scanner in = new Scanner(lines[i]);
            String[] array = readLine(in);
            String head = array[0];
            array = cutArray(array);

            if (treeHasNode(tree, head)){
                tree.addChilds(head, array);
            }
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
