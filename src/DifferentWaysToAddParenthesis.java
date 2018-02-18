import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.List;

import java.util.List;

class DifferentWaysToAddParenthesis {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        boolean flag=false;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                flag=true;
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                for (int f : result1) {
                    for (int s : result2) {
                        switch (input.charAt(i)) {
                        case '+':
                            result.add(f + s);
                            break;
                        case '-':
                            result.add(f - s);
                            break;
                        case '*':
                            result.add(f * s);
                            break;
                        }
                    }
                }
            }
            

        }
        if(flag==false){
            //sSystem.out.println(input);
            result.add(Integer.parseInt(input));
        }
        return result;
    }

    public static void main(String[] args) {
        DifferentWaysToAddParenthesis df=new DifferentWaysToAddParenthesis();
        List<Integer> result=df.diffWaysToCompute("2*3-4*5");
        for (int i:result)
            System.out.println(i+" ");
        
    }
}