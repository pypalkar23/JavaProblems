package leetcode;

/*287. Find the Duplicate Number*/
public class FindDuplicateNumber {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        if (nums == null)
            return 0;
        int index = 0;
        for (int i = 0, n = nums.length; i < n; i++) {
            index = Math.abs(nums[i]);
            if (nums[index] < 0)
                return index;
            nums[index] *= -1;
        }
        return 0;
    }

}