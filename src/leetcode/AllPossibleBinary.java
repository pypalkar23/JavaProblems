
/** 894. All Possible Full Binary Trees */
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class AllBinaryTrees {
    Map<Integer, List<TreeNode>> cache = new HashMap<Integer, List<TreeNode>>();

    public static void main(String[] args) {
        AllBinaryTrees a = new AllBinaryTrees();
        List<TreeNode> ans = a.allPossibleFBT(7);
        for (TreeNode t : ans) {
            a.traverse(t);
            System.out.println("");
        }

    }

    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (N == 1) {
            TreeNode t = new TreeNode(0);
            res.add(t);
            return res;
        }

        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        if ((N & 1) == 0) {
            return res;
        }
        N = N - 1;// Because One is Main Node
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> allLeft = allPossibleFBT(i);
            List<TreeNode> allRight = allPossibleFBT(N - i);
            System.out.println("left for " + (N + 1) + " " + allLeft.size());
            System.out.println("right for " + (N + 1) + " " + allRight.size());
            for (TreeNode l : allLeft) {
                for (TreeNode r : allRight) {
                    TreeNode t = new TreeNode(0);
                    t.left = l;
                    t.right = r;
                    res.add(t);
                }
            }
        }
        return res;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        if (root != null) {
            System.out.print(root.val + " ");
            traverse(root.left);
            traverse(root.right);
        }
    }
}