package test1;

import java.util.HashMap;
import java.util.Map;

public class Algorithm279 {
    public int numSquares(int n) {
       int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<n+1;i++){
            dp[i]=i;
            for(int j=1;j*j<i+1;j++){
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);

            }
        }

        return dp[n];

    }
    Map<Integer,Integer> map=new HashMap<>();
    int helper(int n){
        if(n==1)return 1;
        if(n==0)return 0;
        int res=Integer.MAX_VALUE;
        if(map.containsKey(n))return map.get(n);
        for (int i=1;(i*i)<n+1;i++){
            res=Math.min(res,1+helper(n-i*i));

        }
        map.put(n,res);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Math.pow(3,0.5));
        int[] a=new int[1024];
        System.out.println(a[0]);
    }
}
