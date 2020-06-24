package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElement {
    //sol2
    int count, ans;
    public static void main(String[] args) {
        
    }
    
    public int kthSmallest(TreeNode root, int k) {
        //sol 1
        // List<Integer> inordernums = new ArrayList<Integer>();
        // util(root,k,inordernums);
        // return inordernums.get(k-1);

        //sol2
        util2(root, k);
        return ans;
    }
    // sol 1
    public void util(TreeNode root,int k, List<Integer> inordernums){
        if(root==null)
            return;
        util(root.left,k,inordernums);
        inordernums.add(root.val);
        if(inordernums.size()==k)
            return;
        util(root.right,k,inordernums);
    }

    //sol2
    public void util2(TreeNode root,int k){
        if(root==null)
            return;
        util2(root.left,k);
        count++;
        
        if(count==k)
        {
            ans=root.val;
            return;
        }
        System.out.println(count+">"+root.val);
        util2(root.right,k);
    }

}