package leetcode;

import java.util.ArrayList;
import java.util.List;

/*39. Combination Sum*/
public class CombinationsSum {
    public static void main(String[] args) {
        int candidates[] = {2,7,6,3,5,1};
        List<List<Integer>> ans = new CombinationsSum().combinationSum(candidates, 9);
        for (List<Integer> tempList : ans) {
            for (int i : tempList) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        util(candidates, 0, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void util(int[] candidates, int currIndex, int tempSum, int sum, List<Integer> tempResult,
            List<List<Integer>> result) {
        if (tempSum == sum) {
            result.add(new ArrayList<>(tempResult));
            return;
        }
    

        for (int i = currIndex; i < candidates.length; i++) {
            if(tempSum+candidates[i]>sum)
                continue;
            tempResult.add(candidates[i]);
            util(candidates, i, tempSum+candidates[i], sum, tempResult, result);
            tempResult.remove(tempResult.size() - 1);
        }
    }
}
/*
 * 7
 * 
 * 2 3 6 7
 * 
 * 2 2 3
 */