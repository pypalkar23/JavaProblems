package standardalgos;
class Node {
        String data;
        int freq;
        Node left;
        Node right;

        public Node() {
        }

        public Node(String data, int freq) {
                this.data = data;
                this.freq = freq;
        }

        public Node(String data, int freq, Node left, Node right) {
                this.data = data;
                this.freq = freq;
                this.left = left;
                this.right = right;
        }
}

class Encode {
        Node[] nodes;
        int size = 0;

        public void encode(String[] data, int[] freq) {
                int n = data.length;
                nodes = new Node[n];
                for (int i = 0; i < n; i++) {
                        nodes[i] = new Node(data[i], freq[i]);
                }

                buildMinHeap(nodes, n);

                while (n > 1) {
                        Node left = removeTop(nodes, n--);
                        Node right = removeTop(nodes, n--);

                        Node node = new Node(null, left.freq + right.freq, left, right);
                        addElement(nodes, node, ++n);
                }

                Node huffRoot = nodes[0];
                printEncoded(huffRoot, "");
        }

        public void buildMinHeap(Node nodes[], int n) {
                int roots = n / 2;
                for (int i = roots; i >= 0; i--) {
                        minHeapify(nodes, i, n);
                }
        }

        public void minHeapify(Node nodes[], int i, int n) {
                int left = i * 2 + 1;
                int right = left + 1;
                int length = n;
                int smallest = i;
                if (left < length && nodes[left].freq < nodes[smallest].freq)
                        smallest = left;
                if (right < length && nodes[right].freq < nodes[smallest].freq)
                        smallest = right;
                if (i != smallest) {
                        swap(nodes, i, smallest);
                        minHeapify(nodes, smallest, n);
                }
        }

        public void swap(Node nodes[], int i, int j) {
                Node temp = nodes[i];
                nodes[i] = nodes[j];
                nodes[j] = temp;
        }

        public void heapifyUp(Node nodes[], int n) {
                int ci = n - 1;
                int parent = (n / 2) - 1;

                if (parent >= 0 && (nodes[parent].freq > nodes[ci].freq)) {
                        swap(nodes, parent, ci);
                        heapifyUp(nodes, parent + 1);
                }
        }

        public void addElement(Node nodes[], Node node, int n) {
                nodes[n - 1] = node;
                heapifyUp(nodes, n);
        }

        public Node removeTop(Node nodes[], int n) {
                Node node = nodes[0];
                swap(nodes, 0, n - 1);
                minHeapify(nodes, 0, n - 1);
                return node;
        }

        private void printEncoded(Node huffRoot, String code) {
                if (huffRoot == null)
                        return;
                if (huffRoot.data != null) {
                        System.out.println(huffRoot.data + " : " + code);
                }

                printEncoded(huffRoot.left, code + "0");
                printEncoded(huffRoot.right, code + "1");
        }

}

class huffman {
        public static void main(String args[]) {
                String arr[] = { "a", "b", "c", "d", "e", "f" };
                int freq[] = { 5, 9, 12, 13, 16, 45 };
                Encode e = new Encode();
                e.encode(arr, freq);
        }
}
