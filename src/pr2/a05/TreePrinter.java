package pr2.a05;


import pr2.a04.TreeFactory;
import schimkat.berlin.lernhilfe2015ss.tree.QadTree;

import javax.swing.tree.TreeNode;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Iterator;

public class TreePrinter {

    public static void main(String[] args){
        QadTree tree = TreeFactory.createTree("./data/lib-tree/filetree.txt");
        PrintWriter out = new PrintWriter(System.out, true);
        printTree(tree.postorderIterator(), out);
        out.println("------------");
        printTree(tree.preorderIterator(), out);
        out.println("------------");
        printTree(tree.depthFirstIterator(), out);
    }

    public static void printTree(Iterator<TreeNode> iterator, PrintWriter out) {
        while (iterator.hasNext()) {
            out.println(iterator.next());
        }
    }

    public static void printTree(Iterator<TreeNode> iterator, PrintWriter out, int width, boolean skipLeafs) {
        if (width <= 0) {
            return;
        }
        StringWriter str = new StringWriter();
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            if (skipLeafs && node.isLeaf()) {
                continue;
            }
            Enumeration<TreeNode> enums = node.children();
            while (enums.hasMoreElements()) {
                TreeNode nod = enums.nextElement();

            }
        }
    }

}
