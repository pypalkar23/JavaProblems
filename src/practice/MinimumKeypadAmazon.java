package practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.transform.SourceLocator;

import java.util.Arrays;

public class MinimumKeypadAmazon {
    public static void main(String[] args) {
        System.out.println(solution("abcabcd"));
        System.out.println(solution("abcghdiefjoba"));
        System.out.println(solution("aaaaaa"));

    }
    
    public static int startsWith(String text){
        
        int result = 0;
        for(int i=0;i<text.length;i++){
            int k = 0;
           for(int j=0;j<text.length;j++){
                for()
           }
        }
        return 0;
    }
    public static int solution(String text){

        int counter = 0;
        int result = 0;
        int charCount[]= new int[26];
        for(int i=0;i<text.length();i++){
            charCount[text.charAt(i)-'a']++;
        }

        Arrays.sort(charCount);
        
        for(int i:charCount){
            if(i>0){
                result+= counter/9+1 * i;
                counter++;
            }
        }
        
        return result;
    }


}
