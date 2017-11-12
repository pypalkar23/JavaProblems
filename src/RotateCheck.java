import java.util.LinkedList;

class RotateCheck{
   
    static Node root;
    public static void main(String[] args) {
        root=new Node(10);
        root.left=new Node(5);
        root.left.parent=root;
        Node leftChild=root.left;
       
        root.right=new Node(15);
        root.right.parent=root;
        Node rightChild=root.right;
        traverse(root);
        System.out.println("");
        rotateCheck(root);
        traverse(root);
        System.out.println("");
        leftChild.color=true;
        rightChild.color=true;
        System.out.println(root.data);
        traverse(root);
    }


    public static void traverse(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (queue.size() != 0) {
            Node node = queue.poll();

            System.out.print(node.data+"-"+node.color+ " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

    }

    public static void rotateCheck(Node n){
        Node temp=root;
        root=temp.left;
        root.right=temp;
        temp.left=null;
    }
}


 class Node{
        int data;
        Node left;
        Node right;
        Node parent;
        boolean color;
        public Node(int a)
        {
            this.data=a;
        }
    }
