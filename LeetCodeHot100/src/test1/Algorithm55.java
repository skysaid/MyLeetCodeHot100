package test1;

public class Algorithm55 {
    //动态规划自底向上
    public boolean canJump1(int[] nums) {
        int[] dp=new int[nums.length];
        dp[nums.length-1]=1;
        for (int i=nums.length-2;i>=0;i--){
            for (int j=1;j<=nums[i]&&i+j<=nums.length-1;j++){
                if (dp[i+j]==1)dp[i]=1;
            }
        }
        return dp[0]==1?true:false;
    }
    //贪心算法
    public boolean canJump(int[] nums) {
        int lastcanjump=nums.length-1;

        for (int i=nums.length-2;i>=0;i--){
            if (nums[i]+i>=lastcanjump)lastcanjump=i;
        }
        return lastcanjump==0;
    }
}
