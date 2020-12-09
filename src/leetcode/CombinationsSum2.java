package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/*40. Combination Sum*/
public class CombinationsSum2 {
    public static void main(String[] args) {
        int candidates[] = { 2,5,2,1,2 };
        List<List<Integer>> ans = new CombinationsSum2().combinationSum(candidates, 5);
        for (List<Integer> tempList : ans) {
            for (int i : tempList) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        util(candidates, 0, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void util(int[] candidates, int currIndex, int tempSum, int sum, List<Integer> tempResult,
            List<List<Integer>> result) {
        if (tempSum == sum) {
            result.add(new ArrayList<>(tempResult));
            return;
        }
        if(tempSum>sum){
            return;
        }
        
        for (int i = currIndex; i < candidates.length; i++) {
            if (i>currIndex && candidates[i]==candidates[i-1])
                continue;
            tempResult.add(candidates[i]);
            util(candidates, i + 1, tempSum + candidates[i], sum, tempResult, result);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}
/*
 * 10,1,2,7,6,1,5
 * 
 * 1 1 2 5 6 7 10
 * 
 */