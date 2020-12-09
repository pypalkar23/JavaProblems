package leetcode;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int zerosDetected = 0;
        int twosBorder = nums.length - 1;
        int i = 0;

        while (i <= twosBorder) {
            if (nums[i] == 0) {
                swap(nums, i, zerosDetected);
                i++;
                zerosDetected++;
            } else if (nums[i] == 2) {
                swap(nums, i, twosBorder);
                twosBorder--;
            } else
                i++;

        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        SortColors s = new SortColors();
        int a[] = { 2, 0, 2, 1, 1, 0 };
        int b[] = { 2, 0, 1 };
        int c[] = { 1, 2, 0 };

        s.sortColors(a);
        s.sortColors(b);
        s.sortColors(c);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
    }
}

/*
 * 2 0 2 1 1 0 0 0 2 1 1 2
 * 
 */
