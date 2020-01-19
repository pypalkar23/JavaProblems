package standardalgos;
import java.util.LinkedList;
import java.util.Queue;

class MinCut {
    public static int V = 6;

    public static void main(String[] args) {
        int[][] graph = { { 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 }, { 0, 4, 0, 0, 14, 0 }, { 0, 0, 9, 0, 0, 20 },
                { 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };

        MinCut mincut = new MinCut();
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

    public void dfs(int[][] rGraph, int s, boolean visited[]) {
        visited[s] = true;
        for (int i = 0; i < V; i++)
            if (rGraph[s][i] > 0 && !visited[i]) {
                dfs(rGraph, i, visited);
            }

    }

    public void printGraph(int[][] rGraph) {
        for (int i = 0; i < rGraph.length; i++) {
            for (int j = 0; j < rGraph[i].length; j++) {
                System.out.print(rGraph[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("---------------------------------");
    }

    public int fordFulkerson(int[][] graph, int s, int t) {
        int rGraph[][] = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                rGraph[i][j] = graph[i][j];
            }
        int parent[] = new int[V];
        int max_flow = 0;
        printGraph(rGraph);

        while (bfs(rGraph, parent, s, t)) {
            int pathFlow = Integer.MAX_VALUE;
            System.out.print(t);
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                System.out.print("-" + u);
            }
            System.out.println(" ");
            System.out.println("---------------------------------");

            System.out.println("");
            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(rGraph[u][v], pathFlow);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                rGraph[u][v] -= pathFlow;
                rGraph[v][u] += pathFlow;
            }
            printGraph(rGraph);
            max_flow += pathFlow;
        }

        boolean visited[] = new boolean[V];
        dfs(rGraph, s, visited);
        //for(boolean b:visited)
        //    System.out.print(b+" ");

        System.out.println(" ");
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (visited[i] && !visited[j] && graph[i][j] > 0)
                    System.out.println(i + "-" + j);
        return max_flow;

    }

}