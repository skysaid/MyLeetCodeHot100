package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Algorithm376 {
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;
        if(n<2)return n;
        int[] dp=new int[n];
        dp[0]=1;

        for (int i=1;i<n;i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i]>nums[i-1])dp[i]=2;
                else dp[i]=-2;
                break;
            }else {
                dp[i]=dp[i-1];
            }

        }

        for (int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if((nums[i]>nums[j])){
                    if (dp[j]<0){
                    if(Math.abs(dp[i])<(Math.abs(dp[j])+1)){
                        dp[i]=Math.abs(dp[j])+1;
                    }
                    }else {
                        if(Math.abs(dp[i])<(Math.abs(dp[j]))){
                            dp[i]=Math.abs(dp[j]);
                        }
                    }

                }else
                if((nums[i]<nums[j])){
                    if (dp[j]>0){
                    if(Math.abs(dp[i])<(Math.abs(dp[j])+1)){
                        dp[i]=-1*(Math.abs(dp[j])+1);
                    }
                    }else {
                        if(Math.abs(dp[i])<(Math.abs(dp[j]))){
                            dp[i]=-1*(Math.abs(dp[j]));
                        }
                    }

                }else
                {
                       if (Math.abs(dp[i])<Math.abs(dp[j])){
                           dp[i]=dp[j];
                       }
                }
            }
        }
        int res=0;
        for (int e:dp){
            System.out.print(e+" ");
            res=Math.max(res,Math.abs(e));
        }
        System.out.println();
        return res;
    }
    public int wiggleMaxLength2(int[] nums) {
        int n=nums.length;
        if (n<2)return n;
        int up[]=new int[n];
        int down[]=new int[n];
        up[0]=down[0]=1;
        for (int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                up[i]=down[i-1]+1;
                down[i]=down[i-1];
            }else if (nums[i]<nums[i-1]){
                up[i]=up[i-1];
                down[i]=up[i-1]+1;
            }else {
                up[i]=up[i-1];
                down[i]=down[i-1];
            }
        }
        return Math.max(up[n-1],down[n-1]);
    }

    public static void main(String[] args) {
        List<String> list= new ArrayList<>();
    }
}
