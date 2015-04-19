package pr2.a02;

public class Date {

    int day, month, year;

    public Date (int day, int month, int year) throws IllegalDateException {
        boolean even = (month % 2) == 0;

        // Valid months: 1 - 12
        if (!(month > 0 && month < 13)) {
            throw new IllegalDateException("Month is out of range");
        }

        // There is no day 0. EA begs to differ.
        if (day < 1) {
            throw new IllegalDateException("Day out of range. (<1)");
        }

        // Fucking February can't behave.
        if (month == 2 && day > 28) {
            throw new IllegalDateException("Day out of range. (>28 in February)");
        }

        // Even months only have 30 days.
        if (even && day > 30) {
            throw new IllegalDateException("Day out of range (even month && >31)");
        }

        // Uneven months have 31 days.
        if (!even && day > 31) {
            throw new IllegalDateException("Day is out of reach (uneven month && >32)");
        }

        // Who are we to judge the year anyway?
        if (year < 0 || year > 3000) {
            throw new IllegalDateException("Year out of range.");
        }

        // All done, we can initialize the object.
        this.day = day;
        this.month = month;
        this.year = year;
    }
}