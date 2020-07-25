package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum {
    public static void main(String[] args) {
        List<List<Integer>> list = new FourSum().fourSum1(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
        for (List<Integer> l : list) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    // Noob's(my) Solution
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        result.add(temp);
                        while (nums[k] == nums[k + 1])
                            k++;
                        while (nums[l - 1] == nums[l])
                            l--;
                        k++;
                        l--;
                    } else if (sum < target)
                        k++;
                    else
                        l--;

                }
            }
        }

        return result;
    }

    // Leetcode's solution works for three sum, four sum , ksum
    // uses two sum as base case
    // Personally found it awesome
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        
        return kSum(nums, 0, 4, target);
    }

    public List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (start > nums.length - k || start == nums.length || nums[start] * k > target
                || nums[nums.length - 1] * k < target)
            return res;
        if (k == 2)
            return twoSum(nums, start, target);
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i] != nums[i - 1]) {
                for (List<Integer> list : kSum(nums, i + 1, k - 1, target - nums[i])) {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(list);
                }
            }
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<Integer>();

        for (int i = start, n = nums.length; i < n; i++) {
            if (res.isEmpty() || nums[i - 1] != nums[i]) {
                int remnant = target - nums[i];
                if (set.contains(remnant)) {
                    res.add(Arrays.asList(nums[i], remnant));
                }
                set.add(nums[i]);
            }
        }
        return res;
    }

}