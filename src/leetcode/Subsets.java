package leetcode;

/*78. Subsets*/
import java.util.List;
import java.util.ArrayList;

class Subsets {
    List<List<Integer>> soln = new ArrayList<List<Integer>>();
    int k = 0, n = 0;

    public static void main(String[] args) {
        int a[] = { 1, 2, 3 };
        Subsets s = new Subsets();
        List<List<Integer>> sol = s.subsets1(a);
        for (List<Integer> list : sol) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        return util(nums, 0);
    }

    public List<List<Integer>> util(int[] nums, int start) {
        // mySolution
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (start == nums.length) {
            ans.add(new ArrayList<Integer>());
            return ans;
        }

        List<List<Integer>> tempSoln = util(nums, start + 1);
        for (List<Integer> list : tempSoln) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(nums[start]);
            ans.add(list);
            ans.add(newList);
        }
        return ans;
    }

    public List<List<Integer>> subsets1(int[] nums) {
        n = nums.length;

        for (k = 0; k <= n; k++) {
            util2(0, new ArrayList<Integer>(), nums);
        }
        return soln;
    }

    public void util2(int start, ArrayList<Integer> ans, int[] nums) {
        if (ans.size() == k) {
            soln.add(new ArrayList<Integer>(ans));
        }

        for (int i = start; i < n; i++) {
            ans.add(nums[i]);
            util2(i + 1, ans, nums);
            ans.remove(ans.size() - 1);
        }

    }

}