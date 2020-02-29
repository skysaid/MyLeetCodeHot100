package test1;

public class Algorithm300 {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int[] dp=new int[n];
        for (int i=0;i<n;i++){
            dp[i]=1;
        }
        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if(nums[i]>nums[j])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
        }
        int res=0;
        for (int e:dp){
            System.out.print(e+" ");
            res=Math.max(res,e);
        }
        return res;
    }
    public int lengthOfLIS2(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        int[] dp=new int[n];
        int res=0;
        for (int num:nums){
            int left=0;
            int right=res;
            while(left<right){
                int mid=(left+right)/2;
                if(num>dp[mid]){
                    left=mid+1;
                }else {
                    right=mid;
                }
            }
            dp[left]=num;
            if(right==res)res++;

        }
        for (int e:dp){
            System.out.print(e+" ");
        }
        return res;
    }
}
