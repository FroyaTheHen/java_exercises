import java.time.LocalDate;

public class Date {
    enum Month {
        JAN(1, 31),
        FEB(2, 28),
        MAR(3, 31),
        APR(4, 30),
        MAY(5, 31),
        JUN(6, 30),
        JUL(7, 31),
        AUG(8, 31),
        SEP(9, 30),
        OCT(10, 31),
        NOV(11, 30),
        DEC(12, 31);

        int index;
        int days_of_month;

        Month(int index, int days_of_month) {
            this.index = index;
            this.days_of_month = days_of_month;
        }
    }

    private final static int MAX_MONTHS = 12;
    private final static int LEAP_YEAR_FEB_DAYS = 29;

    private int day;
    private int month;
    private int year;

    private Date(int day, int month, int year) {
        validateDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    private Date(){
        LocalDate date = LocalDate.now();
        this.day = LocalDate.now().getDayOfMonth();
        this.month = LocalDate.now().getMonthValue();
        this.year = LocalDate.now().getYear();
    }

    private static boolean isLeap(int year){
         return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private static void validateDate(int day, int month, int year){
        if (       month>MAX_MONTHS
                || month<=0
                || day<=0
            ) throw new IllegalArgumentException("Incorrect date.");

        boolean isLeapFebruary = month==2 && isLeap(year);
        if(isLeapFebruary && day<=LEAP_YEAR_FEB_DAYS)
            return;

        for(Month m : Month.values()){
                if(month == m.index)
                    if(day > m.days_of_month)
                        throw new IllegalArgumentException("Incorrect date.");
            }
    }

    private static String getMonthName(int month){
        String name = "";
        for(Month m : Month.values()){
            if(month == m.index)
                name =  m.name();
        } return name;
    }

    @Override
    public String toString(){
        Date d = this;
        String date_str = d.day+" "+getMonthName(d.month)+" "+d.year;
        if(d.day<10)
            date_str="0"+date_str;
        return date_str;
    }

    public int getDay(){
        return this.day;}

    public int getMonth(){
        return this.month;}

    public int getYear(){
        return this.year;}

    public void setDate(int day, int month, int year){
        validateDate(day, month, year);
        this.day = day;
        this.month = month;
        this.year = year;
    }
}
