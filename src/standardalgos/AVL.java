package standardalgos;

class AVL {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        AVLTree tree = new AVLTree();
        tree.insert(60);
        tree.insert(20);
        tree.insert(70);
        tree.insert(65);
        tree.insert(80);
        tree.inorder();
        tree.delete(20);
        System.out.println(" ");
        tree.inorder();

    }
}

class AVLTree {
    class Node {
        int data;
        int height;
        Node left;
        Node right;

        public Node() {
            height = 1;
        }
    }

    Node root;

    public Node insert(int data) {
        root = insert(root, data);
        return root;
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            root = new Node();
            root.data = data;
        }

        else if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        int balance = getBalance(root);
        /* left left case */
        if (balance > 1 && data < root.left.data)
            root = rightRotate(root);

        /* right right case */
        if (balance < -1 && data > root.right.data)
            root = leftRotate(root);

        /* left right case */
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            root = rightRotate(root);
        }

        /* right left case */
        if (balance < -1 && data < root.right.data) {
            root.left = rightRotate(root.left);
            root = leftRotate(root);
        }

        return root;
    }

    public int getHeight(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    public int getBalance(Node root) {
        if (root == null)
            return 0;
        return getHeight(root.left) - getHeight(root.right);
    }

    public Node findMin(Node root) {
        Node temp = root;
        while (temp.right != null)
            temp = temp.right;
        return temp;
    }

    public Node delete(int data) {
        return delete(root, data);
    }

    public Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data > data) {
            root.left = delete(root.left, data);
        } else if (root.data < data) {
            root.right = delete(root.right, data);
        }

        else if (root.data == data) {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                root.data = findMin(root.right).data;
                root.right = delete(root.right, root.data);
            }

        }

        int balance = getBalance(root);

        root.height = Math.max(root.left.height, root.right.height);

        if (balance > 1 && getBalance(root.left) >= 0) {
            root = rightRotate(root);
        }
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = rightRotate(root.left);
            root = rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) {
            root = leftRotate(root);
        }
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            root = leftRotate(root);
        }

        return root;
    }

    public void inorder() {
        inorder(this.root);
    }

    public Node leftRotate(Node node) {
        Node y = node.right;
        Node T2 = y.left;

        node.right = T2;
        y.left = node;

        node.height = 1 + Math.max(node.left.height, node.right.height);
        y.height = 1 + Math.max(node.left.height, y.right.height);

        return y;
    }

    public Node rightRotate(Node node) {
        Node y = node.left;
        Node T2 = y.right;

        node.left = T2;
        y.right = node;

        node.height = 1 + Math.max(node.left.height, node.right.height);
        y.height = 1 + Math.max(node.left.height, y.right.height);

        return y;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

}