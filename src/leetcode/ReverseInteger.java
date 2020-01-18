package leetcode;
class ReverseInteger{
    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(-153));
        System.out.println(r.reverse(1534236469));
    }

    public int reverse(int x) {
        boolean isNeg=false;
        if(x<0)
        {
            isNeg=true;
            x=-1*x;
        }
        
        int stored=x;
        int ans=0;
        while(stored>0){
            int prev = ans;
            int temp=stored%10;
            stored =  stored/10;
            ans = ans*10 + temp;
            System.out.println((ans-temp)/10+" "+prev);
            if((ans-temp)/10!=prev){
                ans=0;
                break;
            }
        }
        
        if(isNeg)
            ans = ans  * (-1);
        return ans;
        
    }
}