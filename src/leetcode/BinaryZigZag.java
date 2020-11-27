package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*103. Binary Tree Zigzag Level Order Traversal
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/

public class BinaryZigZag {
    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        Boolean reverseFlag = false;//when false the leaves of that level goes into stack in left to right fashion and as a result while printing comes out right to left
        List<Integer> currentLevelElements = new ArrayList<Integer>();

        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {
            TreeNode currentNode = currentLevel.pop();
            currentLevelElements.add(currentNode.val);
            if (reverseFlag) {
                if (currentNode.right != null)
                    nextLevel.push(currentNode.right);
                if (currentNode.left != null)
                    nextLevel.push(currentNode.left);
            } else {
                if (currentNode.left != null)
                    nextLevel.push(currentNode.left);
                if (currentNode.right != null)
                    nextLevel.push(currentNode.right);
            }

            if (currentLevel.isEmpty()) {
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                ans.add(new ArrayList<Integer>(currentLevelElements));
                currentLevelElements.clear();
                reverseFlag = !reverseFlag;
            }
        }
        return ans;
    }

}