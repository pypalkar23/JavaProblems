
package standardalgos;

class SegmentTree {
    int seq[];
    int tree[];
    int lazy[];
    int n = 0;

    public SegmentTree(int a[]) {
        seq = a;
        n = seq.length;
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = (int) (2 * (int) Math.pow(2, x) - 1);
        tree = new int[max_size];
        lazy = new int[max_size];
        build(0, 0, n - 1);
    }

    public void build(int node, int start, int end) {
        if (start == end) {// Leaf node will have a single element
            // System.out.println(node+" "+seq[start]);
            tree[node] = seq[start];
        } else {
            // System.out.println("Start "+start+" end"+end);
            int mid = (start + end) / 2;
            // Recurse on the left child
            build(2 * node + 1, start, mid);
            // Recurse on the right child
            build((2 * node) + 2, mid + 1, end);
            // Internal node will have the sum of both of its children
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public void update(int idx, int val) {
        update(0, 0, n - 1, idx, val);
    }

    public void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            // Leaf node
            seq[idx] += val;
            tree[node] += val;
        } else {
            int mid = (start + end) / 2;
            if (start <= idx && idx <= mid) {
                // If idx is in the left child, recurse on the left child
                update(2 * node + 1, start, mid, idx, val);
            } else {
                // if idx is in the right child, recurse on the right child
                update(2 * node + 2, mid + 1, end, idx, val);
            }

            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }
    }

    public int query(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    public int query(int node, int start, int end, int l, int r) {
        // out of range
        if (r < start || end < l || start > end) {
            return 0;
        }

        if (l <= start && end <= r) {

            return tree[node];
        }

        int mid = (start + end) / 2;
        int p1 = query(2 * node + 1, start, mid, l, r);
        int p2 = query(2 * node + 2, mid + 1, end, l, r);
        return p1 + p2;

    }

    public void updateRange(int node, int start, int end, int l, int r, int val) {
        if (start > end || start > r || end < l)
            return;
        if (start == end) {
            // Add the difference to current node
            tree[node] += val;
            return;
        }
        // If not a leaf node, recur for children.
        int mid = (start + end) / 2;
        updateRange(2 * node + 1, start, mid, l, r, val);
        updateRange(2 * node + 2, mid + 1, end, l, r, val);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public void print() {
        System.out.println("Tree--->");
        for (int i : tree)
            System.out.print(i + " ");
        System.out.println(" ");

    }

    public static void main(String[] args) {
        int a[] = { 1, 3, 5, 7, 9, 11 };
        SegmentTree s = new SegmentTree(a);
        s.print();
        System.out.println(s.query(1, 3));
        s.update(1, 1);
        s.print();
    }
}