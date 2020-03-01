package test1;

public class Algorithm53 {
    //暴力解 超出时间限制O(n^3)
    public int maxSubArray1(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;

        int count=Integer.MIN_VALUE;

        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
            int sum=0;
                for (int k=i;k<=j;k++){
                    sum+=nums[k];
                    count=Math.max(count,sum);
                }
            }
        }
        return count;
    }

    //动态规划
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;

        int[] dp=new int[n];
        dp[0]=nums[0];
        int res=nums[0];
        //状态：以i为结尾的子序列的最大和，f(i)=max(nums[i],f(i-1)+nums(i))
        for (int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;

    }

}
