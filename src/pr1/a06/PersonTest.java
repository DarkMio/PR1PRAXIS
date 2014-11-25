//																	Zier, 824320
package pr1.a06;

import java.io.PrintWriter;

public class PersonTest {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        Person person1 = new Person("Gertrude", "Mayer", 1965);
        out.println(person1.toString());

        Person person2 = new Person(person1);
        out.println(person2.toString());

        schimkat.berlin.lernhilfe2014ws.objectPlay.Person person3 = new schimkat.berlin.lernhilfe2014ws.objectPlay.Person("Gerlinde", "Stiegl", 1988);
        Person person4 = new Person(person3);
        out.println(person4.toString());
    }
}
