package standardalgos;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

class DFS {

    static Set<Integer> visited = new HashSet<Integer>();
    public static void main(String[] args) {
        List<Integer> graph[] = new LinkedList[8];
        for (int i = 0; i <= 7; i++) {
            graph[i] = new LinkedList<Integer>();
        }

        graph[0].add(1);
        graph[0].add(2);
        graph[0].add(3);
        graph[1].add(4);
        graph[1].add(5);
        graph[2].add(6);
        graph[2].add(7);
        graph[3].add(7);

        dfs(graph, 0);
    }

    public static void dfs(List<Integer> graph[], int node) {
        
        System.out.println(node);
        visited.add(node);
        List<Integer> current = graph[node];
        for (int i : current) {
            if (!visited.contains(i))
                dfs(graph, i);
        }
    }
}