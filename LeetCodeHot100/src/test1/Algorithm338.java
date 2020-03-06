package test1;

public class Algorithm338 {
    //暴力解
    public int[] countBits1(int num) {
        int[] dp= new int[num];
        dp[0]=0;
        if (num==0)return dp;
        dp[1]=1;

        for (int i=2;i<=num;i++){
            int res=0;
            int temp=i;
            while(temp>0){
                temp=temp&(temp-1);
                res++;
            }
            dp[i]=res;
//            dp[i]=dp[i-2]+1;
        }
        return dp;

    }
    //动态规划 状态转移：f(i+b)=f(i)+1;b=2^n
    public int[] countBits(int num) {
        int[] dp= new int[num+1];
        int b=1;
        while(b<=num){
            for (int i=0;i<b&&i+b<=num;i++){
                dp[i+b]=dp[i]+1;
            }
            b=b<<1;
        }
        return dp;

    }
}
