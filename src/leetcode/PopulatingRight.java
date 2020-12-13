package leetcode;

/*116. Populating Next Right Pointers in Each Node*/
public class PopulatingRight {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        PopulatingRight ins = new PopulatingRight();
        ins.connect(node);
        ins.traverse(node);
        
    }

    public Node connect(Node root) {
        if(root==null)
            return root;
        Node current = root;
        while (current.left != null) {
            Node temp = current;
            while(current!=null){
                current.left.next = current.right;
                current.right.next = (current.next!=null)?current.next.left:null;
                current=current.next;
            }
            current = temp.left;
        }
        return root;
    }

    public void traverse(Node root){
        if(root==null)  
            return;
        Node temp = root;
        while(root!=null){
            System.out.println(root.val+" ");
            root=root.next;
        }
        System.out.println("#");
        traverse(temp.left);
    }

}

/**
 * 
 * 1 2 3 4 5 6 7
 */