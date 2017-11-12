package hackerrank;

import java.util.HashSet;
import java.util.Set;

class NonDivisibleSubset{
    public static void main(String[] args) {
        int a[]={1,7,2,4};
        int k=3;

        Set<Integer> s=new HashSet<Integer>();
        Set<Integer> reminders=new HashSet<Integer>();
        
        for(int r:reminders)
            System.out.println(r);
        

        for(int i:a)
        {
                int tempReminder=i%k;
                if(reminders.contains(k-tempReminder)){
                    s.remove(i);
                }
        }

        System.out.println(s.size());
        
    }
}