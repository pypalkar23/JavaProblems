package leetcode;

import java.util.Arrays;

public class ReverseInBatches {
    public static void main(String[] args) {
        String s = "abcdefghi";
        String s1 = "abc";
        int k = 2;
        System.out.println(solve(s, 3));
        System.out.println(solve(s1, 2));
    }

    public static String solve(String s, int k) {

        if (s == null || s.length() == 0)
            return s;

        int batchSize = 2 * k;
        int n = s.length();
        char[] ch = s.toCharArray();
        int i;

        if (n < k) {
            reverse(ch, 0, n - 1);
        } else {
            for (i = 0; i + batchSize < n; i = i + batchSize) {
                System.out.println(i+""+(i+k));
                reverse(ch, i, i + k-1);
            }
            System.out.println(i);
            if (i + k <= n) {
                reverse(ch, i, i + k-1);
            }
        }

        
        return Arrays.toString(ch);
    }

    public static void reverse(char[] ch, int start, int end) {
        int count = 0;
        for (int i = start; i <= (start + end)/ 2; i++) {
            char temp = ch[i];
            ch[i] = ch[end-count];
            ch[end-count] = temp;
            count++;
        }
    }
}
