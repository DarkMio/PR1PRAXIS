//																	Zier, 824320
package pr1.a06;

//import schimkat.berlin.lernhilfe2014ws.objectPlay.Factory;
//import schimkat.berlin.lernhilfe2014ws.objectPlay.PersonList;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Personen {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        ArrayList<Person> personList = createTestPersonliste();
        HashSet<Person> testPersonen = new HashSet<Person>(personList);
        printPersons(testPersonen, out);
    }

    public static void printPersons(HashSet<Person> persons, PrintWriter out) {
        for(Person p: persons) {
            out.println(p);
        }
    }

    public static ArrayList<Person> createTestPersonliste() {

  /*      PersonList testPersonList = Factory.createTestPersonliste();
        for(schimkat.berlin.lernhilfe2014ws.objectPlay.Person p: testPersonList) {
            personList.add(new Person(p));
        }
*/
        return new ArrayList<Person>();
    }
}