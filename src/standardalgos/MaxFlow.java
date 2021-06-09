package standardalgos;

import java.util.LinkedList;
import java.util.Queue;

class MaxFlow {
    public static int V = 6;

    public static void main(String[] args) {
        int[][] graph = { { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 }, { 0, 4, 0, 0, 14, 0 }, { 0, 0, 9, 0, 0, 20 },
                { 0, 0, 0, 7, 0, 3 }, { 0, 0, 0, 0, 0, 0 } };

        MaxFlow mincut = new MaxFlow();
        System.out.println(mincut.fordFulkerson(graph, 0, 5));
    }

    public boolean bfs(int[][] rGraph, int parent[], int s, int t) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return visited[t] == true;
    }

    public int fordFulkerson(int[][] graph, int s, int t) {
        int rGraph[][] = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                rGraph[i][j] = graph[i][j];
            }
        int parent[] = new int[V];
        int max_flow = 0;
        while (bfs(rGraph, parent, s, t)) {
            int pathFlow = Integer.MAX_VALUE;
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(rGraph[u][v], pathFlow);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
            max_flow += pathFlow;
        }

        return max_flow;
    }
}