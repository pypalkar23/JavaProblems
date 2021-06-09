package standardalgos;

class Edge {
    int src;
    int dest;
}

class Graph {
    int v;
    Edge[] edges;

    public Graph(int v) {
        this.v = v;
        this.edges = new Edge[v];

    }

}

class UnionFind {
    public int find(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    public boolean union(Edge[] edges, int parent[]) {
        int v = edges.length;
        for (int i = 0; i < v; i++) {
            int xparent = find(parent, edges[i].src);
            int yparent = find(parent, edges[i].dest);
            if (xparent == yparent)
                return true;

            parent[xparent] = yparent;

        }
        return false;
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind();
        int parent[] = new int[3];
        Edge edges[] = new Edge[2];
        for (int i = 0; i < 3; i++) {
            parent[i] = -1;
        }

        for (int i = 0; i < 2; i++) {
            edges[i] = new Edge();

        }

        edges[0].src = 0;
        edges[0].dest = 1;

        edges[1].src = 1;
        edges[1].dest = 2;

        System.out.println((unionFind.union(edges, parent)) ? "cycle exists" : "clean one");

    }
}
