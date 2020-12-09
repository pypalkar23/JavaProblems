package leetcode;

import java.util.ArrayList;
import java.util.List;
/*17. Letter Combinations of a Phone Number*/
public class LetterCombinations {
    char charMap[][]={{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
   public static void main(String[] args) {
       List<String> result= new LetterCombinations().letterCombinations("234");
       for(String s:result){
           System.out.println(s);
       }
   }

   public List<String> letterCombinations(String digits) {
       List<String> result = new ArrayList<>();
        util(digits, 0, new StringBuffer(), result);
        return result;
    }

    public void util(String digitCode, int currentDigit, StringBuffer sb, List<String> result){
        if(sb.length()==digitCode.length()){
            result.add(sb.toString());
            return;
        }

        char[] currCharMap = charMap[digitCode.charAt(currentDigit)-'0'];
        for(int i=0,n=currCharMap.length;i<n;i++){
           
            sb.append(currCharMap[i]);
            util(digitCode, currentDigit+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
/*
23

a b c
d e f
*/