package standardalgos;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;


class BFS{

    
    public static void main(String[] args){
        List<Integer> graph[] = new LinkedList[8];
        for (int i=0;i<=7;i++){
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

        BFS(graph, 0);
    }

    public static void BFS(List<Integer>graph[], int start){
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> toTraverse = new LinkedList<Integer>();
        toTraverse.add(start);
        while(toTraverse.size()!=0){
            int node = toTraverse.remove();
            if(!visited.contains(node)){
                System.out.println(node);
                List<Integer> current = graph[node];
                for(int i:current){
                    toTraverse.add(i);
                }
                visited.add(node);
            }
            
        }
        
    }
}