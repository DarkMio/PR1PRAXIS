package pr1.a13;

import org.junit.Test;
import org.junit.Assert;
import pr1.a11.AbstractStack;
import pr1.a11.Stack;
import pr1.a11.ListStack;

import java.util.Scanner;

public class StackTest {

    public void main(String[] args) {
        testStack();
        testStackList();


    }

    public void checkStack(AbstractStack stack, String sollState) {
        Scanner in = new Scanner(sollState);
        String[] stringArray = new String[4];
        for (int i = 0; in.hasNext(); i++) {
            stringArray[i] = in.next();
        }

        for (String s: stringArray) {
            pushTestSimple(stack, s, s);
        }

        for (int i = stringArray.length - 2; i >= 0; i--) {
            popTestSimple(stack, stringArray[i]);
        }
    }

    public void pushTestSimple(AbstractStack stack, String element, String sollState) {
        stack.push(element);
        System.out.printf(
                stack.getClass().getSimpleName() + ": \t %-30s ; lastToken (soll / ist): %15s %15s \n",
                stack.toString(), sollState, stack.peek()
        );
//        System.out.println("Assert.assertEquals(\"Ein Test mit JUit\", " + sollState + ", " + stack.toString() + ");");
        Assert.assertEquals("Ein Test mit JUnit", sollState, stack.peek());
    }

    public void popTestSimple(AbstractStack stack, String sollState) {
        stack.pop();
        System.out.printf(
                stack.getClass().getSimpleName() + ": \t %-30s ; lastToken (soll / ist): %15s %15s \n",
                stack.toString(), sollState, stack.peek()
        );
        Assert.assertEquals("Ein Test mit JUnit", sollState, stack.peek());
    }

    public void testSingleStack(AbstractStack stack) {
        checkStack(stack, "(1) alf 2013 frühmorgens");
    }

    @Test
    public void testStackList() {
        testSingleStack (new ListStack(4));
    }

    @Test
    public void testStack() {
        testSingleStack (new Stack(4));
    }
}
