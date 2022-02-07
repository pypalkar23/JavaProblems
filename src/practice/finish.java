package practice;

import java.util.HashMap;
import java.util.Map;

public class finish {
    public static int solution(int finish, int[] scooters) {
        Map<Integer, Integer> map = new HashMap<>(); 

        for (int i = 0; i < scooters.length; i++) {
            int a = map.getOrDefault(scooters[i], 0);
            map.put(scooters[i], a + 1);
        }

        int j = 0;
        int foot = 0;
        while (j < finish) {
            if (map.getOrDefault(j, 0) > 0) {
                j += 10;
            } else {
                foot++;
                j++;
            }
        }
        return foot;

    }

    public static void main(String[] args) {
        System.out.println(solution(27, new int[]{15,7,3,10}));
    }
}



