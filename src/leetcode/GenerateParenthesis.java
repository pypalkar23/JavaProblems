package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> result = gp.generateParenthesis(3);
        for (String s : ans) {
            System.out.println(s);
        }

    }

    public List<String> generateParenthesis(int n) {
        util("", 0, 0, n);
        return ans;
    }

    public void util(String str, int l, int r, int n) {
        if (l == n && r == n) {
            ans.add(str);
            return;
        }

        if (l < n) {
            util(str + "(", l + 1, r, n);
        }

        if (r < l) {
            util(str + ")", l, r + 1, n);
        }
    }

}