package test1;

public class Algorithm309 {
    //动态规划 状态：0-x天最大的利润，
//    dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
//    max(   选择 rest  ,           选择 sell      )
//
//    解释：今天我没有持有股票，有两种可能：
//    要么是我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
//    要么是我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
//
//    dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
//    max(   选择 rest  ,           选择 buy         )
//
//    解释：今天我持有着股票，有两种可能：
//    要么我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
//    要么我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。

// 由于此题不限制购买次数，所以k可以忽略

    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len <= 1)return 0;
        int[][] dp =new int[len][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[1][0]=Math.max(0,dp[0][1]+prices[1]);
        dp[1][1]=Math.max(dp[0][1],dp[0][0]-prices[1]);
        for (int i=2;i<len;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[len-1][0];
    }
    //减少空间
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1)return 0;
        int dp_i_0=0;
        int dp_i_1=-prices[0];
        int pre=0;
        for (int i=1;i<len;i++){
            int temp=dp_i_0;
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,pre-prices[i]);
            pre=temp;
        }
        return dp_i_0;
    }

}
