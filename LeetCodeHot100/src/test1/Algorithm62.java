package test1;

public class Algorithm62 {
    public int uniquePaths2(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                 if(i==0){
                     dp[0][j]=1;
                 }else if(j==0){
                     dp[i][0]=1;
                 }else{
                     dp[i][j]=dp[i-1][j]+dp[i][j-1];
                 }
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        return helper(dp,0,0);
    }
    int helper(int[][] dp,int m,int n){
        if(m==dp.length-1||n==dp[0].length-1){
            return 1;
        }
        int l=0;
        int r=0;
        if(dp[m][n]>0)return dp[m][n];
        if(m<dp.length-1){
            l=helper(dp,m+1,n);
        }
        if (n<dp[0].length-1){
            r=helper(dp,m,n+1);

        }
        dp[m][n]=l+r;
        return dp[m][n];
    }
}
