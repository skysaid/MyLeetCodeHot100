package test1;

import java.util.ArrayList;

public class Algorithm322 {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;

        if (n==0||amount<0)return -1;
        int[] dp=new int[amount+1];
        for (int i=0;i<dp.length;i++)dp[i]=amount+1;
        dp[0]=0;
        for (int i=1;i<=amount;i++){
            for (int j=0;j<n;j++){
                if((i-coins[j])>=0){
                dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return (dp[amount]==amount+1)?-1:dp[amount];
    }


    public static void main(String[] args) {
        int[] nus=new int[]{1,2,3};

        ArrayList<Integer> list= new ArrayList<>();

    }


}
