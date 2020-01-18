package standardalgos;
import java.util.List;


class BinaryTree
{
    class Node{
    int data;
    Node left;
    Node right;
}
    static boolean v1,v2;
    Node root;
    public BinaryTree()
    {
        root=null;
    }

    public void insert(int data)
    {
        root=insert(root,data);
    }
    public Node insert(Node node,int data)
    {
        if(node==null)
        {
            node=new Node();
            node.data=data;
            node.left=null;
            node.right=null;
        }
        else
        {
            if(data<node.data)
            {
                node.left=insert(node.left,data);
            }
             if(data>node.data)
            {
                node.right=insert(node.right,data);
            }
        }
        return node;
    }
    public void inorder()
    {
       inOrderTraverse(root);
    }

    public void inOrderTraverse(Node root)
    {  if(root==null) 
            return;
        inOrderTraverse(root.left);
        System.out.println(root.data);
        inOrderTraverse(root.right);
    }

    public void delete(int data)
    {
        root=delete(root,data);
    }

    public int findMin(Node current)
    {
        Node node=current;
        int minVal=current.data;
        if(node.left!=null)
            {   minVal=node.left.data;
                node=node.left;
            }
        return minVal;
    }

    public Node delete(Node root,int data){
        if (root==null)
        {
            return null;
        }
        else if(data<root.data)
        {
            root.left=delete(root.left, data);
        }
        else if(data>root.data)
        {
            root.right=delete(root.right, data);
        }
        else
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }

            root.data=findMin(root.right);
            root.right=delete(root.right,root.data);
        }

        return root;
    }

    public int getHeight()
    {
        return getHeight(root);
    }
    public int getHeight(Node root)
    {
        if(root==null)
        return 0;
        else
        return 1+(Math.max(getHeight(root.left),getHeight(root.right)));
    }


    // public int findLCA(int  node1,int node2) {
    //     return findLCA(root,node1,node2);
       
    // }


    // public int findLCA(Node root,int node1,int node2){
    //     List<Integer> path1=new LinkedList<Integer>();
    //     List<Integer> path2=new LinkedList<Integer>();
        
    //     if(! findPath(root,path1,node1) || !findPath(root,path2,node2))
    //         return -1;
    //     int i=0;
    //     for(i=0;i<path1.size() && i<path2.size();i++){
    //         if(path1.get(i)!=path2.get(i))
    //             break;
    //     }
    //     return path1.get(i-1);

    // }

      Node findLCAUtil(Node node, int n1, int n2)
    {
        // Base case
        if (node == null)
            return null;
 
        // If either n1 or n2 matches with root's key, report the presence
        // by setting v1 or v2 as true and return root (Note that if a key
        // is ancestor of other, then the ancestor key becomes LCA)
        if (node.data == n1)
        {
            v1 = true;
            return node;
        }
        if (node.data == n2)
        {
            v2 = true;
            return node;
        }
 
        // Look for keys in left and right subtrees
        Node left_lca = findLCAUtil(node.left, n1, n2);
        Node right_lca = findLCAUtil(node.right, n1, n2);
 
        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;
 
        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }
 
    // Finds lca of n1 and n2 under the subtree rooted with 'node'
    Node findLCA(int n1, int n2)
    {
        // Initialize n1 and n2 as not visited
        v1 = false;
        v2 = false;
 
        // Find lca of n1 and n2 using the technique discussed above
        Node lca = findLCAUtil(root, n1, n2);
 
        // Return LCA only if both n1 and n2 are present in tree
        if (v1 && v2)
            return lca;
 
        // Else return NULL
        return null;
    }

    public boolean findPath(Node root,List<Integer> path,int node1){
        if(root==null){
            return false;
        }

        path.add(root.data);
        
        if(node1==root.data)
            return true;
        
        if(findPath(root.left,path,node1)||findPath(root.right,path,node1))
            return true;

        path.remove(path.size()-1);        
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(90);
        tree.insert(10);
        tree.insert(5);
        //tree.inorder();
        System.out.println("");

        System.out.println();
        //System.out.println(tree.getHeight());
    }
}