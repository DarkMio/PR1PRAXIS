package pr1.a11;

import java.io.PrintWriter;
import java.util.UUID;

public class StackTest {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        Stack s = new Stack(1024);
        ListStack ls = new ListStack(1024);

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
            s.push(new String(UUID.randomUUID().toString()));
        }
        for(int i = 0; i < 1024; i++) {
            ls.push(new String(UUID.randomUUID().toString()));
        }

        try {
            s.push(new String(UUID.randomUUID().toString())); // Oh noes, overflows!
        } catch (IllegalArgumentException e) {
            out.println("s.push(): " + e);
        }
        try {
            ls.push(new String(UUID.randomUUID().toString())); // Oh noes, overflows!
        } catch (IllegalArgumentException e) {
            out.println("ls.push(): " + e);
        }

        out.println("\n" + s.peek());
        out.println("\n" + ls.peek());
    }
}
