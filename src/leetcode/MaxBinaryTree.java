package leetcode;
/*654. Maximum Binary Tree*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class MaxBinaryTree {

    public static void main(String[] args) {
        int a[] = new int[] { 3, 2, 1, 6, 0, 5 };
        MaxBinaryTree m = new MaxBinaryTree();
        TreeNode root = m.constructMaximumBinaryTree(a);
        m.traverse(root);

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = constructTreeUtil(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode constructTreeUtil(int[] nums, int l, int r) {
        if (r < 0 || l > r) {
            return null;
        }
        if (l - r == 0) {
            TreeNode t = new TreeNode(nums[l]);
            return t;
        }

        int max = nums[l];
        int pos = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                pos = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructTreeUtil(nums, l, pos - 1);
        root.right = constructTreeUtil(nums, pos + 1, r);

        return root;
    }

    public void traverse(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            traverse(root.left);
            traverse(root.right);
        }
    }
}