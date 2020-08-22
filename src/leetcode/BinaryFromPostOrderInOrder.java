package leetcode;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryFromPostOrderInOrder {
    /*
     * 3 9 20 15 7 
     * 9 3 15 20 7 
     * i=1 
     * pre 9 | 20 15 7 
     * in 9 | 15 20 7
     * 
     * i=2
     * 
     * 
     * 
     */
    public static void main(String[] args) {
        TreeNode t = new BinaryFromPostOrderInOrder().buildTree(
                new int[] { 1,2,3,4 },
                new int[] { 1,2,3,4});
        traverse(t);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode t = util(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
        return t;
    }

    public TreeNode util(int[] preorder, int[] inorder, int prestart, int preend, int instart, int inend) {

        if (instart > inend) {
            return null;
        }
        if (instart == inend) {
            return new TreeNode(inorder[instart]);
        }
        TreeNode t = new TreeNode(preorder[prestart]);
        for (int i = instart; i <= inend; i++) {
            if (preorder[prestart] == inorder[i]) {
                System.out.println("left " + (prestart + 1) + " " + (prestart + i) + " " + instart + " " + (i - 1));
                t.left = util(preorder, inorder, prestart + 1, prestart + i, instart, i - 1);
                System.out.println("right " + (prestart + i + 1) + " " + (preend) + " " + (i + 1) + " " + (inend));
                t.right = util(preorder, inorder, prestart + i + 1, preend, i + 1, inend);
                break;
            }
        }
        return t;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            System.out.print(null + " ");
            return;
        }
        if (root != null) {
            System.out.print(root.val + " ");
            traverse(root.left);
            traverse(root.right);
        }
    }
}