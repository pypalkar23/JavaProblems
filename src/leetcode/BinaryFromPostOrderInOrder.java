package leetcode;

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
     * 1 2 3 4 1 2 3 4 i=0 root=1 pre - | 2 3 4 in - | 15 20 7
     * 
     * i=1 root=2 pre - | 3 4 in - | 3 4
     * 
     */
    public static void main(String[] args) {
        TreeNode t =null;
        t = new BinaryFromPostOrderInOrder().buildTree(new int[] { 4,1,2,3 }, new int[] { 1, 2, 3, 4 });
        traverse(t);
        System.out.println(" ");
        t = new BinaryFromPostOrderInOrder().buildTree(new int[] { 1,2,3 }, new int[] { 3,2,1 });
        traverse(t);
        System.out.println(" ");
        t = new BinaryFromPostOrderInOrder().buildTree(new int[] { 1,2,3 }, new int[] { 1,2,3 });
        traverse(t);
        System.out.println(" ");
        t = new BinaryFromPostOrderInOrder().buildTree(new int[] { 3,9,20,15,7 }, new int[] { 9,3,15,20,7});
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
        int modDist=0;
        TreeNode t = new TreeNode(preorder[prestart]);
        for (int i = instart; i <= inend; i++) {
            if (preorder[prestart] == inorder[i]) {
                
                System.out.println(modDist);
                System.out.println(
                        "left " + (prestart + 1) + " " + (prestart + modDist - 1) + " " + instart + " " + (i - 1));
                t.left = util(preorder, inorder, prestart + 1, prestart + modDist - 1, instart, i - 1);
                System.out.println("right " + (prestart + modDist+1) + " " + (preend) + " " + (i + 1) + " " + (inend));
                t.right = util(preorder, inorder, prestart + modDist+1, preend, i + 1, inend);
                break;
            }
            modDist++;
        }
        return t;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            //System.out.print(null + " ");
            return;
        }
        if (root != null) {
            System.out.print(root.val + " ");
            traverse(root.left);
            traverse(root.right);
        }
    }
}