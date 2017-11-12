class CountSubstrings{
    public int countSubstrings(String s){
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int res=0;
        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++)
            {
                dp[i][j]= (s.charAt(i)==s.charAt(j))&&(j-i<3 || dp[i+1][j-1]);
                if(dp[i][j])res++;
            }
        
        return res;
    }

    public String longestPalindromeSubstring(String s){
        int n=s.length();
        int dp[][]=new int[n][n];
        int res=0;
        int len=0,end=0,start=0;
        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++)
            {
                if((s.charAt(i)==s.charAt(j))&&(j-i<3 || dp[i+1][j-1]>0)){
                    dp[i][j]=1;
                if(j-i+1>len)
                {
                    start=i;
                    end=j+1;
                }

                }
            }
    
        return s.substring(start,end);
    }

  
    public static void main(String[] args) {
        CountSubstrings cS=new CountSubstrings();
        System.out.println(cS.longestPalindromeSubstring("abac"));
    }
}