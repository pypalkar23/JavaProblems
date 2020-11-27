package leetcode;
/*131. Palindrome Partitioning.*/
import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        List<List<String>> ans= new PalindromePartitioning().partition("aaba");
        for (List<String> l : ans) {
            for (String s : l)
                System.out.print(s + " ");
            System.out.println("");
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> finalResult = new ArrayList<>();
        List<String> intermediateCombos = new ArrayList<>();
        findCombos(s, 0, finalResult, intermediateCombos);
        return finalResult;
    }

    public void findCombos(String s, int start, List<List<String>> finalResult, List<String> intermediateCombos) {
        if (start == s.length()) {
            //that means we have traversed till the end and its safe to add intermediate combos to main list
            finalResult.add(new ArrayList<String>(intermediateCombos));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(isPalidrome(s, start, i)){
                intermediateCombos.add(s.substring(start, i+1));
                //find the next palindromes after current partition i
                findCombos(s, i+1, finalResult, intermediateCombos);
                intermediateCombos.remove(intermediateCombos.size()-1);
            }
        }
    }

    public boolean isPalidrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}