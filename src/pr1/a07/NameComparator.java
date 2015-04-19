//																	Zier, 824320
package pr1.a07;

import pr1.a06.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getNachname().compareTo(p2.getNachname());
    }
}
