//378. Kth Smallest Element in a Sorted Matrix
package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    // sol2
    int count, ans;

    public static void main(String[] args) {
        int mat[][] = new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        System.out.println(new KthSmallestElement().kthSmallest(mat, 2));
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int rows = matrix[0].length;
        int nums[] = new int[rows * rows];
        int j = 0;
        for (int[] arr : matrix)
            for (int i : arr)
                nums[j++] = i;
        int n = nums.length;

        // Readymade Soln
        // Arrays.sort(nums);return nums[k];

        for (int i = n / 2; i >= 0; i--) {
            minHeapify(nums, i, n);
        }

        int count = 0;
        for (int i = n - 1; i > 0; i--) {
            if (count > k)
                break;
            count++;
            swap(nums, 0, i);
            minHeapify(nums, 0, i);
        }

        for (int i = 0; i < n; i++)
            System.out.print(nums[i] + " ");
        System.out.println("");
        return nums[n - k];
    }

    public void minHeapify(int[] nums, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int smallest = i;
        if (left < n && nums[left] < nums[smallest])
            smallest = left;

        if (right < n && nums[right] < nums[smallest])
            smallest = right;

        if (i != smallest) {
            swap(nums, i, smallest);
            minHeapify(nums, smallest, n);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // binary search approach
    public int kthSmallest2(int[][] matrix, int k) {
        int row = matrix.length;

        List<Integer> list = new ArrayList<>();
        for (int i : matrix[0]) {
            list.add(i);
        }

        for (int i = 1; i < row; i++) {
            for (int j : matrix[i])
                insertIntoSortedList(list, j);
        }
        return list.get(k - 1);
    }

    public void insertIntoSortedList(List<Integer> list, int num) {
        int n = list.size();
        int low = 0;
        int high = n - 1;
        int mid = 0;
        int midnum = list.get(0);
        while (low <= high) {
            mid = (low + high) / 2;
            midnum = list.get(mid);
            if (midnum == num)
                break;
            else if (midnum > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        midnum = list.get(mid);

        int insertPos = -1;
        if (num < midnum)
            insertPos = Math.max(0, mid);
        else if (num >= midnum)
            insertPos = Math.min(n, mid + 1);

        list.add(insertPos, num);
    }

    // A very good soln seen on leetcode discussion
    // a binary search approach but works on numbers directly rather than indexes as
    // numbers are sorted
    // row-wise as well as column wise
    // [1 5 9
    // 10 11 14
    // 12 13 15] find 8 th smallest

    // low high mid count
    // 1 15 8 2
    // 9 15 12 5
    // 13 15 14 7
    // 14 15 14 7
    // 14 14

    // [1 5 9 1 5 9 10 11 15 17 18 23
    // 10 15 18
    // 11 17 23] find 8 th smallest

    // low high mid count
    // 1 23 12 5
    // 13 23 18 8
    // 18 23 20 8
    // 18 20 19 8
    // 18 19 18 8
    // 18 18

    // observations:- the answer can be high or low as both become equal at the end
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        int mid = 0;
        int count = 0;
        while (low < high) {
            mid = (low + high) >> 1;
            count = count(matrix, mid);
            // in the intermediate stages this mid can come out to be a number which is
            // notpresent in the matrix
            // but eventually becomes one of those matrix numbers due to the adjustments;
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;// or high can work as well as they are equal in the end
    }

    // counts the numbers in matrix smaller or equal to x
    public int count(int[][] matrix, int x) {
        int count = 0;
        int n = matrix[0].length;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[j][i] <= x) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }

}