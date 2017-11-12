import java.util.Arrays;



class BalanceParenthesis{
    public static void main(String[] args) {
        BalanceParenthesis b=new BalanceParenthesis();
        System.out.println(b.balance(":-)".toCharArray()));
    }
    
    public boolean balance(char[] sentence){
        return balanced(sentence, 0);
    }

    public boolean balanced(char[] sentence,int open){
        if(sentence.length==0)
            return open==0;
        else
            if(sentence[0]=='(')
                return balanced(Arrays.copyOfRange(sentence, 1, sentence.length),open+1);
            else 
            {
                if(sentence[0]==')')
                   return(open>0 && balanced(Arrays.copyOfRange(sentence, 1, sentence.length), open-1));
                else 
                    return balanced(Arrays.copyOfRange(sentence, 1, sentence.length), open);  
            }
    }
}