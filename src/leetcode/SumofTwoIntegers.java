package leetcode;
/*371. Sum of Two Integers*/
public class SumofTwoIntegers {
    public static void main(String[] args) {
        SumofTwoIntegers s=new SumofTwoIntegers();
        System.out.println(s.getSum(4,5));
        System.out.println(s.getSum(4,-5));
    }

    /*Look at the python solution as well it need use of mask 0xffffffff here
    https://leetcode.com/problems/sum-of-two-integers/discuss/776952/Python-BEST-LeetCode-371-Explanation-for-Python*/
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;// and is like carrying
            a = a ^ b;// xor is like summing
            b = carry << 1;
        }

        return a;

    }
}