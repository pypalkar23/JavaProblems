package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*373. Find K Pairs with Smallest Sums*/
class KPairsWithSmallestSum {
    public static void main(String[] args) {
        int a[] = new int[] { 1, 7, 11 };
        int b[] = new int[] { 2, 4, 6 };
        List<List<Integer>> ans = new KPairsWithSmallestSum().kSmallestPairs(a, b, 3);
        for (List<Integer> l : ans) {
            for (int i : l)
                System.out.print(i + " ");
            System.out.println("");
        }

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((x, y) -> (x[0] + x[1]) - (y[0] + y[1]));
        for (int n1 : nums1)
            for (int n2 : nums2) {
                queue.add(new Integer[] { n1, n2 });
            }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        while (k > 0) {
            ans.add(Arrays.asList(queue.poll()));
            k--;
        }

        return ans;
    }
}