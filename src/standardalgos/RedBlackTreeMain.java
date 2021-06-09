package standardalgos;

import java.util.LinkedList;

class RedBlackTree {
    class Node {
        int data;
        Node left;
        Node right;
        Node parent;
        boolean color;
        boolean isNull;

        public Node(int data) {
            this.data = data;
            this.left = new NullNode(this);
            this.right = new NullNode(this);
        }

        public Node() {
        }
    }

    class NullNode extends Node {

        public NullNode(Node parent) {
            this.color = true;
            this.isNull = true;
            this.parent = parent;
        }

    }

    Node root;

    public Node insert(Node n, Node nleaf) {
        if (n == null || (n != null && n.isNull)) {
            n = nleaf;
        } else if (nleaf.data < n.data) {
            n.left = insert(n.left, nleaf);
            n.left.parent = n;
        } else if (nleaf.data > n.data) {
            n.right = insert(n.right, nleaf);
            n.right.parent = n;
        }

        return n;
    }

    public void insert(int data) {
        Node n = new Node(data);

        root = insert(root, n);
        fixAfterInsertion(n);
    }

    public void rotateLeft(Node n) {
        Node x = n.right;
        n.right = x.left;
        if ((n.right) != null) {
            n.right.parent = n;
        }
        x.parent = n.parent;

        if (isNull(n.parent))
            root = x;
        else if (n == n.parent.left)
            n.parent.left = x;
        else
            n.parent.right = x;
        x.left = n;
        n.parent = x;

    }

    public void rotateRight(Node n) {
        Node x = n.left;
        n.left = x.right;
        if ((n.left) != null) {
            n.left.parent = n;
        }
        x.parent = n.parent;

        if (isNull(n.parent))
            root = x;
        else if (n == n.parent.left)
            n.parent.left = x;
        else
            n.parent.right = x;
        x.right = n;
        n.parent = x;

    }

    public void fixAfterInsertion(Node n) {
        Node parent = null;
        Node grandParent = null;
        // Node current=n;

        while ((n != root) && (n.color == false) && (n.parent.color == false)) {
            // two consecutive reds are not allowed.
            // System.out.println("n: "+n.data);

            parent = n.parent;
            grandParent = parent.parent;
            // System.out.println("parent: "+parent.data);
            // System.out.println("grandParent: "+grandParent.data);

            if (parent == grandParent.left) {
                Node uncle = grandParent.right;
                /**
                 * Uncle is red,reverse the color for parent,uncle and grandparent and assign
                 * grandparent as new n
                 */
                if (!uncle.isNull && uncle.color == false) {
                    grandParent.color = false;
                    parent.color = true;
                    uncle.color = true;
                    n = n.parent.parent;
                }

                else {
                    /** Uncle is black, */

                    if (n == parent.right) {
                        /** Left Right case */
                        rotateLeft(parent);
                        parent = n;
                        System.out.println(parent.data + " " + n.data);

                    }
                    /** Left Right case */
                    rotateRight(grandParent);
                    // grandParent =parent.right;
                    boolean temp = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = temp;
                    n = parent;
                }
            } else {
                Node uncle = grandParent.left;
                if (!uncle.isNull && (uncle.color == false)) {
                    grandParent.color = false;
                    parent.color = true;
                    uncle.color = true;
                    n = n.parent.parent;
                } else {
                    if (n == parent.left) {
                        rotateRight(parent);
                        parent = n;
                        // n=parent.left;
                    }
                    rotateLeft(grandParent);
                    grandParent = parent.left;
                    boolean temp = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = temp;
                    n = parent;
                }
            }
        }

        root.color = true;
    }

    public void traverse(Node root) {
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (queue.size() != 0) {
            Node node = queue.poll();

            System.out.print(node.data + "-");
            System.out.print((node.color == true) ? "B " : "R ");
            System.out.print((node.parent != null) ? node.parent.data : "null");
            System.out.print(" ");
            if (node.left != null && !node.left.isNull) {
                queue.add(node.left);
            }
            if (node.right != null && !node.right.isNull) {
                queue.add(node.right);
            }
        }

    }

    public int findMin(Node current) {
        Node node = current;
        int minVal = current.data;
        if (!isNull(node.left)) {
            minVal = node.left.data;
            node = node.left;
        }
        return minVal;
    }
    // public void delete(int data)
    // {
    // root=delete(root,data);
    // }

    public void delete(Node root, int data) {
        Node node = (Node) nodeContaining(root, data);
        // System.out.println(node.data);

        if (isNull(node))
            return;
        boolean originalColor = node.color;
        // System.out.println((originalColor)?"Black":"Red");
        Node parent = node.parent;
        if (isNull(node.left)) {
            boolean childColor = node.right.color;
            node = replace(node, node.right);
            node.parent = parent;
            // System.out.println(node.color);
            // System.out.println(node.data);
            if (originalColor == childColor) {
                adjustAfterRemoval(node);
            }
        } else if (isNull(node.right)) {
            boolean childColor = node.right.color;
            node = replace(node, node.left);
            node.parent = parent;
            // System.out.println(node.color);
            // System.out.println(node.data);
            if (originalColor == childColor) {
                adjustAfterRemoval(node);
            }
        } else {
            int tempData = findMin(node.right);
            node.data = tempData;
            delete(root.right, tempData);

            // node.parent = parent;
        }

    }

    public void adjustAfterRemoval(Node n) {

        while (n != root && colorOf(n) == true) {
            if (n == n.parent.left) {
                Node sibling = n.parent.right;
                // sibling is red
                if (sibling.color == false) {
                    setColorOf(sibling, true);
                    setColorOf(n.parent, false);
                    rotateLeft(n.parent);
                    sibling = n.parent.right;
                }
                // both child of sibling are black color sibling red and recur for parent
                if (colorOf(sibling.left) == true && colorOf(sibling.right) == true) {
                    setColorOf(sibling, false);
                    n = n.parent;
                } else {
                    // one of the sibling's child is red
                    // the other one(right) probably sentinel node will be black
                    // rotate in opposite direction
                    if (colorOf(sibling.right) == true) {
                        setColorOf(sibling.left, true);
                        setColorOf(sibling, false);
                        rotateRight(sibling);
                        sibling = n.parent.right;
                    }

                    setColorOf(sibling, n.parent.color);
                    setColorOf(n.parent, true);
                    setColorOf(sibling.right, true);
                    rotateLeft(n.parent);
                    n = (Node) root;
                }

            } else {
                Node sibling = n.parent.left;
                if (sibling.color == false) {
                    // Sibling is red
                    setColorOf(sibling, true);
                    setColorOf(n.parent, false);
                    rotateRight(n.parent);
                    sibling = n.parent.left;

                }
                if (colorOf(sibling.left) == true && colorOf(sibling.right) == true) {
                    setColorOf(sibling, false);
                    n = n.parent;
                } else {
                    // one of the sibling's child is red
                    // the other one(left) probably sentinel node will be black
                    if (colorOf(sibling.left) == true) {
                        setColorOf(sibling.right, true);
                        setColorOf(sibling, false);
                        rotateLeft(sibling);
                        // System.out.println("Node"+n.parent.left.data);
                        // System.out.println("Node"+n.parent.left.color);
                        sibling = n.parent.left;

                    }
                    setColorOf(sibling, n.parent.color);
                    setColorOf(n.parent, true);
                    setColorOf(sibling.left, true);
                    // System.out.println(n.data+" "+n.parent.data);
                    rotateRight(n.parent);
                    n = (Node) root;

                }
            }

        }
        setColorOf(n, true);
    }

    public Node nodeContaining(Node root, int data) {
        // Node n=null;

        if (root.data == data)
            return root;
        Node current = root;
        while (!isNull(current) && current.data != data) {
            if (data < current.data)
                current = current.left;
            else
                current = current.right;

        }
        // System.out.println(current.data);
        return current;
    }

    public boolean colorOf(Node n) {
        return (n == null) ? true : (n.color);
    }

    public void setColorOf(Node n, boolean color) {
        if (n == null)
            return;
        n.color = color;
    }

    public boolean isNull(Node n) {
        return (n == null) ? true : (n.isNull) ? true : false;
    }

    public Node replace(Node n1, Node n2) {
        if (n1 == n1.parent.left) {
            n1.parent.left = n2;
        } else
            n1.parent.right = n2;
        return n2;
    }

}

class RedBlackTreeMain {
    public static void main(String[] args) {
        RedBlackTree r = new RedBlackTree();
        r.insert(15);
        r.traverse(r.root);
        System.out.println("");
        r.insert(17);
        r.traverse(r.root);
        System.out.println("");
        r.insert(12);
        r.traverse(r.root);
        System.out.println("");
        r.insert(8);
        r.traverse(r.root);
        System.out.println("");
        r.insert(9);
        r.traverse(r.root);
        // r.delete(r.root, 20);
        // r.traverse(r.root);
        // System.out.println("");
        // System.out.println(r.root.data);
        // System.out.println(r.root.color);
        // System.out.println(r.root.parent);
        // System.out.println(r.root.left.data);
        // System.out.println(r.root.left.color);
        // System.out.println(r.root.left.parent.data);
        // System.out.println(r.root.right.data);
        // System.out.println(r.root.right.color);
        // System.out.println(r.root.right.parent.data);
        // System.out.println(r.root.right.left.data);
        // System.out.println(r.root.right.left.color);
        // System.out.println(r.root.right.left.parent.data);

    }

}