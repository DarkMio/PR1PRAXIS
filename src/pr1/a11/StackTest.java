package pr1.a11;

import java.io.PrintWriter;
import java.util.UUID;

public class StackTest {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        Stack s = new Stack(1024);
        ListStack ls = new ListStack(1024);
        Stack standardS = new Stack();
        ListStack standardLS = new ListStack();

        try {
            s.pop(); // Nothing here to pop :(
        } catch (IllegalArgumentException e) {
            out.println("s.pop(): " + e);
        }
        try {
            s.pop(); // Nothing here to pop :(
        } catch (IllegalArgumentException e) {
            out.println("ls.pop(): " + e);
        }

        try {
            s.peek(); // Nothing here to pop :(
        } catch (IllegalArgumentException e) {
            out.println("s.peek(): " + e);
        }
        try {
            ls.pop(); // Nothing here to pop :(
        } catch (IllegalArgumentException e) {
            out.println("ls.peek(): " + e);
        }

        for(int i = 0; i < 1024; i++) {
            ls.push(UUID.randomUUID().toString());
            s.push(UUID.randomUUID().toString());
            standardLS.push(UUID.randomUUID().toString());
            standardS.push(UUID.randomUUID().toString());
        }

        try {
            s.push(UUID.randomUUID().toString()); // Oh noes, overflows!
        } catch (IllegalArgumentException e) {
            out.println("s.push(): " + e);
        }
        try {
            ls.push(UUID.randomUUID().toString()); // Oh noes, overflows!
        } catch (IllegalArgumentException e) {
            out.println("ls.push(): " + e);
        }

        out.println("\n" + s.peek());
        out.println("\n" + ls.peek());
        out.println("\n" + standardLS.peek());
        out.println("\n" + standardS.peek());
    }
}
