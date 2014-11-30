//																	Zier, 824320
package pr1.a06;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2014ws.objectPlay.Factory;
import schimkat.berlin.lernhilfe2014ws.objectPlay.PersonList;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PersonenOld {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        ArrayList<Person> testPersonList = createTestPersonliste();
        HashSet<Person> testPersonen = new HashSet<Person>(testPersonList);
        printPersons(testPersonen, out);
        printPersons(testPersonen, "06e_testperson.txt");

        HashSet<Person> kommilitonen = getPersonsFrom("./data/kommilitonen.txt");
        HashSet<Person> sportfreunde = getPersonsFrom("./data/sportfreunde.txt");

        HashSet<Person> KundS = new HashSet<Person>(kommilitonen);
        KundS.retainAll(sportfreunde);

        HashSet<Person> KaberNichtS = new HashSet<Person>(kommilitonen);
        KaberNichtS.removeAll(sportfreunde);

        HashSet<Person> TvereinigtK = new HashSet<Person>(kommilitonen);
        TvereinigtK.addAll(sportfreunde);

        printPersons(KundS, "06d_KundS.txt");
        printPersons(KaberNichtS, "06d_KaberNichtS.txt");
        printPersons(TvereinigtK, "06d_TverinigtK.txt");
    }

    public static void printPersons(HashSet<Person> persons, PrintWriter out) {
        for(Person p: persons) {
            out.println(p);
        }
    }

    public static void printPersons(HashSet<Person> persons, String filename) {
        DirtyFileWriter dfw = new DirtyFileWriter(filename);
        PrintWriter fout = new PrintWriter(dfw, false);
        printPersons(persons, fout);
        fout.close();
    }

    public static Person createPerson (Scanner dataSource) {
        String vorname = dataSource.next();
        String nachname = dataSource.next();
        int i = dataSource.nextInt();
        return new Person(vorname, nachname, i);
    }

    public static HashSet<Person> getPersonsFrom(Scanner dataSource) {
        HashSet<Person> pSet = new HashSet<Person>();
        while(dataSource.hasNext()) {
            pSet.add(createPerson(dataSource));
        }
        return pSet;
    }

    public static HashSet<Person> getPersonsFrom(String filename) {
        DirtyFileReader dfr = new DirtyFileReader(filename);
        Scanner in = new Scanner(dfr);
        return getPersonsFrom(in);
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