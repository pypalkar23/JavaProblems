package practice;

import java.util.HashMap;
import java.util.Map;

public class KPairs {
    public static int solution(int numbers[], int k) {
        // lenth of array
        int n = numbers.length;

        // to return the count
        int c = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // find all Contigous array
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // list to store current Contiguous
                
                
                int v = 0;
                for (int l = i; l <= j; l++) {
                    int f = map.getOrDefault(numbers[l], 0);
                    if (f + 1 == 2)
                        v++;
                    map.put(numbers[l], f + 1);
                }

                if (v >= k)
                    c++;
                
                v = 0;
                map.clear();
            }

        }

        // return the count
        return c;
    }

    public static void main(String[] args) {
        System.out.println("ans "+solution(new int[] {1, 2, 3, 3, 3, 2, 10000, 1}, 2));
    }
}
