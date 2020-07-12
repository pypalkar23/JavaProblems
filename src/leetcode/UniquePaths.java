package leetcode;


//62. Unique Paths
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths2(7, 3));
    }   
    
    public int uniquePaths(int m, int n) {
        int mat[][] = new int[m][n];
        for(int i=0;i<m;i++)
            mat[i][0]=1;
        for(int j=0;j<n;j++)
            mat[0][j]=1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                mat[i][j]= mat[i-1][j]+mat[i][j-1];
            }
        return mat[m-1][n-1];
    }

    //memory efficient
    public int uniquePaths2(int m, int n) {
        int mat[] = new int[n];
        mat[0]=1;
        for(int i=0;i<m;i++)
            for(int j=1;j<n;j++){
                mat[j]+=mat[j-1];
            }
        return mat[n-1];
    }
}