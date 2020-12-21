package pl.sdacademy.tarr.exam.ex1;

/*
Leszek Żebrowski
egzamin JAVA 2020-12-13

 */
public class Pattern {

    public String prepareSquareWithDiagonals(char sign, int size) {
        String pattern = "";

// check if input parameter size OK

        if (size < 1) return pattern;

        if (size == 1) {
            pattern = pattern + sign + "\n";
            return pattern;
        }


        // TODO: implementation

        int i, j, k;
        // pierwsza linia
        for (i = 0; i < size - 1; i++) {
            pattern = pattern + sign + " ";
        }
        pattern = pattern + sign + "\n";               // nowa linia
// następne linie
        for (j = 1; j < size - 1; j++) {
            pattern = pattern + sign;

            for (k = 1; k < size - 1; k++) {
                if (k == j                                // przekatna lewo/gora -> prawo/dol
                        || k == (size - 1) - j) {        // przekatna prawo/gora/lewo/dol
                    pattern = pattern + " " + sign;
                } else {
                    pattern = pattern + "  ";
                }

            }
            pattern = pattern + " " + sign + "\n";               // nowa linia
        }
// ostatnia linia
        for (i = 0; i < size - 1; i++) {
            pattern = pattern + sign + " ";
        }
        pattern = pattern + sign + "\n";


//		System.out.print(pattern); // for debug only
        return pattern;
    }

    public static void main(String[] args) {
        Pattern testpattern = new Pattern();
        System.out.println(testpattern.prepareSquareWithDiagonals(' ', 10));
    }
}