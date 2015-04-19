//																	Zier, 824320
package pr1.a05;

import schimkat.berlin.lernhilfe2014ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2014ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2014ws.objectPlay.Factory;
import schimkat.berlin.lernhilfe2014ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2014ws.objectPlay.PersonList;
import schimkat.berlin.lernhilfe2014ws.objectPlay.PersonSet;

import java.io.PrintWriter;
import java.util.Scanner;

public class Personen {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);

        PersonList testPersonList = Factory.createTestPersonliste();
        PersonSet testPersonen = new PersonSet(testPersonList);
        printPersons(testPersonen, out);
        printPersons(testPersonen, "05c_testperson.txt");

        PersonSet kommilitonen = getPersonsFrom("./data/kommilitonen.txt");
        PersonSet sportfreunde = getPersonsFrom("./data/sportfreunde.txt");

        PersonSet KundS = new PersonSet(kommilitonen);
        KundS.retainAll(sportfreunde);

        PersonSet KaberNichtS = new PersonSet(kommilitonen);
        KaberNichtS.removeAll(sportfreunde);

        PersonSet TvereinigtK = new PersonSet(kommilitonen);
        TvereinigtK.addAll(sportfreunde);

        printPersons(KundS, "05e_KundS.txt");
        printPersons(KaberNichtS, "05e_KaberNichtS.txt");
        printPersons(TvereinigtK, "05e_TverinigtK.txt");
    }

    public static void printPersons(PersonSet persons, PrintWriter out) {
        for(Person p: persons) {
            out.println(p);
        }
    }

    public static void printPersons(PersonSet persons, String filename) {
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

    public static PersonSet getPersonsFrom(Scanner dataSource) {
        PersonSet pSet = new PersonSet();
        while(dataSource.hasNext()) {
            pSet.add(createPerson(dataSource));
        }
        return pSet;
    }

    public static PersonSet getPersonsFrom(String filename) {
        DirtyFileReader dfr = new DirtyFileReader(filename);
        Scanner in = new Scanner(dfr);
        return getPersonsFrom(in);
    }
}