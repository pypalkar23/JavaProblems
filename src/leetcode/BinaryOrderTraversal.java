package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> s = new Stack<>();
        TreeNode temp = null;
        temp = root;
        while (temp != null || !s.isEmpty()) {
            while (temp != null) {
                s.push(temp);
                temp = temp.left;
            }

            temp = s.pop();
            ans.add(temp.val);
            temp = temp.right;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(4);
        r.left = new TreeNode(5);
        r.right = new TreeNode(6);
        BinaryOrderTraversal inst = new BinaryOrderTraversal();
        List<Integer> ans = inst.inorderTraversal(r);
        for (int a : ans) {
            System.out.println(a + " ");
        }
    }
}