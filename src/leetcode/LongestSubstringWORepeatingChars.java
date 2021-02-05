package leetcode;

import java.util.HashMap;
import java.util.Map;
/*3. Longest Substring Without Repeating Characters*/
public class LongestSubstringWORepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int repeatCharIndex = -1;
        int L = 0;
        int currMaxLength=0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            if (charMap.get(c)==null) {
                currMaxLength++;
                charMap.put(s.charAt(i), i);
            }
            else{
                repeatCharIndex= Math.max(charMap.get(c),repeatCharIndex); // consider
                charMap.put(c,i);
                L=Math.max(L,currMaxLength);
                currMaxLength= i-repeatCharIndex;
            }
        }
        L= Math.max(L,currMaxLength);
        return L;
    }

    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int repeatCharIndex = -1;
        int L = 0;
        int currMaxLength=0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c= s.charAt(i);
            Integer prevIndex = charMap.put(c,i); // returns null if no key is present otherwise previous value
            if (prevIndex==null) {
                currMaxLength++;
                charMap.put(s.charAt(i), i);
            }
            else{
                repeatCharIndex= Math.max(prevIndex,repeatCharIndex); // consider abba as a string
                L=Math.max(L,currMaxLength);
                currMaxLength= i-repeatCharIndex;
            }
        }
        L= Math.max(L,currMaxLength);
        return L;
    }

    public static void main(String[] args) {
        String string=null; 
        if(args.length>0)
            string=args[0];
        System.out.println(new LongestSubstringWORepeatingChars().lengthOfLongestSubstring(string));
    }

    
}
