import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.net.ssl.ExtendedSSLSession;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        int high, low, sum;
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                low = i + 1;
                high = n - 1;
                sum = 0 - nums[i];
                while (low < high) {
                    if (sum == nums[low] + nums[high]) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (sum > nums[low] + nums[high]) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int a[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> result = threeSum.threeSum(a);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }
}