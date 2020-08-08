package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

/*4Sum ||*/
public class FourSum2 {
    public static void main(String[] args) {
        int[] A = new int[] { 1, -1 };
        int[] B = new int[] { -1, 1 };
        int[] C = new int[] { -1, 1 };
        int[] D = new int[] { 1, -1 };

        System.out.println(new FourSum2().fourSumCount(A, B, C, D));
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map=new HashMap<>();
        int count = 0;
        for(int i:A)
            for(int j:B)
                map.merge(i+j, 1, (a,b)-> a+b);
        
        for(int i:C)
            for(int j:D)
                count += map.getOrDefault(-1*(i+j), 0);
        return count;
    }
}

