 /*1302. Deepest Leaves Sum*/
 class DeepestLeaveSum{
    int sum = 0;
    int deep = 0;
    public static void main(String[] args) {
        
    }

    public int deepestLeavesSum(TreeNode root) {
       traversal(root, 0);
       return sum;
    }

    public void traversal(TreeNode root,int level){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            if(level>deep){
                deep=level;
                sum = root.val;
            }
            else if(deep==level)
                sum += root.val;
        }

        traversal(root.left, level+1);
        traversal(root.right, level+1);
    }
 }