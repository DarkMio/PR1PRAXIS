package pr1.a07;

import java.util.Comparator;
import pr1.a06.Person;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getNachname().compareTo(p2.getNachname());
    }
}
