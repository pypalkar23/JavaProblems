package hackerrank;

import java.util.Scanner;

class AnnoyingCriteria {
    public int getAsciiTotal(String str, int len) {
        int asciiTotal = 0;
        str = str.toUpperCase();
        for (int i = 0; i < len; i++)
            asciiTotal += str.charAt(i) % ('A'-1);
        return asciiTotal;
    }

    public int noOfDivisors(int n) {
        int noOfDivisors = 0;
        int lim = (int) (Math.floor(Math.sqrt(n)));
        for (int i = 1; i <= lim; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    noOfDivisors = noOfDivisors + 1;
                } else {
                    noOfDivisors = noOfDivisors + 2;
                }
            }
        }
        return noOfDivisors;
    }

    public static void main(String args[]) throws Exception {

        AnnoyingCriteria tc = new AnnoyingCriteria();
        Scanner scr = new Scanner(System.in);
        int N = scr.nextInt();

        for (int i = 0; i < N; i++) {
            String name = scr.next();
            System.out.println(name);
            int len = name.length();
            System.out.println(tc.getAsciiTotal(name, len));
            int noOfDivisors = tc.noOfDivisors(tc.getAsciiTotal(name, len));
            System.out.println((noOfDivisors >= len) ? "IN" : "OUT");
        }

    }
}