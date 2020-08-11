package leetcode;

import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    int nums[];
    Random r = new Random();

    public Shuffle(int nums[]) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    // brute force algorithm
    public int[] shuffle() {
        int ans[] = this.nums.clone();
        for (int i = 0, n = ans.length; i < n; i++) {
            int swapIndex = r.nextInt(n);
            int temp = ans[i];
            ans[i] = ans[swapIndex];
            ans[swapIndex] = temp;
        }
        return ans;
    }

    // Fisher-Yates Algorithm
    // Generates Every Permutation in less number of tries then naive algorithm
    public int[] shuffle1() {
        int ans[] = this.nums.clone();
        for (int i = this.nums.length - 1; i >= 0; i--) {
            int swapIndex = r.nextInt(i+1);
            int temp = ans[i];
            ans[i] = ans[swapIndex];
            ans[swapIndex] = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Shuffle s = new Shuffle(new int[] { 1, 2, 3, 4 });
        System.out.println(Arrays.toString(s.shuffle1()));
        System.out.println(Arrays.toString(s.reset()));
    }
}