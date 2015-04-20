package pr2.a02;

public class Date {

    protected int day, month, year;

    public Date (int day, int month, int year) throws IllegalDateException {
        boolean even = (month % 2) == 0;
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Valid months: 1 - 12
        if (!(month > 0 && month < 13)) {
            throw new IllegalDateException("Month is out of range");
        }

        // There is no day 0. EA begs to differ.
        if (day < 1) {
            throw new IllegalDateException("Day out of range. (<1)");
        }

        // Who are we to judge the year anyway?
        if (year < 0 || year > 3000) {
            throw new IllegalDateException("Year out of range. ([0...3000])");
        }

        // Get how many days a certain month has and compare it.
        if (monthDays[month-1] < day) {
            throw new IllegalDateException(String.format("Day out of range. (<%02d)", day));
        }

        // All done, we can initialize the object.
        this.day = day;
        this.month = month;
        this.year = year;
    }
}