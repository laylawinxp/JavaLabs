public class Chordates {
    protected int number;

    Chordates(int num) {
        number = num;
    }

    Chordates() {
        number = 0;
    }

    public String toString() {
        if (number == 0) {
            return this.getClass().getSimpleName();
        } else {
            return this.getClass().getSimpleName() + number;

        }
    }
}
