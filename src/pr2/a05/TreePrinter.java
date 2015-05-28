package pr2.a05;


import pr2.a04.TreeFactory;
import schimkat.berlin.lernhilfe2015ss.tree.QadTree;
import javax.swing.tree.TreeNode;
import java.io.*;
import java.util.Enumeration;
import java.util.Iterator;


public class TreePrinter {

    public static void main(String[] args){
        QadTree tree = TreeFactory.createTree("./data/lib-tree/tree-02.txt");
        PrintWriter out = new PrintWriter(System.out, true);
        printTree(tree.postorderIterator(), out, 15, false);
        out.println("------------");
        printTree(tree.preorderIterator(), out, 15, false);
        out.println("------------");
        printTree(tree.depthFirstIterator(), out, 15, false);
        out.println("------------\nUnd nun die kür:\n-------------");
        writeTreeBinary(tree, "./data/lib-tree/outputstream.txt");
        printTree(readTreeBinary("./data/lib-tree/outputstream.txt").preorderIterator(), out, 15);
    }

    public static void printTree(Iterator<TreeNode> iterator, PrintWriter out) {
        while (iterator.hasNext()) {
            out.println(iterator.next());
        }
    }

    public static void printTree(Iterator<TreeNode> iterator, PrintWriter out, int width) {
        printTree(iterator, out, width, false);
    }

    public static void writeTreeBinary(QadTree tree, String path) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(tree);
        } catch (IOException e) {
            System.err.println("File not found.");
            System.exit(-1);
        }
    }

    public static QadTree readTreeBinary(String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            return (QadTree) ois.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        System.exit(-1);
        return new QadTree("");
    }

    public static void printTree(Iterator<TreeNode> iterator, PrintWriter out, int width, boolean skipLeafs) {
        if (width <= 0) {
            return;
        }
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            out.printf("%-" + width + "s ", node);
            if (skipLeafs && node.isLeaf()) {
                continue;
            }
            Enumeration enums = node.children();
            while (enums.hasMoreElements()) {
                out.printf("%-" + width + "s ", enums.nextElement());
            }
            out.println();
        }
    }
}
