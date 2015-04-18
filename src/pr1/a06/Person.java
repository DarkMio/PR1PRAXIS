//																	Zier, 824320
package pr1.a06;

public class Person {
    protected String vorname;
    protected String nachname;
    protected int geburtsjahr;

    public Person(String vorname, String nachname, int geburtsjahr) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsjahr = geburtsjahr;
    }

    public Person(Person person) {
        this(person.vorname, person.nachname, person.geburtsjahr);
    }

/*    public Person(schimkat.berlin.lernhilfe2014ws.objectPlay.Person other) {
        this(other.getVorname(), other.getNachname(), other.getGeburtsjahr());
    }
*/
    public String toString() {
        return String.format(vorname + " " + nachname + ", " + geburtsjahr);
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (geburtsjahr != person.geburtsjahr) return false;
        if (nachname != null ? !nachname.equals(person.nachname) : person.nachname != null) return false;
        if (vorname != null ? !vorname.equals(person.vorname) : person.vorname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = vorname != null ? vorname.hashCode() : 0;
        result = 31 * result + (nachname != null ? nachname.hashCode() : 0);
        result = 31 * result + geburtsjahr;
        return result;
    }
}
