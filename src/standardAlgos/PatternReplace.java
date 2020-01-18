
/*890. Find and Replace Pattern*/
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

class PatternReplace {
    public static void main(String[] args) {
        PatternReplace p= new PatternReplace();
        String words[]={"abc","deq","mee","aqq","dkd","ccc"};   
        String pattern = "abb";
        List<String> ans = p.findAndReplacePattern(words, pattern);
        for(String s:ans)
            System.out.print(s+",");
        System.out.println("");
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        if (pattern == null || pattern.length() == 0)
            return new ArrayList<String>();
        if (words.length == 0)
            return new ArrayList<String>();
        List<String> res = new ArrayList<String>();
        int[] Fp = normalize(pattern);
        for (String w : words) {
            int[] Fw = normalize(w);
            if (Arrays.equals(Fp, Fw))
                res.add(w);
        }

        return res;

    }

    public int[] normalize(String str) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int res[] = new int[str.length()];
        for (int i = 0, n = str.length(); i < n; i++) {
            map.putIfAbsent(str.charAt(i), map.size());
            res[i] = map.get(str.charAt(i));
        }
        return res;
    }

}