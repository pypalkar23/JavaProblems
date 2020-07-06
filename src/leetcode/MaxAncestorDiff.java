package leetcode;

/*1026. Maximum Difference Between Node and Ancestor*/
public class MaxAncestorDiff {
    public int maxDiff = Integer.MIN_VALUE;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        System.out.println(new MaxAncestorDiff().maxAncestorDiff(root));
    }

    public int maxAncestorDiff(TreeNode root) {
        util(root, root.val, root.val);
        return maxDiff;
    }

    public void util(TreeNode current, int max, int min) {
        if (current == null)
            return;
        // calculate maxdiff by comparing the current maxDiff, difference between the
        // current val and max till that level and difference between the current val
        maxDiff = Math.max(maxDiff, Math.max(Math.abs(current.val - max), Math.abs(current.val - min)));
        // proceed to next level by calculating new max and new min
        // new max is maximum between current node value and max till that point
        // new min is minimum between current node value and min till that point
        util(current.left, Math.max(current.val, max), Math.min(current.val, min));
        util(current.right, Math.max(current.val, max), Math.min(current.val, min));
    }
}