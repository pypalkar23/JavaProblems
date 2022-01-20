package leetcode;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return mid;
            //normal case   
            else if (nums[mid] >= nums[start]) {
                if (target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else { //not normal case
                if (target <= nums[end] && target > nums[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}

//4 5 6 7 0 1 2  0
//0 1 2 3 4 5 6

/**
 * 
 * 0 6 3   
 * 0 
 */




