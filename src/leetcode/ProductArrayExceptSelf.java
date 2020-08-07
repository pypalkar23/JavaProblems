package leetcode;

class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int left = 1;
        int right = 1;
        result[0] = 1;
        
        for (int i = 1; i < n; i++) {
            //store the result of multiplication from 0 to i-1 lets call it 'left-multiply-result';
            left = nums[i - 1] * left;
            result[i] = left;
        }

        for (int i = n - 2; i >= 0; i--) {
            //calculate the mutiplication from end to i+1 and multiply it with the 'left-multiply-result' calcuated earlier
            right = nums[i + 1] * right;
            result[i] *= right;
        }

        for (int i : result) {
            System.out.println(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4 };
        ProductArrayExceptSelf p = new ProductArrayExceptSelf();
        p.productExceptSelf(a);
    }
}