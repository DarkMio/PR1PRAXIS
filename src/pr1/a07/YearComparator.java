package pr1.a07;

import java.util.Comparator;
import pr1.a06.Person;

public class YearComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getGeburtsjahr() - p2.getGeburtsjahr();
    }
}
