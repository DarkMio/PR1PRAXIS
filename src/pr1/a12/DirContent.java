package pr1.a12;

import java.io.File;

public class DirContent {

    public static void printAll (File path) {
        System.out.println("\nVerzeichnis\t\t" + path.getAbsolutePath());
        printDirectoryOnly(path);
        printFilesOnly(path);
    }

    public static void printAll (String string) {
        printAll(new File(string));
    }

    public static void printFilesOnly (File path) {
        for(File file: path.listFiles()) {
            if (file.isFile()) {
                System.out.println("Datei\t\t\t" + file);
            }
        }
    }

    public static void printDirectoryOnly (File path) {
        for(File file: path.listFiles()) {
            if (file.isDirectory()) {
                System.out.println("Ordner\t\t\t" + file);
            }
        }
    }

    public static void test () {
        printAll("/");
        printAll("./");
        printAll("./src/pr1/a12/");
    }
}
