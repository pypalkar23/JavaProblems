package standardalgos;
/**
 * BTreeNode
 */
class BTreeNode {
    int t;
    boolean leaf;
    int n;
    int[] keys;
    BTreeNode[] children;

    public BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];
    }

    public void insertNotFull(int k) {
        int i = n - 1;

        if (leaf == true) {
            while (i >= 0 && this.keys[i] > k) {
                this.keys[i + 1] = this.keys[i];
                i--;
            }
            keys[i + 1] = k;
            n = n + 1;
        } else {
            while (i >= 0 && this.keys[i] > k)
                i--;
            if (this.children[i + 1].n == (2 * t - 1)) {
                this.splitChild(i + 1, children[i + 1]);

                if (this.keys[i + 1] < k)
                    i++;
            }
            this.children[i + 1].insertNotFull(k);

        }

    }

    public void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.leaf);
        z.n = t - 1;
        //System.out.println("copied");
        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j + t];
            //System.out.println(y.keys[j + t]);
        }

        if (y.leaf == false) {
            for (int j = 0; j < t; j++)
                z.children[j] = y.children[j + t];
        }

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--)
            this.children[j + 1] = this.children[j];

        this.children[i + 1] = z;

        for (int j = n - 1; j >= i; j--)
            this.keys[j + 1] = keys[j];

        this.keys[i] = y.keys[t - 1];

        this.n = this.n + 1;
    }

    public void traverse() {
        int i = 0;
        for (i = 0; i < n; i++) {
            if (this.leaf == false)
                children[i].traverse();
            System.out.println(" " + keys[i]);
        }

        if (this.leaf == false)
            children[i].traverse();
    }

    public void remove(int k) {
        int idx = this.findkey(k);

        if (idx < n && keys[idx] == k) {
            if (leaf)
                this.removeFromLeaf(idx);
            else
                this.removeFromNonLeaf(idx);
        } else {
            if (leaf) {
                System.out.println("The key" + k + "does not exist in the tree");
                return;
            }

            boolean flag = ((idx == this.n) ? true : false);
            if (this.children[idx].n < t)
            {
                this.fill(idx);
            }
            if (flag && idx > n)
                this.children[idx - 1].remove(k);
            else
                this.children[idx].remove(k);
        }
        return;
    }

    public int findkey(int k) {
        int idx = 0;
        while (idx < this.n && this.keys[idx] < k)
            idx++;

        return idx;
    }

    public void removeFromLeaf(int idx) {
        //System.out.println("removeFromLeaf");
        for (int i = idx + 1; i < n; i++)
            this.keys[i - 1] = this.keys[i];

        this.n-=1;
    }

    public void removeFromNonLeaf(int idx) {
        //-System.out.println("removeFromNonLeaf");
        int k = keys[idx];

        if (this.children[idx].n >= t) {
            int pred = this.getPred(idx);
            this.keys[idx] = pred;
            this.children[idx].remove(pred);
        } 
        else if (this.children[idx + 1].n >= t) {
            int succ = this.getSucc(idx);
            this.keys[idx] = succ;
            this.children[idx + 1].remove(succ);
        } 
        else {
            this.merge(idx);
            this.children[idx].remove(k);
        }
        return;
    }

    public void fill(int idx) {
        System.out.println("fill");
        if (idx != 0 && this.children[idx - 1].n >= t)
            this.borrowFromPrev(idx);
        else if (idx != this.n && this.children[idx + 1].n >= t)
            this.borrowFromNext(idx);
        else {
            if (idx != n)
                this.merge(idx);
            else
                this.merge(idx - 1);
        }

        return;
    }

    public int getPred(int idx) {
        System.out.println("getPred");
        BTreeNode curr = this.children[idx];
        while (!curr.leaf)
            curr = curr.children[curr.n];

        return curr.keys[curr.n - 1];
    }

    public int getSucc(int idx) {
        //System.out.println("getSucc");
        BTreeNode curr = this.children[idx + 1];
        while (!curr.leaf)
            curr = curr.children[0];

        return curr.keys[0];
    }

    public void merge(int idx) {
        System.out.println("Merge");
        BTreeNode child = this.children[idx];
        BTreeNode sibling = this.children[idx + 1];

        child.keys[t - 1] = this.keys[idx];

        for (int i = 0; i < sibling.n; i++) {
            child.keys[i + t] = sibling.keys[i];
            //System.out.println(i);
            //System.out.println(i + t);
        }

        if (!child.leaf) {
            for (int i = 0; i <= sibling.n; i++)
                child.children[i + t] = sibling.children[i];
        }

        for (int i = idx+1; i < n; i++)
            keys[i - 1] = keys[i];

        for (int i = idx+2; i <= n; i++)
            this.children[i - 1] = this.children[i];

        child.n += (sibling.n) + 1;
        this.n -= 1;

        sibling = null;

        return;
    }

    public void borrowFromPrev(int idx) {
        System.out.println("borrowFromPrev");
        BTreeNode child = this.children[idx];
        BTreeNode sibling = this.children[idx - 1];

        for (int i = (child.n) - 1; i >= 0; i--)
            child.keys[i + 1] = child.keys[i];

        if (!child.leaf) {
            for (int i = child.n; i >= 0; i--)
                child.children[i + 1] = child.children[i];
        }

        child.keys[0] = this.keys[idx - 1];

        if (!this.leaf)
            child.children[0] = sibling.children[sibling.n];

        this.keys[idx - 1] = sibling.keys[(sibling.n) - 1];

        child.n += 1;
        sibling.n -= 1;

        return;
    }

    public void borrowFromNext(int idx) {
        System.out.println("borrowFromNext");
        BTreeNode child = this.children[idx];
        BTreeNode sibling = this.children[idx + 1];

        child.keys[(child.n)] = this.keys[idx];

        if (!(child.leaf))
            child.children[(child.n) + 1] = sibling.children[0];

        this.keys[idx] = sibling.keys[0];

        for (int i = 1; i < sibling.n; i++)
            sibling.keys[i - 1] = sibling.keys[i];

        if (!sibling.leaf) {
            for (int i = 1; i <= sibling.n; i++)
                sibling.children[i - 1] = sibling.children[i];
        }

        child.n += 1;
        sibling.n -= 1;

        return;
    }

}

class BTree {
    BTreeNode root;
    int t = 3;

    public BTree() {
    }

    public void traverse() {
        if (root != null)
            root.traverse();
    }

    public void insert(int k) {
        if (root == null) {
            //System.out.println("Root Initialize");
            root = new BTreeNode(t, true);
            root.keys[0] = k;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                //System.out.println("Child Insert");
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                s.splitChild(0, root);

                int i = 0;
                if (s.keys[i] < k)
                    i++;
                s.children[i].insertNotFull(k);
                root = s;
            } else {
                //System.out.println("Root Insert");
                root.insertNotFull(k);
            }
        }
    }

    public void remove(int k) {
        if (root == null) {
            System.out.println("Tree is Empty");
            return;
        }
        root.remove(k);

        if (root.n == 0) {
            if (root.leaf)
                root = null;
            else
                root = root.children[0];

            
        }

    }
}

public class BtreeMain {
    public static void main(String[] args) {
        BTree tree = new BTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);
        //tree.traverse();
        // System.out.println("delete 17");
        tree.remove(17);
        tree.remove(30);
        tree.remove(20);
        tree.remove(12);
        // tree.traverse();
        // System.out.println("delete 12");
        
        //tree.traverse();
        //tree.traverse();
       
        tree.traverse();
        // for (int k : tree.root.keys) {
        //     if(k!=0)
        //     System.out.println(k);
        // }
        System.out.println(tree.root.leaf);
    }
}