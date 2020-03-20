package test1;

public class Algorithm221 {
    //动态规划，dp[i,j]是在左上角矩阵中由matrix[i-1][j-1]参与构成的最大正方形边长。状态转移：dp[i,j]=min(dp[i-1,j],dp[i-1,j-1],dp[i,j-1])
    public int maximalSquare(char[][] matrix) {
        int rlen=matrix.length;
        int clen=rlen>0?matrix[0].length:0;
        int maxlen=0;
        int[][] dp=new int[rlen+1][clen+1];

        for (int i=1;i<=rlen;i++){
            for (int j=1;j<=clen;j++){
                if (matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    maxlen=Math.max(maxlen,dp[i][j]);
                }
            }
        }
        return maxlen*maxlen;
    }
    //动态规划内存优化
    public int maximalSquare2(char[][] matrix) {
        int rlen=matrix.length;
        int clen=rlen>0?matrix[0].length:0;
        int maxlen=0,pre=0;
        int[] dp=new int[rlen+1];

        for (int i=1;i<=rlen;i++){
            for (int j=1;j<=clen;j++){
                int temp=dp[j];
                if (matrix[i-1][j-1]=='1'){
                    dp[j]=Math.min(Math.min(dp[j-1],pre),dp[j])+1;
                    maxlen=Math.max(maxlen,dp[j]);
                }else {
                    dp[j]=0;
                }
                pre=temp;
            }
        }
        return maxlen*maxlen;
    }
}
