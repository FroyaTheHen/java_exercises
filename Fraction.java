package fraction;

public class Fraction {
    private final static int ZERO = 0;
    private final static int ONE = 1;

    private int numerator;
    private int denominator = ONE;

    @Override
    public String toString() {
        if (denominator == Fraction.ZERO)
            return "" + numerator;
        Fraction f = this;
        f = Fraction.abbreviate(f);
        return f.numerator + "/" + f.denominator;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == Fraction.ZERO)
            throw new ArithmeticException("Cannot equal 0.");
        else if (denominator < Fraction.ZERO) {
            this.denominator = -denominator;
            this.numerator = -numerator;
        } else {
            this.denominator = denominator;
            this.numerator = numerator;
        }
    }

    public Fraction(int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction add(Fraction b) {
        return new Fraction(
                this.numerator * b.denominator
                        + b.numerator * this.denominator,
                this.denominator * b.denominator
        ); }

    public static Fraction _sub(Fraction a, Fraction b) {
        return new Fraction(
                a.numerator * b.denominator
                        - b.numerator * a.denominator,
                b.denominator * a.denominator
        );}

    public Fraction sub(Fraction b) {
        return new Fraction(
                this.numerator * b.denominator
                        - b.numerator * this.denominator,
                b.denominator * this.denominator
        );}

    public static Fraction _multiply(Fraction a, Fraction b) {
        return new Fraction(
                a.numerator * b.numerator,
                a.denominator * b.denominator
        );}

    public Fraction multiply(Fraction a) {
        return new Fraction(
                a.numerator * this.numerator,
                a.denominator * this.denominator
        );}

    public static Fraction _divide(Fraction a, Fraction b) {
        return new Fraction(
                a.numerator * b.denominator,
                a.denominator * b.numerator
        );
    }

    public Fraction divide(Fraction b) {
        return new Fraction(
                this.numerator * b.denominator,
                this.denominator * b.numerator
        );
    }

    public static Fraction abbreviate(Fraction abbreviatingFraction) {

        int numerator = abbreviatingFraction.numerator;
        int denominator = abbreviatingFraction.denominator;

        int greater_number = Integer.max(numerator, denominator);
        int smaller_number = Integer.min(numerator, denominator);
        int previous_reminder = 1;
        int reminder = 1;

        // find the greatest common divisor
        while (reminder != 0) {
            previous_reminder = smaller_number;
            reminder = greater_number % smaller_number;
            greater_number = smaller_number;
            smaller_number = reminder;
        }return new Fraction(numerator / previous_reminder, denominator / previous_reminder);
    };

}


