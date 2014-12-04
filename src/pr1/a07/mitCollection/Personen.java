//																	Zier, 824320
package pr1.a07.mitCollection;

import pr1.a06.Person;
import pr1.a07.NameComparator;
import pr1.a07.YearComparator;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2014ws.objectPlay.Factory;
import schimkat.berlin.lernhilfe2014ws.objectPlay.PersonList;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;

public class Personen {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        ArrayList<Person> personList = createTestPersonliste();
        Collection<Person> testPersonen = new HashSet<Person>(personList);

        Comparator<Person> year = new YearComparator();
        Comparator<Person> name = new NameComparator();

        printPersons(testPersonen, year, "07d2_compareYear.txt");
        printPersons(testPersonen, name, "07d3_compareName.txt");
    }

    public static void printPersons(Collection<Person> persons, PrintWriter out) {
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

    public static void printPersons(Collection<Person> persons, Comparator<Person> c, PrintWriter out) {
        ArrayList<Person> aList = new ArrayList<Person>(persons);
        aList.sort(c);
        printPersons(aList, out);
    }

    public static void printPersons(Collection<Person> persons, Comparator<Person> c, String filename) {
        DirtyFileWriter dfw = new DirtyFileWriter(filename);
        PrintWriter fout = new PrintWriter(dfw, false);
        printPersons(persons, c, fout);
        dfw.close();
    }
}