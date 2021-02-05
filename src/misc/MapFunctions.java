package misc;

import java.util.HashMap;
import java.util.Map;

public class MapFunctions {
    public static void main(String[] args) {
        Map<Character,Integer> a = new HashMap<>();
        System.out.println(a.computeIfAbsent('a', k->9));
        System.out.println(a.computeIfAbsent('a', k->4));
        a.put('b',5);
        a.put('b',6);
        System.out.println(a);
    }
}
