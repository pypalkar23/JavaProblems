package leetcode;

/*215. Kth Largest Element in an Array*/
public class KthLargestElement {
    public static void main(String[] args) {
        int a[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        KthLargestElement ins = new KthLargestElement();
        System.out.println(ins.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
        System.out.println(ins.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        //Readymade Soln
        //Arrays.sort(nums);return nums[nums.length-k];
        int n = nums.length;

        for (int i = n / 2; i >= 0; i--) {
            heapify(nums, i, n);
        }

        int count = 0;
        for (int i = n - 1; i > 0; i--) {
            if (count > k)
                break;
            count++;
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }

        for (int i = 0; i < n; i++)
            System.out.print(nums[i] + "");
        System.out.println("");
        return nums[n - k];
    }

    public void heapify(int[] nums, int i, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int largest = i;
        if (left < n && nums[left] > nums[largest])
            largest = left;

        if (right < n && nums[right] > nums[largest])
            largest = right;

        if (i != largest) {
            swap(nums, i, largest);
            heapify(nums, largest, n);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}