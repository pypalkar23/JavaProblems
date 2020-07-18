
import java.util.*;

class PlusMult {
    public static String plusMult(List<Integer> A) {
        // Write your code here
        ListIterator<Integer> iter = A.listIterator();
        Long evenAns = Long.valueOf((Integer) iter.next());
        Long oddAns = Long.valueOf((Integer) iter.next());
        System.out.println(evenAns);
        System.out.println(oddAns);
        boolean even = true;
        boolean mult = true;
        while (iter.hasNext()) {
            Long temp = Long.valueOf((Integer) iter.next());
            System.out.println(temp);
            if (even) {
                System.out.println("EVEN block");
                if (mult) {
                    System.out.println("MULT");
                    evenAns = (evenAns * temp) % 2;

                } else {
                    System.out.println("ADD");
                    evenAns = evenAns + temp % 2;
                }
                even = !even;
            } else {
                System.out.println("odd block");
                if (mult) {
                    System.out.println("MULT");
                    oddAns = (oddAns * temp) % 2;
                } else {
                    System.out.println("ADD");
                    oddAns = oddAns + temp % 2;
                }
                even = !even;
                mult = !mult;
            }

        }

        if (oddAns > evenAns)
            return "ODD";
        else if (oddAns < evenAns)
            return "EVEN";
        else
            return "NEUTRAL";
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(12);
        A.add(3);
        A.add(5);
        A.add(7);
        A.add(13);
        A.add(12);

        System.out.println(plusMult(A));
    }
}