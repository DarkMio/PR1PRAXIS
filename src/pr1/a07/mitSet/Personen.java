//																	Zier, 824320
package pr1.a07.mitSet;

import pr1.a06.Person;
import schimkat.berlin.lernhilfe2014ws.objectPlay.Factory;
import schimkat.berlin.lernhilfe2014ws.objectPlay.PersonList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.PrintWriter;

public class Personen {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        ArrayList<Person> personList = createTestPersonliste();
        Set<Person> testPersonen = new HashSet<Person>(personList);
        printPersons(testPersonen, out);
    }

    public static void printPersons(Set<Person> persons, PrintWriter out) {
        for(Person p: persons) {
            out.println(p);
        }
    }

    public static ArrayList<Person> createTestPersonliste() {
        ArrayList<Person> personList = new ArrayList<Person>();

        PersonList testPersonList = Factory.createTestPersonliste();
        for(schimkat.berlin.lernhilfe2014ws.objectPlay.Person p: testPersonList) {
            personList.add(new Person(p));
        }

        return personList;
    }
}