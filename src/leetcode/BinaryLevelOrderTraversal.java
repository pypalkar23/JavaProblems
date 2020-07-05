package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*102.Binary Tree Level Order Traversal*/
public class BinaryLevelOrderTraversal {
    Map<Integer, List<Integer>> map = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        /*util(root, 0);
        return new ArrayList<List<Integer>>(map.values());*/

        util2(root,0);
        return ans;
    }

    private void util(TreeNode root, int level) {
        if (root == null)
            return;
        List<Integer> temp;
        if (map.get(level) == null) {
            temp = new ArrayList<>();
            temp.add(root.val);
            map.put(level, temp);
        } else {
            temp = map.get(level);
            temp.add(root.val);
            map.put(level, temp);
        }

        util(root.left, level + 1);
        util(root.right, level + 1);
    }

    public void util2(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (ans.size() < level + 1) {
            ans.add(new ArrayList<Integer>());
        }

        ans.get(level).add(root.val);

        util2(root.left, level + 1);
        util2(root.right, level + 1);
    }

}