package leetcode;
import java.util.Arrays;

class CountChange{
    public int countChange(int money,int a[])
    {
        return countChangeHelper(0, money, a);
    }

    public int countChangeHelper(int sum,int money,int a[]){
        int combos=0;
        if(a.length==0)
            return 0;
        else
            if(sum+a[0]<money)
                combos+=countChangeHelper(sum+a[0], money, a);
            else if(sum+a[0]==money)
                combos+=1+countChangeHelper(sum,money,Arrays.copyOfRange(a, 1, a.length));
            else
                combos+=countChangeHelper(0, money, Arrays.copyOfRange(a, 1, a.length));
        
        return combos;
    }

    public static void main(String[] args) {
        int a[]={1,2};
        CountChange c=new CountChange();
        System.out.println(c.countChange(4, a));
    }
}