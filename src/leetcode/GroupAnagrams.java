package leetcode;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
    public static void main(String[] args) {
        
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anagramGroups = new HashMap<String,List<String>>();
        if(strs.length==0)
            return new ArrayList<List<String>>();
        
        for(String s:strs){
            char sArr[]= s.toCharArray();
            Arrays.sort(sArr);
            String key= new String(sArr);
            anagramGroups.putIfAbsent(key,new ArrayList<String>().);

            List<String> listofString = anagramGroups.get(key);
            listofString.add(s);
            anagramGroups.put(key, listofString);
        }
        
        List<List<String>> answer= new ArrayList<List<String>>(anagramGroups.values());
        return answer;
    }

}