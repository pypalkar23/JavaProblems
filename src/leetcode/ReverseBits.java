package leetcode;
/*190. Reverse Bits*/
class ReverseBits{
    public static void main(String[] args) {
        ReverseBits r= new ReverseBits();
        System.out.println(r.reverseBits(43261596));
    }
    public int reverseBits(int n) {
        System.out.println(Integer.toBinaryString(n));
        int ans=0;
        for(int i=0;i<32;i++){
            int bit=n&1;
            ans<<=1;
            if(bit==1){
                ans+=1;
            }
            n>>=1;
        }
        System.out.println(Integer.toBinaryString(ans));
        return ans;
    }
}