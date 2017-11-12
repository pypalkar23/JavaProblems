import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class LargestValueEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> lValues = new ArrayList<Integer>();
        int size = 0;

        dfs(root, 1, lValues);
        for (Integer i : lValues)
            System.out.println(i + ",");
        return null;
    }

    public void dfs(TreeNode node, int depth, List<Integer> values) {

        int size = values.size();
        if (size >= depth) {
            if (values.get(depth - 1) < node.val) {
                
                values.set(depth - 1, node.val);
            }
        } else {
            values.add(node.val);
        }

        if (node.left != null) {
            dfs(node.left, depth + 1, values);
        }
        if (node.right != null) {
            dfs(node.right, depth + 1, values);
        }
    }

    public static void main(String[] args) {
        LargestValueEachTreeRow largestValueEachTreeRow = new LargestValueEachTreeRow();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(11);
        root.left.left = new TreeNode(12);
        root.left.right = new TreeNode(10);
        largestValueEachTreeRow.largestValues(root);
    }
}