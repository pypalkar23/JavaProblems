package misc;
import java.util.PriorityQueue;
import java.util.Queue;

class PriorityQueueExample{
    public static void main(String[] args) {
        Queue<String> pQueue=new PriorityQueue<String>();
        pQueue.add("ACB");
        pQueue.add("ABC");
        
        for(String s:pQueue)
            System.out.println(s);
    }
}