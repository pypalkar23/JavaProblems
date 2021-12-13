package leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LRUCacheCoderbyte {
    public static String LRUCache(String[] strArr){
        Set<String> set = new HashSet<String>();
        List<String> list = new ArrayList<String>();
        
        for(String s: strArr){
            if(set.contains(s)){
                list.remove(s);
            }
            else if(list.size()==5){
                list.remove(0);
            }
            list.add(s);
            set.add(s);
            //System.out.println(String.join("-", list));
        }

        return String.join("-", list);
    }

    public static void main(String[] args) {
        String a[] = new String[]{"A","B","C","D","A","E","D","Z"};
        String res = new LRUCacheCoderbyte().LRUCache(a);
        System.out.println(res);
        String b[] = new String[]{"A","B","A","C","A","B"};
        String res1= new LRUCacheCoderbyte().LRUCache(b);
        System.out.println(res1);
        String c[] = new String[]{"A","B","C","D","E","D","Q","Z","C"};
        String res2= new LRUCacheCoderbyte().LRUCache(c);
        System.out.println(res2);
        System.out.println(String.join("-",new ArrayList<String>()));
    }
}
