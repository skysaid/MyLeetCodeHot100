package test1;

public class Algorithm494 {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int S) {
        int n=nums.length;
        if(n==0)return 0;
        int sum=0;
        for (int e:nums)sum+=e;
        dp=new int[n][2000];
        int res=tryfind(nums,S,0);
        return res;
    }

    private int tryfind(int[] nums, int target, int index){
        if(index==nums.length){
            return target==0?1:0;
        }
        if(dp[index][target+1000]!=0)return dp[index][target+1000];
        int res=tryfind(nums,target+nums[index],index+1)+tryfind(nums,target-nums[index],index+1);
        dp[index][target+1000]=res;
        return res;
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target || (sum+target)%2 == 1){
            return 0;
        }
        target = (target + sum) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
                System.out.print(""+i+":"+dp[i]+" ");

            }
            System.out.println();
        }
        return dp[target];
    }


}
