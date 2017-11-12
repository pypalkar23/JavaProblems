
class TreeLinkNode{
    int val;
    TreeLinkNode left,right,next;
    TreeLinkNode(int x){
        val=x;
    }
}
class PopulatingNextRightPointers{
    public void connect(TreeLinkNode root){
        if(root==null)
            return;
        
        TreeLinkNode previousNode=null;
        TreeLinkNode currentNode=root;
        TreeLinkNode childNode=null;

        if(previousNode==null){
            currentNode.next=null;
        }
        else
        {
            
        }
        

    }
}