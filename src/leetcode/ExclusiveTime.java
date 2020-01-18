package leetcode;
/*636. Exclusive Time of Functions*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

//redo by stack
class ExclusiveTime {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        int prevTime = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (String s : logs) {
            String current[] = s.split(":");
            if (!stack.isEmpty())
                ans[stack.peek()] += Integer.parseInt(current[2]) - prevTime;
            prevTime = Integer.parseInt(current[2]);
            if (current[1].equals("start")) {
                stack.push(Integer.parseInt(current[0]));
            } else {
                ans[stack.pop()]++;
                prevTime++;
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        ExclusiveTime e = new ExclusiveTime();
        List<String> q = new ArrayList<String>();
        q.add("0:start:0");
        q.add("0:start:2");
        q.add("0:end:5");
        q.add("1:start:7");
        q.add("1:end:7");
        q.add("0:end:8");

        int a[] = e.exclusiveTime(2, q);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}