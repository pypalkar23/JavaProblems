import java.util.LinkedList;
import java.util.Queue;

class BreadthFirstSearch{
    static LinkedList<Integer> a[]=new LinkedList[5];
    static Boolean[] visited=new Boolean[5];
    static Queue<Integer> queue=new LinkedList<Integer>();
    public static void main(String[] args) {
        for(int i=0,n=a.length;i<n;i++){
            a[i]=new LinkedList<Integer>();
            visited[i]=false;
        }
        a[0].add(1);
        a[0].add(2);
        a[0].add(3);
        a[0].add(4);
        a[1].add(0);
        a[1].add(3);
        a[2].add(0);
        a[2].add(4);
        a[3].add(1);
        a[4].add(0);
        a[4].add(2);
        queue.add(2);
        visited[2]=true;
        bfs();
    }

    public static void bfs()
    {
        while(!queue.isEmpty())
        {
            int current=queue.remove();
            System.out.println(current+" ");
            for (int var : a[current]) {
                if(!visited[var]){
                    queue.add(var);
                    visited[var]=true;
                }
            }
        }

    }
}
